package advanced.examPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsNumber = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int[] currentPosition = new int[2];
        int[] previousPosition = new int[2];


        for (int i = 0; i < size; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = input.charAt(j);

                if (input.charAt(j) == 'P') {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
            }
        }

        boolean finished = false;

        while (commandsNumber-- > 0) {

            String command = scanner.nextLine();

            previousPosition[0] = currentPosition[0];
            previousPosition[1] = currentPosition[1];
            matrix[currentPosition[0]][currentPosition[1]] = '.';
            move(command, currentPosition, size);

            if (matrix[currentPosition[0]][currentPosition[1]] == 'B') {
                move(command, currentPosition, size);
            }

            if (matrix[currentPosition[0]][currentPosition[1]] == 'T') {
                currentPosition[0] = previousPosition[0];
                currentPosition[1] = previousPosition[1];
            }

            if (matrix[currentPosition[0]][currentPosition[1]] == 'F') {
                matrix[currentPosition[0]][currentPosition[1]] = 'P';
                finished = true;
                break;
            }

            matrix[currentPosition[0]][currentPosition[1]] = 'P';
        }

        if (finished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
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