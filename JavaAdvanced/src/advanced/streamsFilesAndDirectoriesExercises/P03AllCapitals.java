package advanced.streamsFilesAndDirectoriesExercises;

import java.io.*;

public class P03AllCapitals {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
             PrintWriter pw = new PrintWriter(new FileWriter("output.txt"))) {
            br.lines().forEach(line -> pw.println(line.toUpperCase()));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}