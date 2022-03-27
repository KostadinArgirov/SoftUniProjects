package mapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();

        Map<String, Integer> resources = new LinkedHashMap<>();

        while (!resource.equals("stop")) {

            int quantity = Integer.parseInt(scanner.nextLine());

            resources.putIfAbsent(resource, 0);
            resources.put(resource, resources.get(resource) + quantity);

//            if (!resources.containsKey(resource)) {
//                resources.put(resource, quantity);
//            } else {
//                resources.put(resource, resources.get(resource) + quantity);
//            }

            resource = scanner.nextLine();
        }
        resources.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}