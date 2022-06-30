package advanced.setsAndMapsAdvancedExercises;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P12SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("^(?<singer>([A-z]|\\s)+) @(?<venue>([A-z]|\\s)+) (?<ticketsPrice>\\d+) (?<ticketsCount>\\d+)$");
        Map<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            Matcher matchSinger = pattern.matcher(input);

            if(matchSinger.find()){
                String singer = matchSinger.group("singer");
                String venue = matchSinger.group("venue");
                Integer madeMoney = Integer.parseInt(matchSinger.group("ticketsPrice")) * Integer.parseInt(matchSinger.group("ticketsCount"));
                venues.putIfAbsent(venue, new  LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0);
                venues.get(venue).put(singer,  venues.get(venue).get(singer) + madeMoney);
            }
            input = scanner.nextLine();
        }
        venues.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(s -> System.out.println("#  " + s.getKey() + " -> " + s.getValue()));
        });
    }
}