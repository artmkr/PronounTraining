package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class Verb {
    private String verb;
    private boolean isPlural;

    public Verb() {
    }

    public Verb(String verb, boolean isPlural) {
        this.verb = verb;
        this.isPlural = isPlural;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public boolean isPlural() {
        return isPlural;
    }

    public void setPlural(boolean plural) {
        isPlural = plural;
    }

    @Override
    public String toString() {
        return "Verb{" +
                "verb='" + verb + '\'' +
                ", isPlural=" + isPlural +
                '}';
    }
}
