package me.beresnev.parser;

import me.beresnev.game.Main;
import me.beresnev.model.Pronoun;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class PronounFileParser {
    private static List<Pronoun> corePronouns;
    private static List<Pronoun> pronouns;

    public static List<Pronoun> getCore(){
        if(corePronouns == null || corePronouns.size() == 0){
            corePronouns = new LinkedList<>();
            corePronouns.add(new Pronoun("He", false));
            corePronouns.add(new Pronoun("She", false));
            corePronouns.add(new Pronoun("It", false));
            corePronouns.add(new Pronoun("They", true));
            corePronouns.add(new Pronoun("We", true));
            corePronouns.add(new Pronoun("You", true));
            corePronouns.add(new Pronoun("I", true));
        }
        return corePronouns;
    }

    public static List<Pronoun> parseFile(Path path) {
        if(path == null){
            // TODO: Add check for file existance
            // TODO: Remove hardcoded
            /*path = Paths.get("/home/ignat/Documents/Java/IDEA Projects/PronounTraining/src/main/webapp/WEB-INF/resources/pronouns");*/
            try {
                System.err.println(PronounFileParser.class.getClassLoader().getResource("pronouns").toURI());
                path = Paths.get(PronounFileParser.class.getClassLoader().getResource("pronouns").toURI());
            } catch (URISyntaxException e) {
                System.err.println(":) bye");
                System.exit(1);
            }
        }

        if (pronouns == null || pronouns.size() == 0) {
            pronouns = new LinkedList<>();
            pronouns.addAll(getCore());

            // TODO: Add logic for -y, -o, etc.
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line;
                String[] arr;
                while((line = reader.readLine()) != null){
                    arr = line.split(":");
                    Pronoun pronoun = new Pronoun(arr[0], Boolean.parseBoolean(arr[1]));
                    pronouns.add(pronoun);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return pronouns;
    }
}
