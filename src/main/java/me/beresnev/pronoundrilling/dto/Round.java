package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class Round {

    private Pronoun pronoun;
    private VerbPair verbPair;

    public Round() {

    }

    public Round(Pronoun pronoun, VerbPair verbPair) {
        this.pronoun = pronoun;
        this.verbPair = verbPair;
    }

    public Pronoun getPronoun() {
        return pronoun;
    }

    public VerbPair getVerbPair() {
        return verbPair;
    }

    @Override
    public String toString() {
        return "Round{" +
                "pronoun=" + pronoun +
                ", verbPair=" + verbPair +
                '}';
    }
}