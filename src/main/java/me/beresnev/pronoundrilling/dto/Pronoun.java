package me.beresnev.pronoundrilling.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @JsonIgnore
    public boolean isPlural() {
        return isPlural;
    }

    @JsonIgnore
    public String toString() {
        return pronoun;
    }
}