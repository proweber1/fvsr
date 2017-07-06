package pro.metrus.fvsr.controllers;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This is home controller.
 */
@Controller
public class IndexController {

    /**
     * This method is simple. Method just return home page
     * template name.
     *
     * @return Home page view name
     */
    @NotNull
    @Contract(pure = true)
    @GetMapping("/")
    private String index() {
        return "admin/pages/index";
    }
}
