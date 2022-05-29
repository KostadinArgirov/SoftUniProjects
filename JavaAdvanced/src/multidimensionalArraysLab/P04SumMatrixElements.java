package multidimensionalArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[size[0]][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        int sum = Arrays.stream(matrix)
                .map(e -> Arrays.stream(e).sum())
                .mapToInt(e -> e)
                .sum();
        System.out.println(sum);
    }
}