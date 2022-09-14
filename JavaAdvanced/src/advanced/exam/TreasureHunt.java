package advanced.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {

    private static int fieldRows = 0;
    private static int fieldCols = 0;
    private static int myRow = -1;
    private static int myCol = -1;
    private static String command = null;
    private static char[][] field = null;
    private static boolean isTreasureFound = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        fieldRows = Integer.parseInt(rowsAndCols[0]);
        fieldCols = Integer.parseInt(rowsAndCols[1]);

        fillMatrix(scanner);

        List<String> commandsList = new ArrayList<>();

        String command = scanner.nextLine();

        while (!"Finish".equals(command)) {
            commandsList.add(command);

            myMove(command);



            command = scanner.nextLine();
        }

        if (field[myRow][myCol] == 'X') {
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");
            System.out.print(commandsList.stream().collect(Collectors.joining(", ")));

        } else {
            System.out.println("The map is fake!");
        }

    }

    private static void myMove(String command) {
        switch (command) {
            case "up":
                if (amIInTheMatrix(-1, 0,fieldRows)) {
                    myRow--;
                }
                if (field[myRow][myCol] == 'T') {
                    myRow++;
                }
                break;
            case "down":
                if (amIInTheMatrix(1, 0,fieldRows)) {
                    myRow++;
                }
                if (field[myRow][myCol] == 'T') {
                    myRow--;
                }
                break;
            case "left":
                if (amIInTheMatrix(0, -1,fieldCols)) {
                    myCol--;
                }
                if (field[myRow][myCol] == 'T') {
                    myCol++;
                }
                break;
            case "right":
                if (amIInTheMatrix(0, 1,fieldCols)) {
                    myCol++;
                }
                if (field[myRow][myCol] == 'T') {
                    myCol--;
                }
                break;
        }
    }

    private static void fillMatrix(Scanner console) {
        field = new char[fieldRows][fieldCols];

        for (int i = 0; i < fieldRows; i++) {
            String input = console.nextLine().replaceAll(" ", "");
            field[i] = input.toCharArray();
            if (input.contains("Y")) {
                myRow = i;
                myCol = input.indexOf("Y");
                field[myRow][myCol] = 'Y';
            }
        }


    }

    public static boolean amIInTheMatrix(int rowMutator, int colMutator, int rowMatrix) {
        return myRow + rowMutator >= 0 && myRow + rowMutator < rowMatrix && myCol + colMutator >= 0 && myCol + colMutator < rowMatrix;
    }
}