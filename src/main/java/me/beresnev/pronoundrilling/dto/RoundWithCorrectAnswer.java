package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 10.04.17
 */
public class RoundWithCorrectAnswer extends RoundWithChosenAnswer {

    private Verb chosenAnswer;
    private boolean isAnswerCorrect;
    private Verb correctAnswer;

    public RoundWithCorrectAnswer() {
    }

    public RoundWithCorrectAnswer(RoundWithChosenAnswer withChosenAnswer) {
        this.chosenAnswer = withChosenAnswer.getChosenAnswer();
        boolean isPronounPlural = withChosenAnswer.getPronoun().isPlural();
        this.isAnswerCorrect = isPronounPlural == chosenAnswer.isPlural();
        correctAnswer = withChosenAnswer.getVerbPair().get(isPronounPlural);
    }

    public boolean isAnswerCorrect() {
        return isAnswerCorrect;
    }

    public void setAnswerCorrect(boolean answerCorrect) {
        isAnswerCorrect = answerCorrect;
    }

    public Verb getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Verb correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
