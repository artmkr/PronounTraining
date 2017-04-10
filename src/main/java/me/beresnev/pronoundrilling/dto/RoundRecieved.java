package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 10.04.17
 */
public class RoundRecieved {
    private Pronoun pronoun;
    private VerbPair verbPair;
    private Verb chosen;

    public RoundRecieved() {

    }

    public RoundRecieved(Pronoun pronoun, VerbPair verbPair) {
        this.pronoun = pronoun;
        this.verbPair = verbPair;
    }

    public Pronoun getPronoun() {
        return pronoun;
    }

    public void setPronoun(Pronoun pronoun) {
        this.pronoun = pronoun;
    }

    public VerbPair getVerbPair() {
        return verbPair;
    }

    public void setVerbPair(VerbPair verbPair) {
        this.verbPair = verbPair;
    }

    public Verb getChosen() {
        return chosen;
    }

    public void setChosen(Verb chosen) {
        this.chosen = chosen;
    }

    @Override
    public String toString() {
        return "RoundRecieved{" +
                "pronoun=" + pronoun +
                ", verbPair=" + verbPair +
                ", chosen='" + chosen + '\'' +
                '}';
    }
}
