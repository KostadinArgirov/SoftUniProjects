package examPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P01Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffects = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(bombCasing::push);

        Map<String, Integer> bombsMade = new TreeMap<>();

        bombsMade.put("Datura Bombs", 0);
        bombsMade.put("Cherry Bombs", 0);
        bombsMade.put("Smoke Decoy Bombs", 0);

        boolean isAllBombsReady = false;

        while (!(bombEffects.isEmpty() || bombCasing.isEmpty() || isAllBombsReady)) {

            int currentEffect = bombEffects.peek();
            int currentCasing = bombCasing.pop();
            int sum = currentEffect + currentCasing;

            switch (sum) {
                case 40:
                    bombsMade.put("Datura Bombs", bombsMade.get("Datura Bombs") + 1);
                    bombEffects.poll();
                    break;
                case 60:
                    bombsMade.put("Cherry Bombs", bombsMade.get("Cherry Bombs") + 1);
                    bombEffects.poll();
                    break;
                case 120:
                    bombsMade.put("Smoke Decoy Bombs", bombsMade.get("Smoke Decoy Bombs") + 1);
                    bombEffects.poll();
                    break;
                default:
                    bombCasing.push(currentCasing - 5);
                    break;
            }

            isAllBombsReady = isAllBombsMade(bombsMade);
        }

        if (isAllBombsReady) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        String remainingBombEffects = bombEffects.isEmpty() ? "empty" : bombEffects.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Effects: " + remainingBombEffects);

        String remainingBombCasings = bombCasing.isEmpty() ? "empty" : bombCasing.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Bomb Casings: " + remainingBombCasings);

        bombsMade.entrySet()
                .forEach(b -> System.out.println(b.getKey() + ": " + b.getValue()));
//        bombsMade.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }

    private static boolean isAllBombsMade(Map<String, Integer> bombsMade) {
        return bombsMade.values().stream()
                .filter(b -> b >= 3)
                .count() == 3;
    }
}