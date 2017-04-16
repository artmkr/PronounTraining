package me.beresnev.pronoundrilling.dto;

/**
 * @author Ignat Beresnev
 * @since 16.04.17
 */
public class SimpleDefinition {
    private String word;
    private String definition;
    private String example;

    public SimpleDefinition() {
    }

    public SimpleDefinition(String word, String definition, String example) {
        this.word = word;
        this.definition = definition;
        this.example = example;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    @Override
    public String toString() {
        return "SimpleDefinition{" +
                "word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                ", example='" + example + '\'' +
                '}';
    }
}
