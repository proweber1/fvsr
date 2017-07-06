package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.repositories.VidRepository;

/**
 * This is teams controller.
 */
@Controller
@RequestMapping("/race-types")
public class TeamsController {

    private final VidRepository vidRepository;

    /**
     * Constructor for dependency injection
     *
     */
    @Autowired
    public TeamsController(
            final VidRepository vidRepository
    ) {
        this.vidRepository = vidRepository;
    }

    /**
     * This method is simple. Method just return teams
     * template name.
     *
     * @return Teams view name
     */
    @GetMapping
    public String dictionaries(final Model ui) {
        ui.addAttribute("vid", vidRepository.findAllByOrderByIdAsc());

        return "race-types";
    }
}
