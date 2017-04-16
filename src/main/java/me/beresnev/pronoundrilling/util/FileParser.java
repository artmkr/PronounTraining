package me.beresnev.pronoundrilling.util;

import me.beresnev.pronoundrilling.dto.Pronoun;
import me.beresnev.pronoundrilling.dto.Verb;
import me.beresnev.pronoundrilling.dto.VerbPair;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
@Component
public class FileParser {

    public List<Pronoun> parsePronouns(Path path) {
        LinkedList<Pronoun> pronouns = new LinkedList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            String[] arr;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty())
                    continue;
                line = WordUtil.capitalize(line);
                arr = line.split(":");
                Pronoun pronoun = new Pronoun(arr[0], Boolean.parseBoolean(arr[1]));
                pronouns.add(pronoun);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pronouns;
    }

    public List<VerbPair> parseVerbs(Path path) {
        LinkedList<VerbPair> verbs = new LinkedList<>();
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty())
                    continue;
                line = line.trim();
                VerbPair pair = VerbPair.randomPair(
                        new Verb(line, true),
                        new Verb(WordUtil.getWordWithCorrectSuffix(line), false));
                verbs.add(pair);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return verbs;
    }
}
