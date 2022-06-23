package examPreparation;

import java.util.Scanner;

public class P02Bee {

    private static int row = 0;
    private static int col = 0;
    private static int pollinatedFlowers = 0;
    private static boolean isBeeInTerritory = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfBeeTerritory = Integer.parseInt(scanner.nextLine());

        char[][] beeTerritory = new char[sizeOfBeeTerritory][sizeOfBeeTerritory];

        for (int i = 0; i < sizeOfBeeTerritory; i++) {
            String line = scanner.nextLine();
            beeTerritory[i] = line.toCharArray();

            if (line.contains("B")) {
                row = i;
                col = line.indexOf("B");
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {

            switch (command) {

                case "up":
                    moveBee(beeTerritory, -1, 0);
                    break;
                case "down":
                    moveBee(beeTerritory, 1, 0);
                    break;
                case "left":
                    moveBee(beeTerritory, 0, -1);
                    break;
                case "right":
                    moveBee(beeTerritory, 0, 1);
                    break;
            }

            if (!isBeeInTerritory) {
                System.out.println("The bee got lost!");
                break;
            }

            command = scanner.nextLine();
        }

        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinatedFlowers);
        }
        print2dArray(beeTerritory);
    }

    private static void moveBee(char[][] field, int rowMutator, int colMutator) {
        int nextRow = row + rowMutator;
        int nextCol = col + colMutator;

        boolean isBonusHit = false;

        if (!isBeeInTerritory(field, nextRow, nextCol)) {
            field[row][col] = '.';
            isBeeInTerritory = false;
            return;
        }

        if (field[nextRow][nextCol] == 'f') {
            pollinatedFlowers++;
        } else if (field[nextRow][nextCol] == 'O') {
            isBonusHit = true;
        }

        field[row][col] = '.';
        field[nextRow][nextCol] = 'B';
        row = nextRow;
        col = nextCol;

        if (isBonusHit) {
            // Call this same method with the same mutators again if bonus is hit
            moveBee(field, rowMutator, colMutator);
        }
    }

    public static boolean isBeeInTerritory(char[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }

    private static void print2dArray(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}