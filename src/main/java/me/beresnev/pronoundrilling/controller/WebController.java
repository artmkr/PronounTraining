package me.beresnev.pronoundrilling.controller;

import me.beresnev.pronoundrilling.dto.Round;
import me.beresnev.pronoundrilling.dto.RoundRecieved;
import me.beresnev.pronoundrilling.dto.RoundSent;
import me.beresnev.pronoundrilling.game.GameManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
@Controller
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    private final GameManager gameManager;

    @Autowired
    public WebController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @GetMapping("/")
    public String index() {
        return "drill";
    }

    // 1 - true, 0 - false
    // getRound?coreNouns=1&coreVerbs=1
    @GetMapping(value = "/getRound", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Round getRound(@RequestParam("coreNouns") boolean coreNouns,
                   @RequestParam("coreVerbs") boolean coreVerbs) {
        Round round = gameManager.generateRound(coreNouns, coreVerbs);
        logger.info("Round: " + round);
        return round;
    }

    @PostMapping(value = "/validateJsonRound", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    RoundSent validateJsonRound(@RequestBody RoundRecieved roundRecieved) {
        boolean b = gameManager.isCorrectJsonAnswer(roundRecieved);
        logger.info("Received json: " + roundRecieved);
        String answer = b ? "Correct" : "Wrong";
        return new RoundSent(answer);
    }
}
