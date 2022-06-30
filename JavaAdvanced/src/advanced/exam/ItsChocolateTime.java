package advanced.exam;

import java.util.*;
import java.util.stream.Collectors;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQuantityQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Double> cacaoPowderQuantityStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble)
                .forEach(cacaoPowderQuantityStack::push);

        Map<String, Integer> chocolatesMade = new TreeMap<>();

        chocolatesMade.put("Milk Chocolate", 0);
        chocolatesMade.put("Dark Chocolate", 0);
        chocolatesMade.put("Baking Chocolate", 0);

        while (!(milkQuantityQueue.isEmpty() || cacaoPowderQuantityStack.isEmpty())) {

            double currentMilk = milkQuantityQueue.poll();
            double currentCacaoPowder = cacaoPowderQuantityStack.pop();
            double sum = currentMilk + currentCacaoPowder;
            double percentage = (currentCacaoPowder / sum) * 100;
            percentage = Math.round(percentage * 1.0);
            int percent = (int) percentage;

            switch (percent) {
                case 30:
                    chocolatesMade.put("Milk Chocolate", chocolatesMade.get("Milk Chocolate") + 1);
                    break;
                case 50:
                    chocolatesMade.put("Dark Chocolate", chocolatesMade.get("Dark Chocolate") + 1);
                    break;
                case 100:
                    chocolatesMade.put("Baking Chocolate", chocolatesMade.get("Baking Chocolate") + 1);
                    break;
                default:
                    milkQuantityQueue.offer(currentMilk + 10);
            }
        }

        if ((chocolatesMade.get("Milk Chocolate") > 0 && chocolatesMade.get("Dark Chocolate") > 0) && (chocolatesMade.get("Baking Chocolate") > 0)) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        chocolatesMade.entrySet().stream().filter(c -> c.getValue() > 0).forEach(c -> System.out.printf("# %s --> %d%n", c.getKey(), c.getValue()));
    }
}