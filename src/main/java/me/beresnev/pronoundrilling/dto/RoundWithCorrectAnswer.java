package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 10.04.17
 */
public class RoundWithCorrectAnswer extends RoundWithChosenAnswer {
    private boolean isAnswerCorrect;
    private Verb correctAnswer;

    public RoundWithCorrectAnswer() {
    }

    public RoundWithCorrectAnswer(RoundWithChosenAnswer withChosenAnswer) {
        super(withChosenAnswer.getPronoun(),
                withChosenAnswer.getVerbPair(),
                withChosenAnswer.getChosenAnswer());

        boolean isPronounPlural = withChosenAnswer.getPronoun().isPlural();
        isAnswerCorrect = (isPronounPlural == getChosenAnswer().isPlural());
        correctAnswer = withChosenAnswer.getVerbPair().get(isPronounPlural); // plural or singular
    }

    public boolean getIsAnswerCorrect() {
        return isAnswerCorrect;
    }

    public void setIsAnswerCorrect(boolean answerCorrect) {
        isAnswerCorrect = answerCorrect;
    }

    public Verb getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Verb correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return super.toString() + "; RoundWithCorrectAnswer{" +
                "isAnswerCorrect=" + isAnswerCorrect +
                ", correctAnswer=" + correctAnswer +
                '}';
    }
}
