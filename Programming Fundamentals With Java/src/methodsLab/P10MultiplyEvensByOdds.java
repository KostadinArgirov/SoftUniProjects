package methodsLab;

import java.util.Scanner;

public class P10MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        if (number < 0) {
            number = Math.abs(number);
        }
        int multiple = getMultipleOfEvensAndOdds(number);
        System.out.println(multiple);
    }

    private static int getMultipleOfEvensAndOdds(int number) {
        int evensSum = getEvenSum(number);
        int oddsSum = getOddSum(number);
        return evensSum * oddsSum;
    }

    private static int getEvenSum(int number) {
        int evensSum = 0;
        while (number != 0) {
            int digits = number % 10;
            if (digits % 2 == 0) {
                evensSum += digits;
            }
            number /= 10;
        }
        return evensSum;
    }

    private static int getOddSum(int number) {
        int oddsSum = 0;
        while (number != 0) {
            int digits = number % 10;
            if (digits % 2 != 0) {
                oddsSum += digits;
            }
            number /= 10;
        }
        return oddsSum;
    }
}
