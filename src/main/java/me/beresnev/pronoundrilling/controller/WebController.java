package me.beresnev.pronoundrilling.controller;

import me.beresnev.pronoundrilling.dto.Round;
import me.beresnev.pronoundrilling.dto.Verb;
import me.beresnev.pronoundrilling.dto.VerbPair;
import me.beresnev.pronoundrilling.game.GameManager;
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
        return round;
    }

    @GetMapping(value = "/validateRound", produces = "text/html; charset=UTF-8")
    public @ResponseBody
    String validateRound(@ModelAttribute("round") Round round, @RequestParam("choice") String choice) {
        int i = Integer.parseInt(choice);
        VerbPair pair = round.getVerbPair();
        Verb chosen = (i == 1) ? pair.getFirst() : pair.getSecond();
        boolean b = gameManager.isCorrectAnswer(round.getPronoun(), chosen);
        return String.format("You chose verb %s, answer is %b", chosen, b);
    }
}
