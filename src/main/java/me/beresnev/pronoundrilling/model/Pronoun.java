package me.beresnev.pronoundrilling.model;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class Pronoun {
    private boolean isPlural;
    private String pronoun;

    public Pronoun(String pronoun, boolean isPlural) {
        this.pronoun = pronoun;
        this.isPlural = isPlural;
    }

    public String getPronoun() {
        return pronoun;
    }

    public boolean isPlural() {
        return isPlural;
    }

    public String toString() {
        return pronoun;
    }
}
