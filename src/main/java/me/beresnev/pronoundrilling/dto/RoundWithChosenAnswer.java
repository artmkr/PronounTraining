package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 10.04.17
 */
public class RoundWithChosenAnswer extends Round {

    private Verb chosenAnswer;

    public RoundWithChosenAnswer() {
    }

    public RoundWithChosenAnswer(Pronoun pronoun, VerbPair verbPair) {
        super(pronoun, verbPair);
    }

    public RoundWithChosenAnswer(Pronoun pronoun, VerbPair verbPair, Verb chosen) {
        super(pronoun, verbPair);
        this.chosenAnswer = chosen;
    }

    public Verb getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(Verb chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    @Override
    public String toString() {
        return super.toString() + "; RoundWithChosenAnswer{" +
                "chosenAnswer=" + chosenAnswer +
                '}';
    }
}
