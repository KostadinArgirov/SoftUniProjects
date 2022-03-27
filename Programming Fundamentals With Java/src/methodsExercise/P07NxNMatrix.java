package methodsExercise;

import java.util.Scanner;

public class P07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        printNxNMatrix(n);
    }

    private static void printNxNMatrix(int num) {
        for (int rows = 0; rows < num; rows++) {
            for (int cols = 0; cols < num; cols++) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}