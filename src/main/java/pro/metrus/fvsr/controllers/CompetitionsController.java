package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pro.metrus.fvsr.domains.Competitions;
import pro.metrus.fvsr.domains.Country;
import pro.metrus.fvsr.domains.FederalSubject;
import pro.metrus.fvsr.domains.Vid;
import pro.metrus.fvsr.repositories.CompetitionsRepository;
import pro.metrus.fvsr.repositories.CountryRepository;
import pro.metrus.fvsr.repositories.FederalSubjectRepository;
import pro.metrus.fvsr.repositories.VidRepository;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер для работы с соревнованиями, стандартный CRUD
 */
@Controller
@RequestMapping("/competitions")
public class CompetitionsController {

    private static final String FORM_ATTR = "form";

    /**
     * Репозиторий для работы с соревнованиями
     */
    private final CompetitionsRepository competitionsRepository;

    /**
     * Repository for work with federal subjects
     */
    private final FederalSubjectRepository federalSubjectRepository;

    /**
     * Repository for work with countries
     */
    private final CountryRepository countryRepository;

    /**
     * Repository for work with "Вид"
     */
    private final VidRepository vidRepository;

    /**
     * Конструктор для внедрения зависимостей
     *
     * @param competitionsRepository   Репозиторий для работы с соревнованиями, не должен
     *                                 быть null, иначе будет выброшено NPE
     * @param federalSubjectRepository Repository for work with federal subjects, must be
     *                                 not null
     * @param countryRepository        Repository for work with countries, must be not null
     * @param vidRepository            Repository for work with "Виды", must be not null
     */
    @Autowired
    public CompetitionsController(
            final CompetitionsRepository competitionsRepository,
            final FederalSubjectRepository federalSubjectRepository,
            final CountryRepository countryRepository,
            final VidRepository vidRepository
    ) {
        this.competitionsRepository = competitionsRepository;
        this.federalSubjectRepository = federalSubjectRepository;
        this.countryRepository = countryRepository;
        this.vidRepository = vidRepository;
    }

    /**
     * Load all federal subjects to template
     * <p>
     * Load federal subjects to template for render select which
     * contains all federal subjects, it will inject to {@link Competitions}
     * entity
     *
     * @return Federal subjects list
     */
    @ModelAttribute("federalSubjects")
    public List<FederalSubject> federalSubjects() {
        return federalSubjectRepository.findAll();
    }

    /**
     * Load all countries to template
     * <p>
     * This method load all countries for rendering select in template for
     * selecting specify country and inject it to {@link Competitions}
     *
     * @return Countries list
     */
    @ModelAttribute("countries")
    public List<Country> countries() {
        return countryRepository.findAll();
    }

    /**
     * Load all vids to template
     * <p>
     * This method load all vids to template for rendering special select
     * and inject selected value to {@link Competitions}
     *
     * @return Vids list
     */
    @ModelAttribute("vids")
    public List<Vid> vids() {
        return vidRepository.findAll();
    }

    /**
     * Страница для отображения списка соревнований
     *
     * @param ui       Spring UI
     * @param pageable Bean пагинации для Spring Data пагинации
     * @return Название шаблона
     */
    @GetMapping
    public String list(final Model ui, final Pageable pageable) {
        ui.addAttribute("competitions", competitionsRepository.findAllByOrderByIdAsc(pageable));

        return "competitions";
    }

    /**
     * This page uses for create new competitions, it contains
     * special form
     *
     * @param ui Spring ui model
     * @return template for rendering
     */
    @GetMapping("/create")
    public String create(final Model ui) {
        ui.addAttribute(FORM_ATTR, new Competitions());

        return "competition-create";
    }

    /**
     * This method load competition entity by id and return it to
     * template for edit
     *
     * @param ui Spring ui model
     * @return Edit template name
     */
    @GetMapping("/{id}/update")
    public String update(final Model ui, @PathVariable final long id) {
        ui.addAttribute(FORM_ATTR, competitionsRepository.findOne(1L));

        return "competition-update";
    }

    /**
     * Processing creation or update competition
     * <p>
     * This method process request which create new competition in
     * system and redirect after save to competitions list
     *
     * @param form             New competition form
     * @param validationResult Result of validation new competition
     * @return Redirect to create competition page with validation errors
     * or redirect to competition list if competition successful created
     */
    @PostMapping("/save")
    public String create(@Valid @ModelAttribute(FORM_ATTR) final Competitions form,
                         final BindingResult validationResult) {
        if (validationResult.hasErrors()) {
            // Render page with errors
            return form.getId() > 0 ? "competition-update" : "competition-create";
        }

        competitionsRepository.save(form);
        return "redirect:/competitions";
    }
}
