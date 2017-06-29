package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.repositories.CompetitionsRepository;

import static java.util.Objects.requireNonNull;

/**
 * Контроллер для работы с соревнованиями, стандартный CRUD
 */
@Controller
@RequestMapping("/competitions")
public class CompetitionsController {

    /**
     * Репозиторий для работы с соревнованиями
     */
    private final CompetitionsRepository competitionsRepository;

    /**
     * Конструктор для внедрения зависимостей
     *
     * @param competitionsRepository Репозиторий для работы с соревнованиями, не должен
     *                               быть null, иначе будет выброшено NPE
     */
    @Autowired
    public CompetitionsController(final CompetitionsRepository competitionsRepository) {
        this.competitionsRepository = requireNonNull(
                competitionsRepository, "Competitions repository must be initialized");
    }

    /**
     * Страница для отображения списка соревнований
     *
     * @param ui Spring UI
     * @param pageable Bean пагинации для Spring Data пагинации
     * @return Название шаблона
     */
    @GetMapping
    public String list(final Model ui, final Pageable pageable) {
        ui.addAttribute("competitions", competitionsRepository.findAllByOrderByIdAsc(pageable));

        return "completions-list";
    }
}
