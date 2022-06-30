package advanced.multidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        for (int index = 0; index < size; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();
        int row = size - 1;
        int col = 0;

        while (row >= 0 && row < size && col >= 0 && col < size) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }
}