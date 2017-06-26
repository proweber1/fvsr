package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.domains.Person;
import pro.metrus.fvsr.forms.PeopleFilter;
import pro.metrus.fvsr.repositories.FederalSubjectRepository;
import pro.metrus.fvsr.repositories.PeopleRepository;
import pro.metrus.fvsr.repositories.TeamRepository;
import pro.metrus.fvsr.repositories.TitleRepository;
import pro.metrus.fvsr.specifications.PeopleFilterSpecification;

import javax.validation.Valid;

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
     *
     */
    private final TeamRepository teamRepository;

    /**
     *
     */
    private final TitleRepository titleRepository;

    /**
     *
     */
    private final FederalSubjectRepository federalSubjectRepository;

    /**
     * @param peopleRepository Repository for work with people
     */
    @Autowired
    public PeopleController(
            final PeopleRepository peopleRepository,
            final TeamRepository teamRepository,
            final TitleRepository titleRepository,
            final FederalSubjectRepository federalSubjectRepository
    ) {
        this.peopleRepository = peopleRepository;
        this.teamRepository = teamRepository;
        this.titleRepository = titleRepository;
        this.federalSubjectRepository = federalSubjectRepository;
    }

    /**
     * Return all people from database with pagination
     *
     * @param ui       Spring ui model
     * @param pageable Spring pageable bean
     * @return people page name
     */
    @GetMapping
    public String index(
            final Model ui,
            final Pageable pageable,
            @Valid final PeopleFilter filter
    ) {
        final PeopleFilterSpecification peopleFilterSpecification = new PeopleFilterSpecification(filter);
        final Specifications<Person> spec = peopleFilterSpecification.withAllSpecifications();

        ui.addAttribute("people", peopleRepository.findAll(spec, pageable));
        ui.addAttribute("filter", filter);
        ui.addAttribute("teams", teamRepository.findAll());
        ui.addAttribute("titles", titleRepository.findAll());
        ui.addAttribute("federalSubjects", federalSubjectRepository.findAll());

        return "people";
    }
}
