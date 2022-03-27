package dataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P06BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int openBracketsCount = 0;
        int closedBracketsCount = 0;

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();

            if (input.equals("(")) {
                openBracketsCount++;
            }
            if (input.equals(")")) {
                closedBracketsCount++;
                if (openBracketsCount - closedBracketsCount != 0) {
                    break;
                }
            }
        }
        if (openBracketsCount == closedBracketsCount) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}