package methodsMoreExercise;

import java.util.Scanner;

public class P05MultiplicationSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int negativeCounter = 0;
        boolean isThereZero = false;

        for (int i = 0; i < 3; i++) {
            double currentNumber = Double.parseDouble(scanner.nextLine());

            if (currentNumber < 0) {
                negativeCounter++;
            }

            if (currentNumber == 0) {
                isThereZero = true;
            }
        }
        calculations(negativeCounter, isThereZero);
    }

    private static void calculations(int negativeCounter, boolean isThereZero) {
        if (isThereZero) {
            System.out.println("zero");
        } else if (negativeCounter % 2 == 1) {
            System.out.println("negative");
        } else {
            System.out.println("positive");
        }
    }
}