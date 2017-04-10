package me.beresnev.pronoundrilling.controller;

import me.beresnev.pronoundrilling.dto.*;
import me.beresnev.pronoundrilling.game.GameManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
@Controller
@SessionAttributes("round")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    private final GameManager gameManager;

    @Autowired
    public WebController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/drill")
    public String drill() {
        return "drill";
    }

    @ModelAttribute("round")
    public Round round() {
        return new Round();
    }

    // 1 - true, 0 - false
    // getRound?coreNouns=1&coreVerbs=1
    @GetMapping(value = "/getRound", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Round getRound(@RequestParam("coreNouns") boolean coreNouns,
                   @RequestParam("coreVerbs") boolean coreVerbs,
                   Model model) {
        Round round = gameManager.generateRound(coreNouns, coreVerbs);
        model.addAttribute("round", round);
        logger.info("Adding round: " + round);
        return round;
    }

    @GetMapping(value = "/validateRound", produces = "text/html; charset=UTF-8")
    public @ResponseBody
    String validateRound(@ModelAttribute("round") Round round,
                         @RequestParam("choice") String choice,
                         Model model) {
        logger.info("Recieved round" + round);
        String showUser = "";
        int i = Integer.parseInt(choice);
        VerbPair pair = round.getVerbPair();
        Verb chosen = (i == 1) ? pair.getFirst() : pair.getSecond();
        boolean b = gameManager.isCorrectAnswer(round.getPronoun(), chosen);
        String colour = b ? "green" : "red";
        String answer = b ? "Correct" : "Wrong";
        return String.format("<span style=\"color:%s;\">%s</span>", colour, answer);
    }

    @PostMapping(value = "/validateJsonRound", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    RoundSent validateJsonRound(@RequestBody RoundRecieved roundRecieved) {
        boolean b = gameManager.isCorrectJsonAnswer(roundRecieved);
        logger.info("Received json: " + roundRecieved);
        String colour = b ? "green" : "red";
        String answer = b ? "Correct" : "Wrong";
        logger.info("Colour: {}; answer: {}", colour, answer);
//        return String.format("<span style=\"color:%s;\">%s</span>", colour, answer);
        return new RoundSent(answer);
    }
}
