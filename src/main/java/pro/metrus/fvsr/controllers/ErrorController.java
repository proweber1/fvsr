package pro.metrus.fvsr.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This is error controller.
 */
@Controller
public class ErrorController {

    /**
     * This method is simple. Method just return error page
     * template name.
     *
     * @return Error page view name
     */
    @GetMapping("/error")
    private String error() {
        return "error";
    }
}
