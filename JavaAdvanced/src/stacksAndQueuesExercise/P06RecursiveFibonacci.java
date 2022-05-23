package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P06RecursiveFibonacci {
    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int n = Integer.parseInt(scanner.nextLine());
//
//        memory = new long[n + 1];
//
//        if (n == 0) {
//            System.out.println("0");
//            return;
//        }
//
//        long result = fib(n);
//        System.out.println(result);
//    }
//    private static long fib(int n) {
//        if (n < 2) {
//            return 1;
//        }
//        if (memory[n] != 0) {
//            return memory[n];
//        }
//        memory[n] = fib(n - 1) + fib(n - 2);
//        return memory[n];
//    }
//}

        int n = Integer.parseInt(scanner.nextLine());

        if (n < 2) {
            System.out.println("1");
            return;
        }
        ArrayDeque<Long> stack = new ArrayDeque<>();

        stack.push(0l);
        stack.push(1l);

        for (int i = 1; i <= n; i++) {
            long num1 = stack.pop();
            long num2 = stack.pop();

            stack.push(num1);
            stack.push(num1 + num2);
        }
        System.out.println(stack.pop());
    }
}