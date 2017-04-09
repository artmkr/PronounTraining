package me.beresnev.dao;

import me.beresnev.model.Pronoun;
import me.beresnev.model.Verb;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
@Repository
public class MySqlWordsDao implements WordsDao {

    @Override
    public List<Pronoun> getCorePronouns() {
        return null;
    }

    @Override
    public List<Pronoun> getPronouns() {
        return null;
    }

    @Override
    public List<Verb> getCoreVerbs() {
        return null;
    }

    @Override
    public List<Verb> getVerbs() {
        return null;
    }

    @Override
    public void insertVerbs(List<Verb> verbs) {

    }

    @Override
    public void insertPronouns(List<Pronoun> pronouns) {

    }
}
