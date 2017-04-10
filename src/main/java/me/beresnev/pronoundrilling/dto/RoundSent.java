package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 10.04.17
 */
public class RoundSent {
    String message;

    public RoundSent() {

    }

    public RoundSent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
