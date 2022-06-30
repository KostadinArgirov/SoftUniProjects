package advanced.streamsFilesAndDirectoriesExercises;

import java.io.*;

public class P04CountCharacterTypes {
    public static void main(String[] args) {

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try (FileReader fr = new FileReader("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");
             PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {

            int oneSymbol = fr.read();

            while (oneSymbol >= 0) {

                char symbolAsChar = (char) oneSymbol;
                if (isVowel(symbolAsChar)) {
                    vowels++;
                } else if (isPunctuation(symbolAsChar)) {
                    punctuation++;
                } else if (!Character.isWhitespace(symbolAsChar)) {
                    consonants++;
                }

                oneSymbol = fr.read();
            }
            pw.println("Vowels: " + vowels);
            pw.println("Consonants: " + consonants);
            pw.println("Punctuation: " + punctuation);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
    }

    public static boolean isVowel(char character) {
        return character == 'a' || character == 'o' || character == 'u' || character == 'e' || character == 'i';

    }

    public static boolean isPunctuation(char character) {
        return character == '!' || character == ',' || character == '.' || character == '?';

    }
}