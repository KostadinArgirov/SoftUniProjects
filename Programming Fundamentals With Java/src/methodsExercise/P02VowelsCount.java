package methodsExercise;

import java.util.Scanner;

public class P02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printVowelsCount(input);
    }

    private static void printVowelsCount(String input) {
        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.toLowerCase().charAt(i);
            if (symbol == 97 || symbol == 101 || symbol == 105 || symbol == 111 || symbol == 117 || symbol == 121) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}