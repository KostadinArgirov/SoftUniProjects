package advanced.multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = size[0];
        int cols = size[1];
        //create and fill matrix
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;

        for (int i = 0; i < rows + cols - 1; i++) {
            printDiagonal(row, col, matrix);
            col--;
            System.out.println();
        }
    }

    private static void printDiagonal(int row, int col, int[][] matrix) {
        while(row >=0  && col < matrix[0].length) {
            if (isValid(row, matrix.length) && isValid(col, matrix[0].length)) {
                System.out.print(matrix[row][col] + " ");
            }
            row--;
            col++;
        }
    }

    private static boolean isValid(int i, int length) {
        return i >= 0 && i < length;
    }
}