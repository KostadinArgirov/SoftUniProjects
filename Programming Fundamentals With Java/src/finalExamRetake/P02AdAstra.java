package finalExamRetake;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "([\\\\|#])(?<product>[A-Za-z ]+)\\1(?<expiration>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]+)\\1";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        Map<String,String> foodDate = new LinkedHashMap<>();
        Map<String,Integer> foodCalories = new LinkedHashMap<>();
        List<String> items = new LinkedList<>();
        int totalCalories = 0;

        while (matcher.find()) {
            String product = (matcher.group("product"));
            String expiration = (matcher.group("expiration"));
            int calories = Integer.parseInt(matcher.group("calories"));

            foodDate.putIfAbsent(product, expiration);
            foodCalories.putIfAbsent(product, calories);
            totalCalories += calories;
            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d%n", product,expiration,calories));
        }
        int sum = 0;
        for (Map.Entry<String, Integer> entry:foodCalories.entrySet()) {

            sum += entry.getValue();
        }

        System.out.printf("You have food to last you for: %d days!%n", totalCalories/2000); //change


        items.forEach(System.out::print);
    }
}