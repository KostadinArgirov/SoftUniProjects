package oop.exceptionsAndErrorHandlingLab;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class P01NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] range = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int begin = range[0];
        int end = range[1];

        System.out.println("Range: [" + begin + "..." + end + "]");

        boolean isInRange = false;

        String input = null;

        while (!isInRange) {
            Optional<Integer> number = Optional.empty();
            input = scanner.nextLine();

            try {
                number = Optional.of(Integer.parseInt(input));

            } catch (NumberFormatException ignore) {
            }

            if (number.isEmpty() || number.get() < begin || number.get() > end) {
                System.out.println("Invalid number: " + input);
            } else {
                isInRange = true;
            }
        }

        System.out.println("Valid number: " + input);
    }
}