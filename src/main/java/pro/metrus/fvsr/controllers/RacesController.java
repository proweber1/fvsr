package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pro.metrus.fvsr.domains.Category;
import pro.metrus.fvsr.domains.Race;
import pro.metrus.fvsr.domains.RaceType;
import pro.metrus.fvsr.repositories.CategoriesRepository;
import pro.metrus.fvsr.repositories.RaceTypesRepository;
import pro.metrus.fvsr.repositories.RacesRepository;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller which work with races
 */
@Controller
@RequestMapping("/races")
public class RacesController {

    /**
     * Repository which work with races
     */
    private final RacesRepository racesRepository;

    /**
     * Repository which work with race types
     */
    private final RaceTypesRepository raceTypesRepository;

    /**
     * Repository which work with categories
     */
    private final CategoriesRepository categoriesRepository;

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
            final CategoriesRepository categoriesRepository
    ) {
        this.racesRepository = racesRepository;
        this.raceTypesRepository = raceTypesRepository;
        this.categoriesRepository = categoriesRepository;
    }

    /**
     * This method load all race types to template
     *
     * @return Race types list
     */
    @ModelAttribute("raceTypes")
    public List<RaceType> raceTypes() {
        return raceTypesRepository.findAllByOrderByIdAsc();
    }

    /**
     * This method load all categories to template for build drop
     * down select box
     *
     * @return All categories
     */
    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoriesRepository.findAllByOrderByIdAsc();
    }

    /**
     * This method load all races with pagination and return they to
     * page
     *
     * @param ui       Spring ui model
     * @param pageable Spring pagination bean
     * @return Races template name
     */
    @GetMapping
    public String list(final Model ui, final Pageable pageable) {
        ui.addAttribute("races", racesRepository.findAllByOrderByIdAsc(pageable));

        return "races";
    }

    /**
     * Page for create new races
     *
     * @param ui Spring model ui
     * @return Page for create new races
     */
    @GetMapping("/create")
    public String create(final Model ui) {
        ui.addAttribute("form", new Race());

        return "race-create";
    }

    /**
     * This method load special race for showing on page
     *
     * @param ui Spring ui model
     * @param id Race id
     * @return Template for rendering
     */
    @GetMapping("/{id}")
    public String show(final Model ui, @PathVariable("id") final long id) {
        ui.addAttribute("race", racesRepository.findOne(id));

        return "race-show";
    }

    /**
     * This method persist race form, it maybe new race or exist race
     * just for update
     *
     * @param form          Race form
     * @param bindingResult Race form validation result
     * @return Redirect or page for view race
     */
    @PostMapping("/save")
    public String process(@Valid @ModelAttribute("form") final Race form,
                          final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            // return errors to page
            return form.getId() > 0 ? "race-create" : "race-update";
        }

        racesRepository.save(form);
        return "redirect:/races";
    }
}
