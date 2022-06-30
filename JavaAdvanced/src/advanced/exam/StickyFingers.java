package advanced.exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfField = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] field = new char[sizeOfField][sizeOfField];

        int dillingerRow = 0;
        int dillingerCol = 0;

        for (int row = 0; row < sizeOfField; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0))
                    .collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);

                if (currentChar == 'D') {
                    dillingerRow = row;
                    dillingerCol = col;
                }

                field[row][col] = currentChar;
            }
        }

        boolean isInField = true;
        boolean isInJail = false;
        int stolenMoney = 0;

        for (int i = 0; i < commands.length; i++) {

            switch (commands[i]) {
                case "up":
                    if (dillingerRow != 0) {
                        field[dillingerRow][dillingerCol] = '+';
                        dillingerRow--;
                    } else {
                        isInField = false;
                    }
                    break;
                case "down":
                    if (dillingerRow != sizeOfField - 1) {
                        field[dillingerRow][dillingerCol] = '+';
                        dillingerRow++;
                    } else {
                        isInField = false;
                    }
                    break;
                case "right":
                    if (dillingerCol != sizeOfField - 1) {
                        field[dillingerRow][dillingerCol] = '+';
                        dillingerCol++;
                    } else {
                        isInField = false;
                    }
                    break;
                case "left":
                    if (dillingerCol != 0) {
                        field[dillingerRow][dillingerCol] = '+';
                        dillingerCol--;
                    } else {
                        isInField = false;
                    }
                    break;
            }


            if (!isInField) {
                System.out.println("You cannot leave the town, there is police outside!");
                isInField = true;
                continue;
            }

            if (field[dillingerRow][dillingerCol] == '$') {
                field[dillingerRow][dillingerCol] = 'D';
                stolenMoney += (dillingerRow * dillingerCol);
                System.out.printf("You successfully stole %d$.%n", dillingerRow * dillingerCol);
            } else if (field[dillingerRow][dillingerCol] == 'P') {
                isInJail = true;
                System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);
                field[dillingerRow][dillingerCol] = '#';
                break;
            }
        }

        if (!isInJail) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }

        print2dArray(field);

    }

    private static void print2dArray(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}