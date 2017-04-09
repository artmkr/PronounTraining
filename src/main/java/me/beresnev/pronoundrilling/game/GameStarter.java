package me.beresnev.pronoundrilling.game;

import me.beresnev.pronoundrilling.model.Pronoun;
import me.beresnev.pronoundrilling.model.Round;
import me.beresnev.pronoundrilling.model.Verb;
import me.beresnev.pronoundrilling.model.VerbPair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * @author Ignat Beresnev
 * @since 06.04.17
 */
public class Main {

    private static Pronoun pronoun;
    private static Verb firstVerb;
    private static Verb secondVerb;
    private static int score = 0;
    private static long startTime;

    public static void main(String[] args) throws IOException, URISyntaxException {
        startTheGame();
    }

    /**
     * Console only
     */
    public static void startTheGame(){
        startTime = System.currentTimeMillis();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.err.println("Core pronouns only? [y/n]");
            boolean corePronounsOnly = reader.readLine().equals("y");
            System.err.println("Core verbs only? [y/n]");
            boolean coreVerbsOnly = reader.readLine().equals("y");

            writeRound(corePronounsOnly, coreVerbsOnly);
            String line;
            while(!(line = reader.readLine()).equals("exit")){
                Verb chosen = null;
                switch(line){
                    case "1":
                        chosen = firstVerb;
                        break;
                    case "2":
                        chosen = secondVerb;
                        break;
                    default:
                        System.err.println("Parsing error");
                        System.exit(0);
                        break;
                }

                boolean correct = GameManager.isCorrectAnswer(pronoun, chosen);
                if(!correct){
                    System.err.println("Wrong answer.");
                    break;
                }
                score++;
                writeRound(corePronounsOnly, coreVerbsOnly);
            }
            long timeTaken = System.currentTimeMillis() - startTime;
            int finalScore = score != 0 ? (int)(timeTaken / score) : -1;
            System.err.println("\nFinal score: " + finalScore);
            System.out.println("Try again? [y/n]");
            if(reader.readLine().equals("y")){
                startTheGame();
            } else {
                System.exit(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeRound(boolean corePronounsOnly, boolean coreVerbsOnly) throws IOException {
        Round round = GameManager.generateRound(corePronounsOnly, coreVerbsOnly);
        pronoun = round.getPronoun();
        VerbPair verbPair = round.getVerbPair();
        firstVerb = verbPair.getFirst();
        secondVerb = verbPair.getSecond();

        System.out.printf("\n=== %s ===\n", pronoun);
        System.out.printf("-- 1) %s -- 2) %s --\n", firstVerb.getVerb(), secondVerb.getVerb());
    }
}
