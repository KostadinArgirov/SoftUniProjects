package advanced.multidimensionalArraysExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int n = Integer.parseInt(input[0]);

        String pattern = input[1];

        int[][] matrix = new int[n][n];

        if (pattern.equals("A")) {
            fillInMatrixPatternA(n, matrix);
        } else if (pattern.equals("B")) {
            fillInMatrixPatternB(n, matrix);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
    private static void fillInMatrixPatternB(int n, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < n; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = n - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }
    }

    private static void fillInMatrixPatternA(int n, int[][] matrix) {
        int counter = 1;
        for (int col = 0; col < n; col++) {
            for (int row = 0; row < n; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
    }
}
