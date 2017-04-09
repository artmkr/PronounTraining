package me.beresnev.model;

import java.util.List;

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

    public boolean isPlural() {
        return isPlural;
    }

    public String toString() {
        return pronoun;
    }
}
