package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.domains.*;
import pro.metrus.fvsr.repositories.CountryRepository;
import pro.metrus.fvsr.repositories.CompetitionsRepository;
import pro.metrus.fvsr.repositories.FederalSubjectRepository;
import pro.metrus.fvsr.repositories.VidRepository;

import java.util.List;

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
    private final FederalSubjectRepository federalSubjectRepository;
    private final CountryRepository countryRepository;
    private final VidRepository vidRepository;

    /**
     * Конструктор для внедрения зависимостей
     *
     * @param competitionsRepository Репозиторий для работы с соревнованиями, не должен
     *                               быть null, иначе будет выброшено NPE
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

    @ModelAttribute("federalSubjects")
    public List<FederalSubject> federalSubjects() {
        return federalSubjectRepository.findAll();
    }

    @ModelAttribute("countries")
    public List<Country> countries() {
        return countryRepository.findAll();
    }

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

    @GetMapping("/create")
    public String create(final Model ui) {
        ui.addAttribute("form", new Competitions());

        return "competition-create";
    }
}
