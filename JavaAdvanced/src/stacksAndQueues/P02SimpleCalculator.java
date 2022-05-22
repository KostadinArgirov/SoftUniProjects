package stacksAndQueues;

import java.util.*;

public class P02SimpleCalculator {
    public static void main(String[] args) {

//        НЕ Е ОК ЗАДАЧАТА!!!

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack, tokens);

//        for (String token : tokens) {
//            stack.push(token);
//        }
        Arrays.stream(tokens)
                .forEach(stack::push);

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int second = Integer.parseInt(stack.pop());

            switch (op) {
                case "+":
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    stack.push(String.valueOf(first - second));
                    break;
            }
            System.out.println(stack.pop());
        }
    }
}
