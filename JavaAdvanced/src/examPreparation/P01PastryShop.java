package examPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> ingredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredients::push);

        Map<String, Integer> cookedItems = new LinkedHashMap<>();

        cookedItems.put("Biscuit", 0);
        cookedItems.put("Cake", 0);
        cookedItems.put("Pie", 0);
        cookedItems.put("Pastry", 0);

        while (!(liquids.isEmpty() || ingredients.isEmpty())) {

            int lastIngredient = ingredients.pop();
            int sum = liquids.poll() + lastIngredient;

            String cookedFood;
            switch (sum) {
                case 25:
                    cookedFood = "Biscuit";
                    break;
                case 50:
                    cookedFood = "Cake";
                    break;
                case 75:
                    cookedFood = "Pastry";
                    break;
                case 100:
                    cookedFood = "Pie";
                    break;
                default:
                    cookedFood = null;
                    break;
            }

            if (cookedFood != null) {
                int newVal = cookedItems.get(cookedFood) + 1;
                cookedItems.put(cookedFood, newVal);
            } else {
                ingredients.push(lastIngredient + 3);
            }
        }

        boolean allFoodsAreCooked = cookedItems.entrySet().stream().allMatch(e -> e.getValue() > 0);

        if (allFoodsAreCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        String remainingLiquids = liquids.isEmpty() ? "none" : liquids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Liquids left: " + remainingLiquids);

        String remainingIngredients = ingredients.isEmpty() ? "none" : ingredients.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + remainingIngredients);

        cookedItems.entrySet()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }
}