package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.repositories.VidRepository;
import pro.metrus.fvsr.repositories.RaceTypesRepository;

import javax.websocket.server.PathParam;

/**
 * This is teams controller.
 */
@Controller
@RequestMapping("/race-types")
public class TeamsController {

    /**
     * Repository for work with vid
     */
    private final VidRepository vidRepository;

    /**
     * Repository for work with race types
     */
    private final RaceTypesRepository raceTypesRepository;

    /**
     * Constructor for dependency injection
     *
     * @param raceTypesRepository Repository for work with "Типы заездов", must be not null
     * @param vidRepository       Repository for work with "Виды", must be not null
     */
    @Autowired
    public TeamsController(
            final VidRepository vidRepository,
            final RaceTypesRepository raceTypesRepository
    ) {
        this.vidRepository = vidRepository;
        this.raceTypesRepository = raceTypesRepository;
    }

    /**
     * This method is simple. Method just return vid
     * template name.
     *
     * @return Vids view name
     */
    @GetMapping
    public String vid(final Model ui) {
        ui.addAttribute("vid", vidRepository.findAllByOrderByIdAsc());

        return "race-types";
    }

    /**
     * This method is simple. Method just return teams
     * template name.
     *
     * @return Teams view name
     */
    @GetMapping("/{id}/members")
    public String view(final Model ui) {
        ui.addAttribute("raceTypes", raceTypesRepository.findAllByOrderByVidIdAsc());

        return "race-view";
    }
}
