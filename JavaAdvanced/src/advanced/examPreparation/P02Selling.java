package advanced.examPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02Selling {
    public static Position sellerPosition = new Position();
    public static List<Position> pillars = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int bakerySize = Integer.parseInt(scanner.nextLine());
        char[][] shop = new char[bakerySize][bakerySize];
        readMatrix(shop);
        int collectedMoney = 0;

        while (collectedMoney < 50) {
            shop[sellerPosition.row][sellerPosition.col] = '-';
            String command = scanner.nextLine();
            sellerPosition = calculateNewPosition(command, sellerPosition);
            if (isInMatrix(sellerPosition, bakerySize)) {
                char currentStep = shop[sellerPosition.row][sellerPosition.col];
                if (Character.isDigit(currentStep)) {
                    collectedMoney += Integer.parseInt(String.valueOf(currentStep));
                } else if (currentStep == 'O') {
                    shop[sellerPosition.row][sellerPosition.col] = '-';
                    Position nextPillarPosition = pillars.stream()
                            .filter(x -> x.row != sellerPosition.row && x.col != sellerPosition.col)
                            .findFirst()
                            .orElse(new Position());
                    sellerPosition.copy(nextPillarPosition);
                }
                shop[sellerPosition.row][sellerPosition.col] = 'S';
            } else {
                break;
            }
        }

        if (collectedMoney >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the examPreparation.bakery.");
        }

        System.out.printf("Money: %d%n", collectedMoney);
        print(shop);
    }

    private static boolean isInMatrix(Position sellerPosition, int size) {
        return sellerPosition.row >= 0 && sellerPosition.row < size
                && sellerPosition.col >= 0 && sellerPosition.col < size;
    }

    private static Position calculateNewPosition(String command, Position position) {
        Position newPosition = new Position(position.row, position.col);

        switch (command) {
            case "up":
                newPosition.row = newPosition.row - 1;
                break;
            case "down":
                newPosition.row = newPosition.row + 1;
                break;
            case "left":
                newPosition.col = newPosition.col - 1;
                break;
            case "right":
                newPosition.col = newPosition.col + 1;
                break;
        }

        return newPosition;
    }

    private static void readMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            char[] row = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = row[j];
                if (row[j] == 'S') {
                    sellerPosition = new Position(i, j);
                } else if (row[j] == 'O') {
                    pillars.add(new Position(i, j));
                }
            }
        }
    }

    private static void print(char[][] matrix) {
        System.out.println(Arrays.stream(matrix).map(String::valueOf).collect(Collectors.joining(System.lineSeparator())));
        System.out.println();
    }

    private static class Position {
        int row;
        int col;

        public Position() {
            this(0, 0);
        }

        public void copy(Position position) {
            this.row = position.row;
            this.col = position.col;
        }

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}