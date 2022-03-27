package finalExamRetake;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String locations = scanner.nextLine();

        String regex = "([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(locations);

        List<String> destinations = new ArrayList<>();
        int travelPoints = 0;

        while (matcher.find()) {
            String destination = (matcher.group("destination"));
            destinations.add(destination);
            travelPoints += destination.length();
        }

        System.out.printf("Destinations: %s%n" +
                "Travel Points: %d%n", String.join(", ", destinations), travelPoints);
    }
}