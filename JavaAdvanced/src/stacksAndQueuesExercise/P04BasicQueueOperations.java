package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int countToPush = input[0];
        int countToPop = input[1];
        int elementToSearch = input[2];

        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < countToPush; i++) {
            queue.offer(numbers[i]);
        }

        for (int i = 0; i < countToPop; i++) {
            queue.poll();
        }

        if (queue.contains(elementToSearch)) {
            System.out.println("true");
        } else if (queue.isEmpty()) {
            System.out.println("0");
        } else {
            System.out.println(queue.stream().min(Integer::compare).get());
        }
    }
}
