package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.domains.Country;
import pro.metrus.fvsr.domains.Participant;
import pro.metrus.fvsr.domains.Vid;
import pro.metrus.fvsr.repositories.*;

/**
 *
 */
@Controller
@RequestMapping("/dictionaries")
public class DictionariesController {

    private final FederalDistrictRepository federalDistrictRepository;
    private final FederalSubjectRepository federalSubjectRepository;
    private final TeamRepository teamRepository;
    private final TitleRepository titleRepository;
    private final RaceTypesRepository raceTypesRepository;
    private final CategoriesRepository categoriesRepository;
    private final ParticipantRepository participantRepository;
    private final ResultStatusRepository resultStatusRepository;
    private final CountryRepository countryRepository;
    private final VidRepository vidRepository;
    private final ContinentsRepository continentsRepository;
    private final UciRepository uciRepository;

    /**
     * Constructor for dependency injection
     *
     * @param federalDistrictRepository a
     * @param federalSubjectRepository b
     * @param teamRepository d
     * @param titleRepository e
     */
    @Autowired
    public DictionariesController(
            final FederalDistrictRepository federalDistrictRepository,
            final FederalSubjectRepository federalSubjectRepository,
            final TeamRepository teamRepository,
            final TitleRepository titleRepository,
            final RaceTypesRepository raceTypesRepository,
            final CategoriesRepository categoriesRepository,
            final ParticipantRepository participantRepository,
            final ResultStatusRepository resultStatusRepository,
            final CountryRepository countryRepository,
            final VidRepository vidRepository,
            final ContinentsRepository continentsRepository,
            final UciRepository uciRepository
    ) {
        this.federalDistrictRepository = federalDistrictRepository;
        this.federalSubjectRepository = federalSubjectRepository;
        this.teamRepository = teamRepository;
        this.titleRepository = titleRepository;
        this.raceTypesRepository = raceTypesRepository;
        this.categoriesRepository = categoriesRepository;
        this.participantRepository = participantRepository;
        this.resultStatusRepository = resultStatusRepository;
        this.countryRepository = countryRepository;
        this.vidRepository = vidRepository;
        this.continentsRepository = continentsRepository;
        this.uciRepository = uciRepository;
    }

    /**
     * This action showing all dictionaries in system
     *
     * @param ui Spring ui model
     * @param pageable Spring pageable bean
     * @return template for showing dictionaries
     */
    @GetMapping
    public String dictionaries(final Model ui, final Pageable pageable) {
        ui.addAttribute("federalDistricts", federalDistrictRepository.findAllByOrderByIdAsc());
        ui.addAttribute("federalSubjects", federalSubjectRepository.findAllByOrderByIdAsc());
        ui.addAttribute("teams", teamRepository.findAllByOrderByShortNameAsc());
        ui.addAttribute("raceTypes", raceTypesRepository.findAllByOrderByVidIdAsc());
        ui.addAttribute("categories", categoriesRepository.findAllByOrderByShortNameAsc());
        ui.addAttribute("participants", participantRepository.findAllByOrderByIdAsc());
        ui.addAttribute("resultStates", resultStatusRepository.findAllByOrderByIdAsc());
        ui.addAttribute("vid", vidRepository.findAllByOrderByIdAsc());
        ui.addAttribute("uci", uciRepository.findAllByOrderByIdAsc());
        ui.addAttribute("continents", continentsRepository.findAllByOrderByShortNameAsc());


        ui.addAttribute("dictionaries", titleRepository.findAllByOrderByIdAsc(pageable));

        return "admin/pages/dictionaries";
    }

    /**
     * This action showing all countries
     *
     * @param ui Spring ui model
     * @param pageable Spring pageable bean
     * @return template for showing countries
     */
    @GetMapping("/countries")
    public String countries(final Model ui, final Pageable pageable) {
        Page<Country> all = countryRepository.findAllByOrderByShortNameAsc(pageable);

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries";
    }

    /**
     * This action showing all vid`s
     *
     * @param ui Spring ui model
     * @param pageable Spring pageable bean
     * @return template for showing vid
     */
    @GetMapping("/vid")
    public String vid(final Model ui, final Pageable pageable) {
        Page<Vid> all = vidRepository.findAllByOrderByIdAsc(pageable);

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries";
    }
}
