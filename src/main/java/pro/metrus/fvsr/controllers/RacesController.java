package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.repositories.RacesRepository;

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
     * Dependency injection constructor
     *
     * @param racesRepository Repository which work with races, must be not
     *                        null
     */
    @Autowired
    public RacesController(final RacesRepository racesRepository) {
        this.racesRepository = racesRepository;
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
}
