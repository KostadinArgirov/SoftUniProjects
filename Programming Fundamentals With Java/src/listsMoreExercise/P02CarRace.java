package listsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02CarRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> time = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        double leftSum = 0;
        double rightSum = 0;

        calculateWinnerAndPrint(time, leftSum, rightSum);
    }

    private static void calculateWinnerAndPrint(List<Integer> time, double leftSum, double rightSum) {
        for (int i = 0; i < time.size() / 2; i++) {
            leftSum += time.get(i);

            if (time.get(i) == 0) {
                leftSum *= 0.8;
            }
        }

        for (int i = time.size() - 1; i > time.size() / 2; i--) {
            rightSum += time.get(i);

            if (time.get(i) == 0) {
                rightSum *= 0.8;
            }
        }

        if (leftSum < rightSum) {
            System.out.printf("The winner is left with total time: %.1f", leftSum);
        } else {
            System.out.printf("The winner is right with total time: %.1f", rightSum);
        }
    }
}