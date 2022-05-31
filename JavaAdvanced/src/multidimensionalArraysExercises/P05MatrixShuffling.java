package multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");

            matrix[row] = arr;
        }

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            String[] data = input.split("\\s+");

            if (data.length < 5) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            String command = data[0];
            int num1 = Integer.parseInt(data[1]);
            int num2 = Integer.parseInt(data[2]);
            int num3 = Integer.parseInt(data[3]);
            int num4 = Integer.parseInt(data[4]);

            if (command.equals("swap") && (num1 < rows || num2 < cols || num3 < rows || num4 < cols)) {

                String oldNum = matrix[num1][num2];
                matrix[num1][num2] = matrix[num3][num4];
                matrix[num3][num4] = oldNum;

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }


            input = scanner.nextLine();
        }
    }
}