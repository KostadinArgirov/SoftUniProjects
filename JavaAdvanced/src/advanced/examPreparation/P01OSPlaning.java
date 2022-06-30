package advanced.examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01OSPlaning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill = Integer.parseInt(scanner.nextLine());

        int currentTask = tasks.peek();
        int currentThread = threads.peek();

        while (true) {
            if (currentTask == taskToKill) {
                break;
            }

            if (currentThread >= currentTask) {
                tasks.pop();
            }

            threads.poll();

            currentTask = tasks.peek();
            currentThread = threads.peek();
        }

        System.out.printf("Thread with value %d killed task %d%n", currentThread, currentTask);

        String remainingThreads = threads.isEmpty() ? "none" : threads.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(remainingThreads);
    }
}