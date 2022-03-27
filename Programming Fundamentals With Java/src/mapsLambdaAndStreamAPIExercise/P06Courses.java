package mapsLambdaAndStreamAPIExercise;

import java.util.*;

public class P06Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] data = input.split(" : ");
            String course = data[0];
            String student = data[1];
            if (!courses.containsKey(course)) {
                courses.put(course, new ArrayList<>());
                courses.get(course).add(student);
            } else {
                courses.get(course).add(student);
            }
            input = scanner.nextLine();
        }
        courses.forEach((key, value) -> {
            System.out.printf("%s: %d%n", key, value.size());
            value.forEach(e -> System.out.printf("-- %s%n", e));
        });

    }
}