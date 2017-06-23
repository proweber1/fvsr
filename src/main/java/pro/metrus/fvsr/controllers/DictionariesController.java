package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.repositories.*;

/**
 *
 */
@Controller
@RequestMapping("/dictionaries")
public class DictionariesController {

    /**
     *
     */
    private final FederalDistrictRepository federalDistrictRepository;

    /**
     *
     */
    private final FederalSubjectRepository federalSubjectRepository;

    /**
     *
     */
    private final GroupsRepository groupsRepository;

    /**
     *
     */
    private final TeamRepository teamRepository;

    /**
     *
     */
    private final TitleRepository titleRepository;

    /**
     * Constructor for dependency injection
     *
     * @param federalDistrictRepository a
     * @param federalSubjectRepository b
     * @param groupsRepository c
     * @param teamRepository d
     * @param titleRepository e
     */
    @Autowired
    public DictionariesController(
            final FederalDistrictRepository federalDistrictRepository,
            final FederalSubjectRepository federalSubjectRepository,
            final GroupsRepository groupsRepository,
            final TeamRepository teamRepository,
            final TitleRepository titleRepository
    ) {
        this.federalDistrictRepository = federalDistrictRepository;
        this.federalSubjectRepository = federalSubjectRepository;
        this.groupsRepository = groupsRepository;
        this.teamRepository = teamRepository;
        this.titleRepository = titleRepository;
    }

    /**
     * This action showing all dictionaries in system
     *
     * @param ui Spring ui model
     * @return template for showing dictionaries
     */
    @GetMapping
    public String dictionaries(final Model ui) {
        ui.addAttribute("federalDistricts", federalDistrictRepository.findAllByOrderByIdAsc());
        ui.addAttribute("federalSubjects", federalSubjectRepository.findAllByOrderByIdAsc());
        ui.addAttribute("groups", groupsRepository.findAllByOrderByIdAsc());
        ui.addAttribute("teams", teamRepository.findAllByOrderByIdAsc());
        ui.addAttribute("titles", titleRepository.findAllByOrderByIdAsc());

        return "dictionaries";
    }
}
