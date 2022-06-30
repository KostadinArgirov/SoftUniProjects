package advanced.examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondMagicBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondMagicBoxStack::push);

        int totalSumOfClaimedItems = 0;

        while (!(firstMagicBoxQueue.isEmpty() || secondMagicBoxStack.isEmpty())) {

            int currentItemFromFirstBox = firstMagicBoxQueue.peek();
            int currentItemFromSecondBox = secondMagicBoxStack.peek();

            int sum = currentItemFromFirstBox + currentItemFromSecondBox;

            secondMagicBoxStack.pop();

            if (sum % 2 == 0) {
                totalSumOfClaimedItems += sum;
                firstMagicBoxQueue.poll();
            } else {
                firstMagicBoxQueue.offer(currentItemFromSecondBox);
            }
        }

        if (firstMagicBoxQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        }

        if (secondMagicBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (totalSumOfClaimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", totalSumOfClaimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d", totalSumOfClaimedItems);
        }
    }
}