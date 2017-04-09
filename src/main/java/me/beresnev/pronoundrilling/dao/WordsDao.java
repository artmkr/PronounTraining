package me.beresnev.pronoundrilling.dao;

import me.beresnev.pronoundrilling.dto.Pronoun;
import me.beresnev.pronoundrilling.dto.VerbPair;

import java.util.List;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
public interface WordsDao {
    List<Pronoun> getCorePronouns();
    List<Pronoun> getPronouns();

    List<VerbPair> getCoreVerbs();
    List<VerbPair> getVerbs();

    void insertVerbs(List<VerbPair> pairList);
    void insertPronouns(List<Pronoun> pronouns);
}
