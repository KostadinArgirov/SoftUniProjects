package examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstLootBoxQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondLootBoxStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(secondLootBoxStack::push);

        int totalSumOfClaimedItems = 0;

        while (!(firstLootBoxQueue.isEmpty() || secondLootBoxStack.isEmpty())) {

            int currentItemFromFirstBox = firstLootBoxQueue.peek();
            int currentItemFromSecondBox = secondLootBoxStack.peek();

            int sum = currentItemFromFirstBox + currentItemFromSecondBox;

            secondLootBoxStack.pop();

            if (sum % 2 == 0) {
                totalSumOfClaimedItems += sum;
                firstLootBoxQueue.poll();
            } else {
                firstLootBoxQueue.offer(currentItemFromSecondBox);
            }
        }

        if (firstLootBoxQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        }

        if (secondLootBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (totalSumOfClaimedItems >= 90) {
            System.out.printf("Your loot was epic! Value: %d", totalSumOfClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", totalSumOfClaimedItems);
        }
    }
}