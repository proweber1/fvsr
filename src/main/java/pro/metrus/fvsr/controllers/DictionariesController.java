package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.domains.*;
import pro.metrus.fvsr.repositories.*;

import java.util.List;

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
     * @return template for showing dictionaries
     */
    @GetMapping
    public String dictionaries(final Model ui) {
        ui.addAttribute("dictionaries", titleRepository.findAllByOrderByIdAsc());

        return "admin/pages/dictionaries/titles";
    }

    /**
     * This action showing all countries
     *
     * @param ui Spring ui model
     * @return template for showing countries
     */
    @GetMapping("/countries")
    public String countries(final Model ui) {
        List<Country> all = countryRepository.findAllByOrderByNameAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/countries";
    }

    /**
     * This action showing all vid`s
     *
     * @param ui Spring ui model
     * @return template for showing vid
     */
    @GetMapping("/vid")
    public String vid(final Model ui) {
        List<Vid> all = vidRepository.findAllByOrderByIdAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/vid";
    }

    /**
     * This action showing all categories
     *
     * @param ui Spring ui model
     * @return template for showing categories
     */
    @GetMapping("/categories")
    public String categories(final Model ui) {
        List<Category> all = categoriesRepository.findAllByOrderByShortNameAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/categories";
    }

    /**
     * This action showing all races types
     *
     * @param ui Spring ui model
     * @return template for showing races types
     */
    @GetMapping("/races-types")
    public String racesTypes(final Model ui) {
        List<RaceType> all = raceTypesRepository.findAllByOrderByVidIdAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/races-types";
    }

    /**
     * This action showing all participants
     *
     * @param ui Spring ui model
     * @return template for showing participants
     */
    @GetMapping("/participants")
    public String participants(final Model ui) {
        List<Participant> all = participantRepository.findAllByOrderByIdAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/participants";
    }

    /**
     * This action showing all result statuses
     *
     * @param ui Spring ui model
     * @return template for showing result statuses
     */
    @GetMapping("/result-statuses")
    public String resultStatuses(final Model ui) {
        List<ResultStatus> all = resultStatusRepository.findAllByOrderByIdAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/categories";
    }

    /**
     * This action showing all continents
     *
     * @param ui Spring ui model
     * @return template for showing continents
     */
    @GetMapping("/continents")
    public String continents(final Model ui) {
        List<Continent> all = continentsRepository.findAllByOrderByShortNameAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/continents";
    }

    /**
     * This action showing all federal subjects
     *
     * @param ui Spring ui model
     * @return template for showing federal subjects
     */
    @GetMapping("/subjects")
    public String subjects(final Model ui) {
        List<FederalSubject> all = federalSubjectRepository.findAllByOrderByIdAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/subjects";
    }

    /**
     * This action showing all districts
     *
     * @param ui Spring ui model
     * @return template for showing districts
     */
    @GetMapping("/districts")
    public String districts(final Model ui) {
        List<FederalDistrict> all = federalDistrictRepository.findAllByOrderByIdAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/titles";
    }

    /**
     * This action showing all uci
     *
     * @param ui Spring ui model
     * @return template for showing uci
     */
    @GetMapping("/uci")
    public String uci(final Model ui) {
        List<Uci> all = uciRepository.findAllByOrderByIdAsc();

        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/uci";
    }

    /**
     * This action showing all teams
     *
     * @param ui Spring ui model
     * @return template for showing teams
     */
    @GetMapping("/teams/{vidId}")
    public String teams(final Model ui, @PathVariable("vidId") final short vidId) {
        List<Team> all = teamRepository.findAllByUcisVidIdOrderByShortNameAsc(vidId);

        ui.addAttribute("vid", vidRepository.findAllByOrderByIdAsc());
        ui.addAttribute("dictionaries", all);

        return "admin/pages/dictionaries/teams";
    }
}
