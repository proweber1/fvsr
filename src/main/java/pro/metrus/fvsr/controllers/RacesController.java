package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.core.AbstractCrudController;
import pro.metrus.fvsr.domains.Category;
import pro.metrus.fvsr.domains.Competitions;
import pro.metrus.fvsr.domains.Race;
import pro.metrus.fvsr.domains.RaceType;
import pro.metrus.fvsr.repositories.CategoriesRepository;
import pro.metrus.fvsr.repositories.CompetitionsRepository;
import pro.metrus.fvsr.repositories.RaceTypesRepository;
import pro.metrus.fvsr.repositories.RacesRepository;

import java.util.List;
import java.util.Objects;

/**
 * Controller which work with races
 */
@Controller
@RequestMapping("/races")
public class RacesController extends AbstractCrudController<Race, Long> {

    /**
     * Repository which work with race types
     */
    private final RaceTypesRepository raceTypesRepository;

    /**
     * Repository which work with categories
     */
    private final CategoriesRepository categoriesRepository;
    private final CompetitionsRepository competitionsRepository;

    /**
     * Dependency injection constructor
     *
     * @param racesRepository      Repository which work with races, must be not
     *                             null
     * @param raceTypesRepository  Repository for work with race types, must be not null
     * @param categoriesRepository Repository for work with categories, must be not null
     */
    @Autowired
    public RacesController(
            final RacesRepository racesRepository,
            final RaceTypesRepository raceTypesRepository,
            final CategoriesRepository categoriesRepository,
            final CompetitionsRepository competitionsRepository
    ) {
        super(Race.class, racesRepository, "races");

        this.raceTypesRepository = raceTypesRepository;
        this.categoriesRepository = categoriesRepository;
        this.competitionsRepository = competitionsRepository;
    }

    /**
     * This method load all race types to template
     *
     * @return Race types list
     */
    @ModelAttribute("raceTypes")
    public List<RaceType> raceTypes() {
        return raceTypesRepository.findAllByOrderByVidIdAsc();
    }

    /**
     * This method load all categories to template for build drop
     * down select box
     *
     * @return All categories
     */
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoriesRepository.findAllByOrderByShortNameAsc();
    }

    /**
     * This method load all competitions to tempalte for rendering
     * special select
     *
     * @return Competitions list
     */
    @ModelAttribute("competitions")
    public List<Competitions> competitions() {
        return competitionsRepository.findAll();
    }
}
