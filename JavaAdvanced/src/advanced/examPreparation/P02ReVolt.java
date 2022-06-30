package advanced.examPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int commandsNumber = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[matrixSize][matrixSize];

        int[] currentPosition = new int[2];
        int[] previousPosition = new int[2];


        for (int i = 0; i < matrixSize; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);

                if (input.charAt(j) == 'f') {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
            }
        }

        boolean isFinished = false;

        while (commandsNumber-- > 0) {

            String command = scanner.nextLine();

            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            matrix[currentPosition[0]][currentPosition[1]] = '-';

            move(command, currentPosition, matrixSize);

            if (matrix[currentPosition[0]][currentPosition[1]] == 'B') {
                move(command, currentPosition, matrixSize);
            }

            if (matrix[currentPosition[0]][currentPosition[1]] == 'T') {
                currentPosition[0] = previousPosition[0];
                currentPosition[1] = previousPosition[1];
            }

            if (matrix[currentPosition[0]][currentPosition[1]] == 'F') {
                matrix[currentPosition[0]][currentPosition[1]] = 'f';
                isFinished = true;
                break;
            }

            matrix[currentPosition[0]][currentPosition[1]] = 'f';
        }

        if (isFinished) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        Arrays.stream(matrix).map(String::valueOf).forEach(System.out::println);
    }

    public static boolean PlayerInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }

    public static void move(String command, int[] playerPosition, int rowMatrix) {
        switch (command) {
            case "up":
                if (PlayerInTheMatrix(playerPosition[0] - 1, playerPosition[1], rowMatrix)) {
                    playerPosition[0]--;
                } else {
                    playerPosition[0] = rowMatrix - 1;
                }
                break;
            case "down":
                if (PlayerInTheMatrix(playerPosition[0] + 1, playerPosition[1], rowMatrix)) {
                    playerPosition[0]++;
                } else {
                    playerPosition[0] = 0;
                }
                break;
            case "left":
                if (PlayerInTheMatrix(playerPosition[0], playerPosition[1] - 1, rowMatrix)) {
                    playerPosition[1]--;
                } else {
                    playerPosition[1] = rowMatrix - 1;
                }
                break;
            case "right":
                if (PlayerInTheMatrix(playerPosition[0], playerPosition[1] + 1, rowMatrix)) {
                    playerPosition[1]++;
                } else {
                    playerPosition[1] = 0;
                }
                break;
        }
    }
}