package me.beresnev.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Ignat Beresnev
 * @since 07.04.17
 */
public class Trimmer {
    public static void trim(String sourceString, String targetString){
        Path source = Paths.get(sourceString);
        Path target = Paths.get(targetString);
        try (BufferedReader reader = Files.newBufferedReader(source);
             BufferedWriter writer = Files.newBufferedWriter(target)) {
            String line;
            while((line = reader.readLine()) != null){
                line = line.trim();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
