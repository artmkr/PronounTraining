package me.beresnev.pronoundrilling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
@Controller
public class WebController {

    @GetMapping("/")
    public String index() {
        return "drill";
    }
}
