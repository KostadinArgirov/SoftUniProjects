package advanced.examPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(materials::push);

        ArrayDeque<Integer> magicLevels = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        Map<String, Integer> craftedPresents = new TreeMap<>();
        craftedPresents.put("Doll", 0);
        craftedPresents.put("Wooden train", 0);
        craftedPresents.put("Teddy bear", 0);
        craftedPresents.put("Bicycle", 0);

        while (!(materials.isEmpty() || magicLevels.isEmpty())) {

            if (materials.peek() == 0) {
                materials.pop();
            }

            if (magicLevels.peek() == 0) {
                magicLevels.poll();
            }

            if (materials.isEmpty() || magicLevels.isEmpty()) {
                break;
            }

            int currentMaterial = materials.pop();
            int currentMagicLevel = magicLevels.poll();
            int multiplicationResult = currentMaterial * currentMagicLevel;

            switch (multiplicationResult) {
                case 150:
                    craftedPresents.put("Doll", craftedPresents.get("Doll") + 1);
                    break;
                case 250:
                    craftedPresents.put("Wooden train", craftedPresents.get("Wooden train") + 1);
                    break;
                case 300:
                    craftedPresents.put("Teddy bear", craftedPresents.get("Teddy bear") + 1);
                    break;
                case 400:
                    craftedPresents.put("Bicycle", craftedPresents.get("Bicycle") + 1);
                    break;
                default:
                    if (multiplicationResult < 0) {
                        materials.push(currentMaterial + currentMagicLevel);
                    } else {
                        materials.push(currentMaterial + 15);
                    }
            }
        }

        if ((craftedPresents.get("Doll") > 0 && craftedPresents.get("Wooden train") > 0) ||
                (craftedPresents.get("Teddy bear") > 0 && craftedPresents.get("Bicycle") > 0)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materials.isEmpty()) {
            System.out.printf("Materials left: %s%n", materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (!magicLevels.isEmpty()) {
            System.out.printf("Magic left: %s%n", magicLevels.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        craftedPresents.entrySet().stream().filter(s -> s.getValue() > 0).forEach(s -> System.out.printf("%s: %d%n", s.getKey(), s.getValue()));
    }
}