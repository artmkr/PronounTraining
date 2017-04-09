package me.beresnev.dao;

import me.beresnev.model.Pronoun;
import me.beresnev.model.Verb;

import java.util.List;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
public interface WordsDao {
    List<Pronoun> getCorePronouns();
    List<Pronoun> getPronouns();

    List<Verb> getCoreVerbs();
    List<Verb> getVerbs();

    void insertVerbs(List<Verb> verbs);
    void insertPronouns(List<Pronoun> pronouns);
}
