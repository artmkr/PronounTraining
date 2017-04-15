package me.beresnev.pronoundrilling.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class VerbPair {

    private Verb first;
    private Verb second;

    public VerbPair() {
    }

    private VerbPair(Verb first, Verb second) {
        this.first = first;
        this.second = second;
    }

    // TODO: Switch them with 50% chance after the user has seen them
    public static VerbPair randomPair(Verb first, Verb second){
        boolean change = ThreadLocalRandom.current().nextBoolean();
        if(change){
            return new VerbPair(second, first);
        } else {
            return new VerbPair(first, second);
        }
    }

    public Verb getFirst() {
        return first;
    }

    public void setFirst(Verb first) {
        this.first = first;
    }

    public Verb getSecond() {
        return second;
    }

    public void setSecond(Verb second) {
        this.second = second;
    }

    public Verb get(boolean plural) {
        return plural ? getPlural() : getSingular();
    }

    @JsonIgnore
    public Verb getPlural(){
        return first.isPlural() ? first : second;
    }

    @JsonIgnore
    public Verb getSingular(){
        return !first.isPlural() ? first : second;
    }

    public void switchPlacesIfLucky() {
        if (ThreadLocalRandom.current().nextBoolean())
            switchPlaces();
    }

    private void switchPlaces() {
        Verb temp = first;
        first = second;
        second = temp;
    }

    @Override
    public String toString() {
        return "VerbPair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
