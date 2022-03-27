package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        printSumAfterExplosion(scanner, numbers);
    }

    private static void printSumAfterExplosion(Scanner scanner, List<Integer> numbers) {
        String[] data = scanner.nextLine().split("\\s+");
        int bomb = Integer.parseInt(data[0]);
        int power = Integer.parseInt(data[1]);

        while (numbers.contains(bomb)) {
            int bombIndex = numbers.indexOf(bomb);
            int start = bombIndex - power;
            int end = bombIndex + power;
            if (start < 0) {
                start = 0;
            }
            if (end >= numbers.size()) {
                end = numbers.size() - 1;
            }

            for (int i = start; i <= end; i++) {
                numbers.remove(start);
            }
        }
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
}