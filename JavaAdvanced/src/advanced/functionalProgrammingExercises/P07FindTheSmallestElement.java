package advanced.functionalProgrammingExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> minElementIndex = integerList -> {
            int minElement = integerList.stream().mapToInt(e -> e).min().getAsInt();
            return integerList.lastIndexOf(minElement);
        };
        System.out.println(minElementIndex.apply(list));
    }
}