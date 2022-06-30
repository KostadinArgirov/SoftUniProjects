package advanced.examPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energyOfParis = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        int rowParis = -1;
        int colParis = -1;

        boolean abductedHelen = false;

        for (int row = 0; row < size; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < input.length(); col++) {
                field[row][col] = input.charAt(col);
                if (input.charAt(col) == 'P') {
                    rowParis = row;
                    colParis = col;
                }
            }
        }

        while (true) {

            field[rowParis][colParis] = '-';

            String[] data = scanner.nextLine().split("\\s+");

            field[Integer.parseInt(data[1])][Integer.parseInt(data[2])] = 'S';

            energyOfParis--;

            switch (data[0]) {
                case "up":
                    if (parisInTheMatrix(rowParis - 1, colParis, size)) {
                        rowParis--;
                    }
                    break;
                case "down":
                    if (parisInTheMatrix(rowParis + 1, colParis, size)) {
                        rowParis++;
                    }
                    break;
                case "left":
                    if (parisInTheMatrix(rowParis, colParis - 1, size)) {
                        colParis--;
                    }
                    break;
                case "right":
                    if (parisInTheMatrix(rowParis, colParis + 1, size)) {
                        colParis++;
                    }
                    break;
            }

            if (field[rowParis][colParis] == 'H') {
                abductedHelen = true;
                field[rowParis][colParis] = '-';
                break;
            }

            if (field[rowParis][colParis] == 'S') {
                energyOfParis -= 2;
            }

            if (energyOfParis <= 0) {
                field[rowParis][colParis] = 'X';
                break;
            }

            field[rowParis][colParis] = 'P';
        }

        if (abductedHelen) {
            System.out.println("Paris has successfully abducted Helen! Energy left: " + energyOfParis);
        } else {
            System.out.printf("Paris died at %d;%d.%n", rowParis, colParis);
        }

        Arrays.stream(field).map(String::valueOf).forEach(System.out::println);
    }

    public static boolean parisInTheMatrix(int row, int col, int rowMatrix) {
        return row >= 0 && row < rowMatrix && col >= 0 && col < rowMatrix;
    }
}