package me.beresnev.pronoundrilling.service;


import me.beresnev.pronoundrilling.dao.WordsDao;
import me.beresnev.pronoundrilling.dto.Pronoun;
import me.beresnev.pronoundrilling.dto.Round;
import me.beresnev.pronoundrilling.dto.VerbPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
@Component
public class TrainingService {
    private final WordsDao wordsDao;
    private List<Pronoun> pronouns;
    private List<Pronoun> corePronouns;
    private List<VerbPair> coreVerbs;
    private List<VerbPair> verbs;

    @Autowired // TODO: With spring-security implement updating lists
    public TrainingService(WordsDao wordsDao) {
        this.wordsDao = wordsDao;
        corePronouns = Collections.unmodifiableList(wordsDao.getCorePronouns());
        pronouns = Collections.unmodifiableList(wordsDao.getPronouns());
        coreVerbs = Collections.unmodifiableList(wordsDao.getCoreVerbs());
        verbs = Collections.unmodifiableList(wordsDao.getVerbs());
    }

    public Round generateRound(boolean allNouns, boolean allVerbs) {
        return new Round(
                getRandomItemFromList(allNouns ? pronouns : corePronouns),
                getRandomItemFromList(allVerbs ? verbs : coreVerbs));
    }

    private <T> T getRandomItemFromList(List<T> list) {
        int random = ThreadLocalRandom.current().nextInt(list.size());
        return list.get(random);
    }
}
