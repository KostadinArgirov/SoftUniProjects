package advanced.examPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P01AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bucketOfIngredients = new ArrayDeque<>(); //queue
        ArrayDeque<Integer> freshnessLevels = new ArrayDeque<>(); //stack

        Integer[] ingredientsInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] freshnessInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);

        Collections.addAll(bucketOfIngredients, ingredientsInput);
        Arrays.stream(freshnessInput).forEach(freshnessLevels::push);

        Map<Integer, String> needResourcesForCocktail = new HashMap<>();

        needResourcesForCocktail.put(150, "Pear Sour");
        needResourcesForCocktail.put(250, "The Harvest");
        needResourcesForCocktail.put(300, "Apple Hinny");
        needResourcesForCocktail.put(400, "High Fashion");

        Map<String, Integer> cocktailsMade = new TreeMap<>();

        while (!(bucketOfIngredients.isEmpty() || freshnessLevels.isEmpty())) {
            int singleIngredient = bucketOfIngredients.poll();
            if (singleIngredient == 0) {
                continue;
            }

            int singleFreshness = freshnessLevels.pop();

            int totalFreshnessLevel = singleIngredient * singleFreshness;

            if (needResourcesForCocktail.containsKey(totalFreshnessLevel)) {
                String makeCocktail = needResourcesForCocktail.get(totalFreshnessLevel);
                cocktailsMade.putIfAbsent(makeCocktail, 0);
                cocktailsMade.put(makeCocktail, cocktailsMade.get(makeCocktail) + 1);
            } else {
                bucketOfIngredients.offer(singleIngredient + 5);
            }
        }

        if (cocktailsMade.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!bucketOfIngredients.isEmpty()) {
            int sum = 0;

            while (!bucketOfIngredients.isEmpty()) {
                sum += bucketOfIngredients.poll();
            }
            System.out.println("Ingredients left: " + sum);
        }

        cocktailsMade.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
    }
}