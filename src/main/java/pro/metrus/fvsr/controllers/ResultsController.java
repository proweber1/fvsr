package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.core.AbstractCrudController;
import pro.metrus.fvsr.domains.Result;
import pro.metrus.fvsr.repositories.ResultsRepository;

/**
 * Controller for work with championships
 */
@Controller
@RequestMapping("/results")
public class ResultsController extends AbstractCrudController<Result, Long> {

    /**
     * Constructor for dependency injections
     *
     * @param resultsRepository Repository for fork with championships
     */
    @Autowired
    public ResultsController(final ResultsRepository resultsRepository) {
        super(Result.class, resultsRepository);
    }
}
