package pro.metrus.fvsr.controller;

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
    @GetMapping("/")
    private String index() {
        return "index";
    }
}
