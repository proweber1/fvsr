package pro.metrus.fvsr.core;

import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pro.metrus.fvsr.exceptions.NotFoundException;
import pro.metrus.fvsr.repositories.custom.DefaultOrderableByIdRepository;

import javax.validation.Valid;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * Стандартная имплементация crud операций для любого контроллера, призван для
 * того чтобы избавиться от дублирования при разработке одинаковых контроллеров
 *
 * @param <T>  Тип сущности с которой работает система
 * @param <ID> Тип первичного ключа сущности для поиска
 */
public abstract class AbstractCrudController<T, ID extends Number> {

    /**
     * Имя шаблона который используется для отображения сущности
     */
    private static final String SHOW_TEMPLATE_NAME = "show";

    /**
     * Имя шаблона который используется для создания новой сущности
     */
    private static final String CREATE_TEMPLATE_NAME = "create";

    /**
     * Имя шаблона которое используется для обновления сущностей
     */
    private static final String UPDATE_TEMPLATE_NAME = "update";

    /**
     * Список сущностей
     */
    private static final String LIST_TEMPLATE_NAME = "list";

    /**
     * Метод который будет пытаться вызвать класс для получения ID'шника
     */
    private static final String GET_ID_METHOD_NAME = "getId";

    /**
     * Аттрибут который обозначает форму в шаблонах
     */
    private static final String FORM_ATTR = "form";

    /**
     * Класс сущности, используется для того чтобы сгенерировать из него
     * форму для шаблонов
     */
    private final Class<T> entityClass;

    /**
     * Репозиторий для управления данными
     */
    private final DefaultOrderableByIdRepository<T, ID> repository;

    /**
     * Название папки которое будет использоваться для того чтобы
     * загружать шаблоны
     */
    private final String templatePathName;

    /**
     * @param entityClass Класс сущности
     * @param repository  Репозиторий для управления данными
     */
    public AbstractCrudController(
            final Class<T> entityClass,
            final DefaultOrderableByIdRepository<T, ID> repository
    ) {
        this(entityClass, repository, entityClass.getSimpleName().toLowerCase());
    }

    /**
     * Этот конструктор используется для того чтобы создавать
     * контроллеры со специфичной именнованой частью для поиска
     * шаблонов
     *
     * @param entityClass Класс сущности
     * @param repository Класс репозиторий
     * @param templatePathName Имя папки для поиска шаблонов
     */
    public AbstractCrudController(
            final Class<T> entityClass,
            final DefaultOrderableByIdRepository<T, ID> repository,
            final String templatePathName
    ) {
        this.entityClass = entityClass;
        this.repository = repository;
        this.templatePathName = templatePathName;
    }

    /**
     * Загрузить список все сущностей в шаблон
     *
     * @param ui       Spring UI Model
     * @param pageable Spring Pageable interface
     * @return Название шаблона для отображения списка сущностей
     */
    @GetMapping
    public String list(final Model ui, final Pageable pageable) {
        ui.addAttribute("items", repository.findAllByOrderByIdAsc(pageable));

        return getTemplateName(LIST_TEMPLATE_NAME);
    }

    /**
     * Загрузить конкретную сущность по ID
     *
     * @param ui Spring UI model
     * @param id ID сущности для загрузки
     * @return Название шаблона которое отобразить сущность
     */
    @GetMapping("/{id}")
    public String show(final Model ui, @PathVariable final ID id) {
        ui.addAttribute("entity", findOrFail(id));

        return getTemplateName(SHOW_TEMPLATE_NAME);
    }

    /**
     * Отображение формы для создания новой сущности
     *
     * @param ui Spring UI Model
     * @return Название страницы для отображения формы создания
     * @throws IllegalAccessException Приватный конструктор у сущности
     * @throws InstantiationException Не удалось создать объект формы
     */
    @GetMapping("/create")
    public String create(final Model ui)
            throws IllegalAccessException, InstantiationException {
        ui.addAttribute(FORM_ATTR, entityClass.newInstance());

        return getTemplateName(CREATE_TEMPLATE_NAME);
    }

    /**
     * Загрузить форму для обновления сущности в системе
     *
     * @param ui Spring UI Model
     * @param id ID сущности для обновления
     * @return Название страницы для обновления сущности
     */
    @GetMapping("/{id}/update")
    public String update(final Model ui, @PathVariable final ID id) {
        ui.addAttribute(FORM_ATTR, findOrFail(id));

        return getTemplateName(UPDATE_TEMPLATE_NAME);
    }

    /**
     * Обработать сохранение сущности через форму отправки
     *
     * @param form          Форма сущности
     * @param bindingResult Результат валидации формы
     * @return Редирект к просмотру, либо страница с формой и ошибками валидации
     * @throws InvocationTargetException Не удалось получить доступ к методу
     * @throws IllegalAccessException    Приватный метод
     * @throws NoSuchMethodException     Метода не существует
     */
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute(FORM_ATTR) final T form,
                       final BindingResult bindingResult)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        if (bindingResult.hasErrors()) {
            // Render page with errors
            return getEntityId(form) > 0
                    ? getTemplateName(UPDATE_TEMPLATE_NAME)
                    : getTemplateName(CREATE_TEMPLATE_NAME);
        }

        repository.save(form);
        return "redirect:" + getEntityId(form);
    }

    /**
     * Получает ID из сущности и возвращает его
     *
     * @param entity Сущность
     * @return ID сущности
     * @throws NoSuchMethodException     Метода не существует
     * @throws InvocationTargetException Не удалось вызвать метод
     * @throws IllegalAccessException    Не удалось вызвать метод
     */
    @SuppressWarnings("unchecked")
    private long getEntityId(final T entity)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        final Method getIdMethod = entity.getClass().getDeclaredMethod(GET_ID_METHOD_NAME);
        return ((ID) getIdMethod.invoke(entity)).longValue();
    }

    /**
     * Находит сущность в базе данных и возвращает ее, если сущность в
     * базе данных не существует, выбросит {@link NotFoundException}
     *
     * @param id ID сущности
     * @return Объект сущности
     */
    private T findOrFail(final ID id) {
        final T entity = repository.findOne(id);
        if (Objects.isNull(entity)) {
            throw new NotFoundException();
        }
        return entity;
    }

    /**
     * Имя шаблона для того чтобы не дублировать алгоритм вычисления шаблона
     * по всем экшенам контроллера
     *
     * @param viewName Имя вьюшки которую надо загрузить
     * @return Полное название для отображения
     */
    private String getTemplateName(final String viewName) {
        Objects.requireNonNull(viewName, "View name cannot be null!");

        return String.format("admin/pages/%s/%s", templatePathName, viewName);
    }
}
