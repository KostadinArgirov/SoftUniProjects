package mapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, String> users = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0];
            String username = data[1];

            switch (command) {
                case "register":
                    String licensePlateNumber = data[2];

                    if (users.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    } else {
                        users.putIfAbsent(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    }

                    break;
                case "unregister":
                    if (!users.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        users.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }
        }
        users.forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }
}