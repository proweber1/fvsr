package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.core.AbstractCrudController;
import pro.metrus.fvsr.domains.*;
import pro.metrus.fvsr.forms.PeopleFilter;
import pro.metrus.fvsr.repositories.*;
import pro.metrus.fvsr.specifications.PeopleFilterSpecification;

import javax.validation.Valid;
import java.util.List;

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

    @ModelAttribute("teams")
    public List<Team> teams() {
        return teamRepository.findAll();
    }

    @ModelAttribute("titles")
    public List<Title> titles() {
        return titleRepository.findAll();
    }

    @ModelAttribute("federalSubjects")
    public List<FederalSubject> federalSubjects() {
        return federalSubjectRepository.findAll();
    }

    /**
     * Return all people from database with pagination
     *
     * @param ui       Spring ui model
     * @param pageable Spring pageable bean
     * @return people page name
     */
    @GetMapping
    public String list(final Model ui, final Pageable pageable, @Valid final PeopleFilter filter) {
        final Specifications<Person> specifications
                = PeopleFilterSpecification.withAllSpecifications(filter);

        ui.addAttribute("people", peopleRepository.findAll(specifications, pageable));
        ui.addAttribute("filter", filter);

        return "people";
    }

    @GetMapping("/create")
    public String create(final Model ui) {
        ui.addAttribute("form", new Person());

        return "create";
    }
}
