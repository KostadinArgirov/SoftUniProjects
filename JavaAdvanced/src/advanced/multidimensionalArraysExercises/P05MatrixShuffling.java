package advanced.multidimensionalArraysExercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowColumn = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(rowColumn[0]);
        int col = Integer.parseInt(rowColumn[1]);

        String[][] matrix = getMatrix(scanner, row, col);
        String command;

        Pattern pattern = Pattern.compile("^swap(\\s+)(?<row1>\\d+)(\\s+)(?<col1>\\d+)(\\s+)(?<row2>\\d+)(\\s+)(?<col2>\\d+)$");

        while (!"END".equals(command = scanner.nextLine())) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int row1 = Integer.parseInt(matcher.group("row1"));
                int row2 = Integer.parseInt(matcher.group("row2"));
                int col1 = Integer.parseInt(matcher.group("col1"));
                int col2 = Integer.parseInt(matcher.group("col2"));
                String temp;

                try {
                    temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replaceAll("[\\[\\],]", ""));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid input!");
                }

            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static String[][] getMatrix(Scanner scanner, int row, int col) {
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        return matrix;
    }
}

//        String[] dimensions = scanner.nextLine().split(" ");
//
//        int rows = Integer.parseInt(dimensions[0]);
//        int cols = Integer.parseInt(dimensions[1]);
//
//        String[][] matrix = new String[rows][cols];
//
//        for (int row = 0; row < rows; row++) {
//            String[] arr = scanner.nextLine().split("\\s+");
//
//            matrix[row] = arr;
//        }
//
//        String input = scanner.nextLine();
//
//        while (!input.equals("END")) {
//
//            String[] data = input.split("\\s+");
//
//            if (data.length < 5) {
//                System.out.println("Invalid input!");
//                input = scanner.nextLine();
//                continue;
//            }
//
//            String command = data[0];
//            int num1 = Integer.parseInt(data[1]);
//            int num2 = Integer.parseInt(data[2]);
//            int num3 = Integer.parseInt(data[3]);
//            int num4 = Integer.parseInt(data[4]);
//
//            if (command.equals("swap") && (num1 < rows || num2 < cols || num3 < rows || num4 < cols)) {
//
//                String oldNum = matrix[num1][num2];
//                matrix[num1][num2] = matrix[num3][num4];
//                matrix[num3][num4] = oldNum;
//
//                for (int row = 0; row < rows; row++) {
//                    for (int col = 0; col < cols; col++) {
//                        System.out.print(matrix[row][col] + " ");
//                    }
//                    System.out.println();
//                }
//            } else {
//                System.out.println("Invalid input!");
//                input = scanner.nextLine();
//                continue;
//            }
//
//
//            input = scanner.nextLine();
//        }
//    }
//}