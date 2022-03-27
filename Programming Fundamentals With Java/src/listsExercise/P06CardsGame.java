package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstPlayer = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> secondPlayer = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());


        printWinnerAndTotalSum(firstPlayer, secondPlayer);
    }

    private static void printWinnerAndTotalSum(List<Integer> firstPlayer, List<Integer> secondPlayer) {
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            int index = 0;
            if (firstPlayer.get(index) > secondPlayer.get(index)) {
                firstPlayer.add(firstPlayer.get(index));
                firstPlayer.add(secondPlayer.get(index));
                firstPlayer.remove(index);
                secondPlayer.remove(index);
            } else if (firstPlayer.get(index) < secondPlayer.get(index)) {
                secondPlayer.add(secondPlayer.get(index));
                secondPlayer.add(firstPlayer.get(index));
                firstPlayer.remove(index);
                secondPlayer.remove(index);
            } else {
                firstPlayer.remove(index);
                secondPlayer.remove(index);
            }
        }
        if (firstPlayer.isEmpty()) {
            int sum = 0;
            for (Integer current : secondPlayer) {
                sum += current;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        } else {
            int sum = 0;
            for (Integer current : firstPlayer) {
                sum += current;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        }
    }
}