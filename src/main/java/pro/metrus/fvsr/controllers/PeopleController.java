package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.repositories.PeopleRepository;

/**
 *
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

    /**
     *
     */
    private final PeopleRepository peopleRepository;

    /**
     * @param peopleRepository Repository for work with people
     */
    @Autowired
    public PeopleController(final PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    /**
     * Return all people from database with pagination
     *
     * @param ui       Spring ui model
     * @param pageable Spring pageable bean
     * @return people page name
     */
    @GetMapping
    public String index(final Model ui, final Pageable pageable) {
        ui.addAttribute("people", peopleRepository.findAll(pageable));

        return "people";
    }
}
