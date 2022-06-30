package advanced.setsAndMapsAdvancedExercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setSizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSetSize = setSizes[0];

        Set<String> firstSet = new LinkedHashSet<>();

        for (int i = 0; i < firstSetSize; i++) {
            firstSet.add(scanner.nextLine());
        }

        int secondSetSize = setSizes[1];

        Set<String> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < secondSetSize; i++) {
            secondSet.add(scanner.nextLine());
        }
//        for (String element : firstSet) {
//            if (secondSet.contains(element)) {
//                System.out.print(element + " ");
//            }
//        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(e -> System.out.print(e + " "));
    }
}