package me.beresnev.pronoundrilling.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import me.beresnev.pronoundrilling.dto.SimpleDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Ignat Beresnev
 * @since 16.04.17
 */
@Service
public class DictionaryService {
    private static final String DICTIONARY_URL = "http://api.pearson.com/v2/dictionaries/ldoce5/entries";
    private static final String API_KEY = "mnGq5dcXrmvANQ1pWMoiGLTLXgITR66H"; // get 4 mil requests for free at pearson.com
    private static final Logger logger = LoggerFactory.getLogger(DictionaryService.class);
    private static final SimpleDefinition emptyDefinition // Returning cached empty simple definition
            = new SimpleDefinition("--", "No definition available", "No example available");

    /**
     * The dictionary API is quite bulky and doesn't seem to have a standard when it comes
     * to elements. Definition can be found in one of 2 places (still can't figure out what
     * it depends on), example can also be found in 3 places (or neither). If there's no such
     * word in the dictionary, it'll just return null "results" array. In addition to that, GSON
     * is also somewhat a nightmare: I guess you see down below why. I'll try to switch to jackson
     * when I have a chance. Debugging it looks something like this: http://i.imgur.com/EUsNDbo.png
     */
    public SimpleDefinition getSimpleDefinition(String word, String partOfSpeech) {
        Optional<String> jsonDefinition = getJsonDefinition(word, partOfSpeech);
        if (jsonDefinition.isPresent()) {
            JsonArray searchResults = new JsonParser().parse(jsonDefinition.get()).getAsJsonObject().getAsJsonArray("results");
            if (searchResults != null && searchResults.size() > 0) {
                SimpleDefinition definition = new SimpleDefinition();

                JsonObject firstResult = searchResults.get(0).getAsJsonObject();
                definition.setWord(firstResult.get("headword").getAsString());

                JsonArray sensesArray = firstResult.getAsJsonArray("senses");
                if (sensesArray != null && sensesArray.size() > 0) {
                    JsonObject firstSense = sensesArray.get(0).getAsJsonObject();

                    // Definition is either in "definition" array or in "signpost" element
                    JsonArray senseDefinition = firstSense.getAsJsonArray("definition");
                    if (senseDefinition != null && senseDefinition.size() > 0) {
                        definition.setDefinition(senseDefinition.get(0).getAsString());
                    } else if (firstSense.getAsJsonObject("signpost") != null) {
                        definition.setDefinition(firstSense.getAsJsonObject("signpost").getAsString());
                    } else {
                        definition.setDefinition("No definition available");
                    }

                    // Example is either in: 1) senses -> examples array -> text;
                    // 2) senses -> grammatical_examples array -> examples array -> text
                    // 3) senses -> collocation_examples array -> example -> text
                    // provided in order of frequency
                    JsonArray example = firstSense.getAsJsonArray("examples");
                    if (example != null && example.size() > 0) {
                        definition.setExample(example.get(0).getAsJsonObject().get("text").getAsString());
                    } else if (firstSense.getAsJsonArray("grammatical_examples") != null) {
                        JsonObject grammaticalExamples = firstSense.getAsJsonArray("grammatical_examples").get(0).getAsJsonObject();
                        JsonArray firstExample = grammaticalExamples.getAsJsonArray("examples");
                        if (firstExample != null && firstExample.size() > 0) {
                            definition.setExample(firstExample.get(0).getAsJsonObject().getAsJsonObject("text").getAsString());
                        } else {
                            definition.setExample("No example available");
                        }
                    } else if (firstSense.getAsJsonArray("collocation_examples") != null) {
                        JsonObject collocationExamples = firstSense.getAsJsonArray("collocation_examples").get(0).getAsJsonObject();
                        definition.setExample(collocationExamples.getAsJsonObject("example").getAsJsonObject("text").getAsString());
                    } else {
                        definition.setExample("No example available");
                    }
                }
                return definition;
            }
        }
        return emptyDefinition;
    }

    private Optional<String> getJsonDefinition(String word, String partOfSpeech) {
        Optional<String> jsonDefinition;
        try {
            URL obj = new URL(
                    String.format("%s?apikey=%s&headword=%s&part_of_speech=%s",
                            DICTIONARY_URL, API_KEY, word, partOfSpeech));
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            jsonDefinition = Optional.of(in.lines().collect(Collectors.joining()));
            logger.debug("Generated json definition {}", jsonDefinition);
            in.close();
        } catch (Exception e) { // should never happen since API always returns something
            logger.error("getJsonDefinition exception \"{}\" for word \"{}\" (part of speech \"{}\")", e.getMessage(), word, partOfSpeech);
            jsonDefinition = Optional.empty();
        }
        return jsonDefinition;
    }
}
