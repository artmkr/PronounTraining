package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class Verb {
    private boolean isPlural;
    private String verb;

    public Verb(String verb, boolean isPlural) {
        this.verb = verb;
        this.isPlural = isPlural;
    }

    public String getVerb() {
        return verb;
    }

    public boolean isPlural() {
        return isPlural;
    }

    @Override
    public String toString() {
        return "Verb{" +
                "isSingular=" + isPlural +
                ", verb='" + verb + '\'' +
                '}';
    }
}
