package me.beresnev.parser;

import me.beresnev.model.Verb;
import me.beresnev.model.VerbPair;
import me.beresnev.util.WordUtil;

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
public class VerbFileParser implements FileParser {
    private static List<VerbPair> coreVerbs;
    private static List<VerbPair> verbs;

    public static List<VerbPair> getCore(){
        if(coreVerbs == null || coreVerbs.size() == 0){
            coreVerbs = new LinkedList<>();
            coreVerbs.add(VerbPair.randomPair(new Verb("do", true), new Verb("does", false)));
            coreVerbs.add(VerbPair.randomPair(new Verb("have", true), new Verb("has", false)));
            coreVerbs.add(VerbPair.randomPair(new Verb("are", true), new Verb("is", false)));
            coreVerbs.add(VerbPair.randomPair(new Verb("were", true), new Verb("was", false)));
        }
        return coreVerbs;
    }

    public static List<VerbPair> parseFile(Path path) {
        if(path == null){
            // TODO: Add check for file existance
            // TODO: Remove hardcoded
            /*path = Paths.get("/home/ignat/Documents/Java/IDEA Projects/PronounTraining/src/main/webapp/WEB-INF/resources/verbs");*/
            try {
                path = Paths.get(VerbFileParser.class.getClassLoader().getResource("verbs").toURI());
            } catch (URISyntaxException e) {
                System.err.println(":) bye");
                System.exit(1);
            }
        }

        if (verbs == null || verbs.size() == 0) {
            verbs = new LinkedList<>();
            verbs.addAll(getCore());

            // TODO: Add logic for -y, -o, etc.
            try (BufferedReader reader = Files.newBufferedReader(path)) {
                String line;
                while((line = reader.readLine()) != null){
                    line = line.trim();
                    VerbPair pair = VerbPair.randomPair(new Verb(line, true), new Verb(WordUtil.getWordWithCorrectSuffix(line), false));
                    verbs.add(pair);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return verbs;
    }
}
