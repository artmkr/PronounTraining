package me.beresnev.pronoundrilling.service;


import me.beresnev.pronoundrilling.dao.WordsDao;
import me.beresnev.pronoundrilling.dto.Pronoun;
import me.beresnev.pronoundrilling.dto.Round;
import me.beresnev.pronoundrilling.dto.VerbPair;
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
public class TrainingService {
    private final WordsDao wordsDao;
    private final Logger logger = LoggerFactory.getLogger(TrainingService.class);
    private List<Pronoun> pronouns;
    private List<Pronoun> corePronouns;
    private List<VerbPair> coreVerbs;
    private List<VerbPair> verbs;

    @Autowired
    public TrainingService(WordsDao wordsDao) {
        this.wordsDao = wordsDao;
        corePronouns = wordsDao.getCorePronouns();
        pronouns = wordsDao.getPronouns();
        coreVerbs = wordsDao.getCoreVerbs();
        verbs = wordsDao.getVerbs();
    }

    public Round generateRound(boolean corePronounsOnly, boolean coreVerbsOnly){
        return new Round(
                getRandomItemFromList(corePronounsOnly ? corePronouns : pronouns),
                getRandomItemFromList(coreVerbsOnly ? coreVerbs : verbs));
    }

    private <T> T getRandomItemFromList(List<T> list) {
        int random = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(random);
    }
}
