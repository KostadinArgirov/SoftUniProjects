package advanced.setsAndMapsAdvancedExercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> words = new LinkedHashSet<>();

        while (n-- > 0) {

            String word = scanner.nextLine();

            words.add(word);
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}