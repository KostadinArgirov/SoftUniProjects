package dataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P02FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= N; i++) {
            String input = scanner.nextLine();
            String stringBeforeSpace = input.substring(0, input.indexOf(' '));
            String stringAfterSpace = input.substring(input.indexOf(' ') + 1);
            long numLeft = ( Long.parseLong(stringBeforeSpace));
            long numRight = ( Long.parseLong(stringAfterSpace));

            long maxNumber = Math.max(numLeft, numRight);
            long sum = 0;

            while (Math.abs(maxNumber) > 0) {
                sum += maxNumber % 10;
                maxNumber /= 10;
            }
            System.out.println(Math.abs(sum));
        }
    }
}