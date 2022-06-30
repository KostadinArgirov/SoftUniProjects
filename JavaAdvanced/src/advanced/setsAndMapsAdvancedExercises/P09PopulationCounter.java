package advanced.setsAndMapsAdvancedExercises;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P09PopulationCounter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countryPopulations = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("report")) {

            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Long.parseLong(data[2]);

            countryPopulations.putIfAbsent(country, new LinkedHashMap<>());
            countryPopulations.get(country).put(city, population);

            input = scanner.nextLine();
        }

        Map<String, Long> sortingMap = new LinkedHashMap<>();

        for (var entry : countryPopulations.entrySet()) {
            long sum = entry.getValue()
                    .values()
                    .stream()
                    .mapToLong(e -> e)
                    .sum();

            sortingMap.put(entry.getKey(), sum);
        }
        sortingMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> {

            System.out.printf("%s (total population: %s)%n", e.getKey(), e.getValue());
            countryPopulations.get(e.getKey())
                    .entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(s -> System.out.printf("=>%s: %s%n", s.getKey(), s.getValue()));

        });
    }
}