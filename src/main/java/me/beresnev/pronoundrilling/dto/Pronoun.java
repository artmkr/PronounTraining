package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class Pronoun {
    private String pronoun;
    private boolean isPlural;

    public Pronoun() {
    }

    public Pronoun(String pronoun, boolean isPlural) {
        this.pronoun = pronoun;
        this.isPlural = isPlural;
    }

    public String getPronoun() {
        return pronoun;
    }

    public void setPronoun(String pronoun) {
        this.pronoun = pronoun;
    }

    public boolean isPlural() {
        return isPlural;
    }

    public void setPlural(boolean plural) {
        isPlural = plural;
    }

    @Override
    public String toString() {
        return "Pronoun{" +
                "pronoun='" + pronoun + '\'' +
                ", isPlural=" + isPlural +
                '}';
    }
}
