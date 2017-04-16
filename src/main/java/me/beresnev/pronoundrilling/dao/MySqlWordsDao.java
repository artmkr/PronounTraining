package me.beresnev.pronoundrilling.dao;

import me.beresnev.pronoundrilling.dto.Pronoun;
import me.beresnev.pronoundrilling.dto.Verb;
import me.beresnev.pronoundrilling.dto.VerbPair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

/**
 * @author Ignat Beresnev
 * @since 09.04.17
 */
@Repository
@Primary
public class MySqlWordsDao implements WordsDao {

    private static final Logger logger = LoggerFactory.getLogger(MySqlWordsDao.class);
    private final JdbcTemplate jdbcTemplate;

    /**
     * IMPORTANT: enable &rewriteBatchedStatements=true in connection URL
     */
    @Autowired
    public MySqlWordsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pronoun> getCorePronouns() {
        logger.debug("Query for core pronouns");
        return jdbcTemplate.query("SELECT pronoun, is_plural FROM core_pronouns", (resultSet, i) -> new Pronoun(
                resultSet.getString("pronoun"),
                resultSet.getBoolean("is_plural")
        ));
    }

    @Override
    public List<Pronoun> getPronouns() {
        logger.debug("Query for pronouns");
        return jdbcTemplate.query("SELECT pronoun, is_plural FROM pronouns", (resultSet, i) -> new Pronoun(
                resultSet.getString("pronoun"),
                resultSet.getBoolean("is_plural")
        ));
    }

    @Override
    public List<VerbPair> getCoreVerbs() {
        logger.debug("Query for core verbs");
        return jdbcTemplate.query("SELECT verb_plural, verb_singular FROM core_verbs", (resultSet, i) -> {
            String plural = resultSet.getString("verb_plural");
            String singular = resultSet.getString("verb_singular");
            return VerbPair.randomPair(
                    new Verb(plural, true),
                    new Verb(singular, false));
        });
    }

    @Override
    public List<VerbPair> getVerbs() {
        logger.debug("Query for verbs");
        return jdbcTemplate.query("SELECT verb_plural, verb_singular FROM verbs", (resultSet, i) -> {
            String plural = resultSet.getString("verb_plural");
            String singular = resultSet.getString("verb_singular");
            return VerbPair.randomPair(
                    new Verb(plural, true),
                    new Verb(singular, false));
        });
    }

    @Override
    public void insertVerbs(List<VerbPair> pairList) {
        Objects.requireNonNull(pairList);
        logger.debug("Query to insert verbs {}", pairList);
        jdbcTemplate.batchUpdate("INSERT INTO verbs (verb_plural, verb_singular) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        VerbPair verbPair = pairList.get(i);
                        preparedStatement.setString(1, verbPair.getPlural().getVerb());
                        preparedStatement.setString(2, verbPair.getSingular().getVerb());
                    }

                    @Override
                    public int getBatchSize() {
                        return pairList.size();
                    }
                });
    }

    @Override
    public void insertPronouns(List<Pronoun> pronouns) {
        Objects.requireNonNull(pronouns);
        logger.debug("Query to insert pronouns {}", pronouns);
        jdbcTemplate.batchUpdate("INSERT INTO pronouns (pronoun, is_plural) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                        preparedStatement.setString(1, pronouns.get(i).getPronoun());
                        preparedStatement.setBoolean(2, pronouns.get(i).isPlural());
                    }

                    @Override
                    public int getBatchSize() {
                        return pronouns.size();
                    }
                });
    }
}
