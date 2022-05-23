package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P05BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();

        ArrayDeque<Character> openingParentheses = new ArrayDeque<>();

        boolean isBalance = true;

        for (int i = 0; i < parentheses.length(); i++) {
            char currentParentheses = parentheses.charAt(i);

            if (currentParentheses == '{' || currentParentheses == '(' || currentParentheses == '[') {
                openingParentheses.push(currentParentheses);
            } else {
                if (openingParentheses.isEmpty()) {
                    isBalance = false;
                    break;
                }
                char lastOpeningParentheses = openingParentheses.pop();

                if (currentParentheses == '}' && lastOpeningParentheses != '{') {
                    isBalance = false;
                } else if (currentParentheses == ')' && lastOpeningParentheses != '(') {
                    isBalance = false;
                } else if (currentParentheses == ']' && lastOpeningParentheses != '[') {
                    isBalance = false;
                }
            }
        }
        if (isBalance) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}