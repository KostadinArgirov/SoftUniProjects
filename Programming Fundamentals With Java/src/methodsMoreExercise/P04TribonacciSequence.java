package methodsMoreExercise;

import java.util.Scanner;

public class P04TribonacciSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        int[] tribonacci = new int[Math.max(num, 3)];
        calculations(tribonacci);

        for (int i = 0; i < num; i++) {
            System.out.print(tribonacci[i] + " ");
        }
    }

    private static void calculations(int[] tribonacci) {
        // Декларирам първите 3 стойности на масива
        tribonacci[0] = tribonacci[1] = 1;
        tribonacci[2] = 2;

        //Започвам да пълня масива от 4-тата му стойност, защото предходните 3 са запълнени
        for (int i = 3; i < tribonacci.length; i++) {
            //Използвам формулата на Tribbonacci
            tribonacci[i] = tribonacci[i - 1] + tribonacci[i - 2] + tribonacci[i - 3];
        }
    }
}