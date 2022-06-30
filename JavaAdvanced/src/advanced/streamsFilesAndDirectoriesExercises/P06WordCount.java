package advanced.streamsFilesAndDirectoriesExercises;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06WordCount {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(new FileReader("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"));
             Scanner textScanner = new Scanner(new FileReader("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));
             PrintWriter printWriter = new PrintWriter("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/results.txt")) {

            Map<String, Integer> wordMap = new LinkedHashMap<>();
            Arrays.stream(scan.nextLine().split("\\s+")).forEach(word -> wordMap.put(word, 0));

            while (textScanner.hasNext()) {
                String textInput = textScanner.next();

                if (wordMap.containsKey(textInput)) {
                    int occurrences = wordMap.get(textInput);
                    occurrences++;
                    wordMap.put(textInput, occurrences);
                }
            }

            wordMap.entrySet().forEach(entry -> printWriter.printf("%s - %d%n", entry.getKey(), entry.getValue()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}