package me.beresnev.pronoundrilling.controller;

import me.beresnev.pronoundrilling.dto.Round;
import me.beresnev.pronoundrilling.dto.RoundWithChosenAnswer;
import me.beresnev.pronoundrilling.dto.RoundWithCorrectAnswer;
import me.beresnev.pronoundrilling.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ignat Beresnev
 * @since 15.04.17
 */
@Controller
@RequestMapping("/round")
public class RoundController {
    private static final Logger logger = LoggerFactory.getLogger(WebController.class);
    private final TrainingService trainingService;

    @Autowired
    public RoundController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Round getRound(@RequestParam("allNouns") boolean allNouns,
                   @RequestParam("allVerbs") boolean allVerbs) {
        Round round = trainingService.generateRound(allNouns, allVerbs);
        logger.info("Generating and sending round: {}", round);
        return round;
    }

    @PostMapping(value = "/validate", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    RoundWithCorrectAnswer validateJsonRound(@RequestBody RoundWithChosenAnswer withChosenAnswer) {
        logger.info("Received JSON RoundWithChosenAnswer: {}", withChosenAnswer);
        RoundWithCorrectAnswer withCorrectAnswer = new RoundWithCorrectAnswer(withChosenAnswer);
        logger.info("Sending answer: {}", withCorrectAnswer);
        return withCorrectAnswer;
    }
}
