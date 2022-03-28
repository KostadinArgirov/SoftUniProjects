import java.util.Scanner;

public class P06TheMostPowerfulWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxPoints = Integer.MIN_VALUE;
        String word = "";

        String input = "";

        while (!"End of words".equals(input = scanner.nextLine())) {
            int currentSum = 0;
            boolean isVowel = false;

            for (int i = 0; i < input.length(); i++) {
                char symbol = input.charAt(i);

                currentSum += symbol;

                if (i == 0) {
                    if (input.charAt(i) == 'a' || input.charAt(i) == 'A' || input.charAt(i) == 'e' || input.charAt(i) == 'E' ||
                            input.charAt(i) == 'i' || input.charAt(i) == 'I' || input.charAt(i) == 'o' || input.charAt(i) == 'O' ||
                            input.charAt(i) == 'u' || input.charAt(i) == 'U' || input.charAt(i) == 'y' || input.charAt(i) == 'Y') {
                    isVowel = true;
                    }
                }
            }
        if (isVowel == true) {
            currentSum *= input.length();
        } else {
            currentSum = Math.round(currentSum / input.length());
        }
        if (currentSum > maxPoints) {
            maxPoints = currentSum;
            word = input;
        }
        }
        System.out.printf("The most powerful word is %s - %d", word, maxPoints);
    }
}