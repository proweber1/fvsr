package pro.metrus.fvsr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.metrus.fvsr.repositories.CompletionsRepository;

@Controller
@RequestMapping("/completions")
public class CompletionsController {
    private final CompletionsRepository completionsRepository;

    @Autowired
    public CompletionsController(final CompletionsRepository completionsRepository) {
        this.completionsRepository = completionsRepository;
    }

    public String list(final Model ui, final Pageable pageable) {
        ui.addAttribute("completions", completionsRepository.findAllByOrderByIdAsc(pageable));

        return "completions_list";
    }
}
