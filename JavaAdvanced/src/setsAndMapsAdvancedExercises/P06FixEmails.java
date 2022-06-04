package setsAndMapsAdvancedExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contacts = new LinkedHashMap<>();

        String name = scanner.nextLine();

        while (!name.equals("stop")) {

            String email = scanner.nextLine();

            if (!email.contains(".us") && !email.contains(".com") && !email.contains(".uk")) {
                contacts.put(name, email);
            }

            name = scanner.nextLine();
        }
        for (var contact : contacts.entrySet()) {
            System.out.printf("%s -> %s%n", contact.getKey(), contact.getValue());
        }
    }
}