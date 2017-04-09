package me.beresnev.pronoundrilling.util;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Ignat Beresnev
 * @since 07.04.17
 */
public class WordUtil {

    private static HashSet vowels = new HashSet<>(Arrays.asList(new Character[]{'a', 'o', 'i', 'y', 'u', 'e'}));

    public static String getWordWithCorrectSuffix(String word){
        int lastChar = word.length() - 1;
        switch(word.charAt(lastChar)){
            case 's':
            case 'x':
            case 'o':
                return word + "es";
            case 'y':
                if(isVowel(word.charAt(lastChar - 1)))
                    return word + "s";
                else
                    return word.substring(0, lastChar) + "ies";
            default:
                switch(word.substring(lastChar - 1, lastChar + 1)){
                    case "ss":
                    case "sh":
                    case "ch":
                        return word + "es";
                    default:
                        return word + "s";
                }
        }

        // ss, sh, ch
    }

    // a, o, i, y, u, e
    private static boolean isVowel(char ch){
        return vowels.contains(ch);
    }

    private static boolean isConsonant(char ch){
        return !vowels.contains(ch);
    }
}
