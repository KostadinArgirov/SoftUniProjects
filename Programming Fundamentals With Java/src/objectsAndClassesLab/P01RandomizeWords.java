package objectsAndClassesLab;

import java.util.Random;
import java.util.Scanner;

public class P01RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Random rnd = new Random();
        for (int pos1 = 0; pos1 < words.length; pos1++) {
            int pos2 = rnd.nextInt(words.length);
            String a = null, b = null;

            a = words[pos2];
            b = words[pos1];

            words[pos2] = b;
            words[pos1] = a;

        }
        System.out.println(String.join(System.lineSeparator(), words));
    }
}