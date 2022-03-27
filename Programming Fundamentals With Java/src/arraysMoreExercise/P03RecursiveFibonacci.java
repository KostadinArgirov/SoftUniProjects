package arraysMoreExercise;

import java.util.Scanner;

public class P03RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wantedFibonacciNum = Integer.parseInt(scanner.nextLine());
        int[] fibonacciSequence = new int[50];

        fibonacciSequence[0] = 1;
        fibonacciSequence[1] = 1;

        if (wantedFibonacciNum > 2) {
            for (int i = 2; i < wantedFibonacciNum; i++) {
                fibonacciSequence[i] = fibonacciSequence[i - 1] + fibonacciSequence[i - 2];
            }
        }
        System.out.println(fibonacciSequence[wantedFibonacciNum - 1]);
    }
}