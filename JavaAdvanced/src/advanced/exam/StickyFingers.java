package advanced.exam;

import java.util.Scanner;

public class StickyFingers {

    private static int matrixSize = 0;
    private static int rowDillinger = -1;
    private static int colDillinger = -1;
    private static String command = null;
    private static char[][] matrix = null;
    private static int stolenMoney = 0;
    private static boolean isCaught = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        matrixSize = Integer.parseInt(scanner.nextLine());
        String[] commandsFromConsole = scanner.nextLine().split(",");

        fillMatrix(scanner);

        for (String com : commandsFromConsole) {
            command = com;
            moveDillinger();
            if (isCaughtInNextCell()) {
                break;
            }
        }

        if (isCaught) {
            matrix[rowDillinger][colDillinger] = '#';
            System.out.println("You got caught with " + stolenMoney + "$, and you are going to jail.");
        } else {
            matrix[rowDillinger][colDillinger] = 'D';
            System.out.println("Your last theft has finished successfully with " + stolenMoney + "$ in your pocket.");
        }

        printTheMatrix();
    }

    private static void printTheMatrix() {
        StringBuilder sb = new StringBuilder();

        for (char[] chars : matrix) {
            for (char aChar : chars) {
                sb.append(aChar).append(" ");
            }
            sb.append(System.lineSeparator());
        }

        System.out.println(sb.toString().trim());
    }

    private static boolean isCaughtInNextCell() { //what found on the next Cell
        if (matrix[rowDillinger][colDillinger] == '$') {
            matrix[rowDillinger][colDillinger] = '+';
            int currentSteal = rowDillinger * colDillinger;
            stolenMoney += currentSteal;
            System.out.println("You successfully stole " + currentSteal + "$.");
        }

        if (matrix[rowDillinger][colDillinger] == 'P') {
            isCaught = true;
        }

        return isCaught;
    }

    private static void fillMatrix(Scanner console) {
        matrix = new char[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            String input = console.nextLine().replaceAll(" ", "");
            matrix[i] = input.toCharArray();
            if (input.contains("D")) {
                rowDillinger = i;
                colDillinger = input.indexOf("D");
                matrix[rowDillinger][colDillinger] = '+';
            }
        }
    }

    public static boolean isDillingerInTheMatrix(int rowMutator, int colMutator, int rowMatrix) {
        return rowDillinger + rowMutator >= 0 && rowDillinger + rowMutator < rowMatrix && colDillinger + colMutator >= 0 && colDillinger + colMutator < rowMatrix;
    }

    public static void moveDillinger() {
        String out = "You cannot leave the town, there is police outside!";

        switch (command) {
            case "up":
                if (isDillingerInTheMatrix(-1, 0, matrixSize)) {
                    rowDillinger--;
                } else {
                    System.out.println(out);
                }
                break;
            case "down":
                if (isDillingerInTheMatrix(1, 0, matrixSize)) {
                    rowDillinger++;
                } else {
                    System.out.println(out);
                }
                break;
            case "left":
                if (isDillingerInTheMatrix(0, -1, matrixSize)) {
                    colDillinger--;
                } else {
                    System.out.println(out);
                }
                break;
            case "right":
                if (isDillingerInTheMatrix(0, 1, matrixSize)) {
                    colDillinger++;
                } else {
                    System.out.println(out);
                }
                break;
        }
    }
}


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        int sizeOfField = Integer.parseInt(scanner.nextLine());
//        String[] commands = scanner.nextLine().split(",");
//
//        char[][] field = new char[sizeOfField][sizeOfField];
//
//        int dillingerRow = 0;
//        int dillingerCol = 0;
//
//        for (int row = 0; row < sizeOfField; row++) {
//            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
//                    .map(e -> e.charAt(0))
//                    .collect(Collectors.toList());
//
//            for (int col = 0; col < characterList.size(); col++) {
//                char currentChar = characterList.get(col);
//
//                if (currentChar == 'D') {
//                    dillingerRow = row;
//                    dillingerCol = col;
//                }
//
//                field[row][col] = currentChar;
//            }
//        }
//
//        boolean isInField = true;
//        boolean isInJail = false;
//        int stolenMoney = 0;
//
//        for (int i = 0; i < commands.length; i++) {
//
//            switch (commands[i]) {
//                case "up":
//                    if (dillingerRow != 0) {
//                        field[dillingerRow][dillingerCol] = '+';
//                        dillingerRow--;
//                    } else {
//                        isInField = false;
//                    }
//                    break;
//                case "down":
//                    if (dillingerRow != sizeOfField - 1) {
//                        field[dillingerRow][dillingerCol] = '+';
//                        dillingerRow++;
//                    } else {
//                        isInField = false;
//                    }
//                    break;
//                case "right":
//                    if (dillingerCol != sizeOfField - 1) {
//                        field[dillingerRow][dillingerCol] = '+';
//                        dillingerCol++;
//                    } else {
//                        isInField = false;
//                    }
//                    break;
//                case "left":
//                    if (dillingerCol != 0) {
//                        field[dillingerRow][dillingerCol] = '+';
//                        dillingerCol--;
//                    } else {
//                        isInField = false;
//                    }
//                    break;
//            }
//
//
//            if (!isInField) {
//                System.out.println("You cannot leave the town, there is police outside!");
//                isInField = true;
//                continue;
//            }
//
//            if (field[dillingerRow][dillingerCol] == '$') {
//                field[dillingerRow][dillingerCol] = 'D';
//                stolenMoney += (dillingerRow * dillingerCol);
//                System.out.printf("You successfully stole %d$.%n", dillingerRow * dillingerCol);
//            } else if (field[dillingerRow][dillingerCol] == 'P') {
//                isInJail = true;
//                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
//                field[dillingerRow][dillingerCol] = '#';
//                break;
//            }
//        }
//
//        if (!isInJail) {
//            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
//        }
//
//        print2dArray(field);
//
//    }
//
//    private static void print2dArray(char[][] field) {
//        for (char[] arr : field) {
//            for (char c : arr) {
//                System.out.print(c + " ");
//            }
//            System.out.println();
//        }
//    }
//}