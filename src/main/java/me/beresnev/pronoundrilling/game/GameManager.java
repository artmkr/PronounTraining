package me.beresnev.pronoundrilling.game;


import me.beresnev.pronoundrilling.dao.WordsDao;
import me.beresnev.pronoundrilling.model.Pronoun;
import me.beresnev.pronoundrilling.model.Round;
import me.beresnev.pronoundrilling.model.Verb;
import me.beresnev.pronoundrilling.model.VerbPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
@Component
public class GameManager {
    private List<Pronoun> pronouns;
    private List<Pronoun> corePronouns;
    private List<VerbPair> coreVerbs;
    private List<VerbPair> verbs;

    private final WordsDao wordsDao;
    private final Logger logger = LoggerFactory.getLogger(GameManager.class);

    @Autowired
    public GameManager(WordsDao wordsDao) {
        this.wordsDao = wordsDao;
        corePronouns = wordsDao.getCorePronouns();
        pronouns = wordsDao.getPronouns();
        coreVerbs = wordsDao.getCoreVerbs();
        verbs = wordsDao.getVerbs();
    }

    public Round generateRound(boolean corePronounsOnly, boolean coreVerbsOnly){
        return new Round(
                getRandomItemFromList(corePronouns, pronouns, corePronounsOnly), // pronouns
                getRandomItemFromList(coreVerbs, verbs, coreVerbsOnly)); // verbs
    }

    public boolean isCorrectAnswer(Pronoun pronoun, Verb verb){
        return pronoun.isPlural() == verb.isPlural();
    }

    private <T> T getRandomItemFromList(List<T> coreList, List<T> list, boolean core){
        List<T> requestedList = core ? coreList : list;
        int random = ThreadLocalRandom.current().nextInt(requestedList.size());
        return requestedList.get(random);
    }
}
