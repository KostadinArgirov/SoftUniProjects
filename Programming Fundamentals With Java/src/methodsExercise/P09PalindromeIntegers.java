package methodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            boolean isPalindrom = isPalindrome(input);
            if (isPalindrom) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }

            input = scanner.nextLine();
        }
    }
    private static boolean isPalindrome(String input) {
        String[] number = input.split("");
        String[] numRev = input.split("");
        for (int i = 0; i < numRev.length /2; i++) {
            String oldElement = numRev[i];

            numRev[i] = numRev[numRev.length - 1 - i];
            numRev[numRev.length - 1 - i] = oldElement;
        }
        if (Arrays.equals(number, numRev)) {
            return true;
        }
        return false;
    }
}