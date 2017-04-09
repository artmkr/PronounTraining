package me.beresnev.game;

import me.beresnev.model.Pronoun;
import me.beresnev.model.Round;
import me.beresnev.model.Verb;
import me.beresnev.model.VerbPair;
import me.beresnev.parser.PronounFileParser;
import me.beresnev.parser.VerbFileParser;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class GameManager {
    private static List<Pronoun> pronouns;
    private static List<Pronoun> corePronouns;
    private static List<VerbPair> coreVerbs;
    private static List<VerbPair> verbs;

    static {
        corePronouns = Collections.unmodifiableList(PronounFileParser.getCore());
        pronouns = Collections.unmodifiableList(PronounFileParser.parseFile(null));

        coreVerbs = Collections.unmodifiableList(VerbFileParser.getCore());
        verbs = Collections.unmodifiableList(VerbFileParser.parseFile(null));
    }

    public static Round generateRound(boolean corePronounsOnly, boolean coreVerbsOnly){
        return new Round(
                getRandomItemFromList(corePronouns, pronouns, corePronounsOnly), // pronouns
                getRandomItemFromList(coreVerbs, verbs, coreVerbsOnly)); // verbs
    }

    public static boolean isCorrectAnswer(Pronoun pronoun, Verb verb){
        return pronoun.isPlural() == verb.isPlural();
    }

    private static <T> T getRandomItemFromList(List<T> coreList, List<T> list, boolean core){
        List<T> requestedList = core ? coreList : list;
        int random = ThreadLocalRandom.current().nextInt(requestedList.size());
        return requestedList.get(random);
    }
}
