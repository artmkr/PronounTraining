package me.beresnev.pronoundrilling.controller;

import me.beresnev.pronoundrilling.dto.SimpleDefinition;
import me.beresnev.pronoundrilling.service.DictionaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Objects;

/**
 * @author Ignat Beresnev
 * @since 16.04.17
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {

    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);
    private final DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    @GetMapping(value = "/simpleDefinition", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    SimpleDefinition getDefinition(@RequestParam("word") String word,
                                   @RequestParam("partOfSpeech") String partOfSpeech) throws IOException {
        Objects.requireNonNull(word);
        Objects.requireNonNull(partOfSpeech);
        logger.debug("Requesting simple definition for word \"{}\" ({})", word, partOfSpeech);
        return dictionaryService.getSimpleDefinition(word, partOfSpeech);
    }
}
