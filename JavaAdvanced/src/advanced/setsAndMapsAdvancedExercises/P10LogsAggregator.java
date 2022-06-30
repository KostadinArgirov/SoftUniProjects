package advanced.setsAndMapsAdvancedExercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class P10LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, TreeMap<String, Integer>> users = new TreeMap<>();

        int lines = Integer.parseInt(scanner.nextLine());

        while (lines-- > 0) {

            String[] data = scanner.nextLine().split("\\s+");
            String ip = data[0];
            String username = data[1];
            int duration = Integer.parseInt(data[2]);

            users.putIfAbsent(username, new TreeMap<>());
            users.get(username).putIfAbsent(ip, 0);
            users.get(username).put(ip, users.get(username).get(ip) + duration);
        }
        users.forEach((key, value) ->
                System.out.printf("%s: %d [%s]%n",
                        key,
                        value.values().stream().mapToInt(i -> i).sum(),
                        value.keySet()
                                .stream()
                                .map(ip -> String.format("%s", ip))
                                .collect(Collectors.joining(", ")))
        );
    }
}