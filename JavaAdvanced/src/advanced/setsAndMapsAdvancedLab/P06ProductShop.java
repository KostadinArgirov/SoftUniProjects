package advanced.setsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> map = new TreeMap<>();

        String input;
        while (!"Revision".equals(input = scanner.nextLine())) {
            String shop = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);
            map.putIfAbsent(shop, new LinkedHashMap<>());
            map.get(shop).put(product, price);
        }

        for (Map.Entry<String, Map<String, Double>> entry : map.entrySet()) {
            System.out.printf("%s->%n", entry.getKey());
            for (Map.Entry<String, Double> secondEntry : entry.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f%n", secondEntry.getKey(), secondEntry.getValue());
            }
        }
    }
}