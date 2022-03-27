package arraysMoreExercise;

import java.util.Scanner;

public class P02PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRows = Integer.parseInt(scanner.nextLine());
        if (numberOfRows == 1) {
            System.out.println("1");
            return;
        }
        // creating a jagged array with 1 and 2 row only with 1
        int[][] jaggedArray = new int[numberOfRows][];
        jaggedArray[0] = new int[1];
        jaggedArray[0][0] = 1;
        jaggedArray[1] = new int[2];
        jaggedArray[1][0] = 1;
        jaggedArray[1][1] = 1;

        for (int row = 2; row < numberOfRows; row++) {

            jaggedArray[row] = new int[row + 1];
            for (int col = 1; col < row; col++) {
                jaggedArray[row][0] = 1;
                jaggedArray[row][col] = jaggedArray[row - 1][col] + jaggedArray[row - 1][col - 1];
                jaggedArray[row][row] = 1;
            }
        }
        for (int[] currentRow : jaggedArray) {
            System.out.println();
            for (int i = 0; i < currentRow.length; i++) {
                System.out.print(currentRow[i] + " ");
            }
        }
    }
}