package advanced.stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String number : numbers) {
            stack.push(Integer.parseInt(number));
        }
        for (Integer element : stack) {
            System.out.print(stack.pop() + " ");
        }
    }
}