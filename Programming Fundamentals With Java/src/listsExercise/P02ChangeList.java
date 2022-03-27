package listsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        changeList(scanner, numbers, line);
    }

    private static void changeList(Scanner scanner, List<Integer> numbers, String line) {
        while (!line.equals("end")) {
            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Delete":
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == Integer.parseInt(data[1])) {
                            numbers.remove(i);
                            i--;
                        }
                    }
                    break;
                case "Insert":
                    numbers.add(Integer.parseInt(data[2]), Integer.parseInt(data[1]));
                    break;

            }
            line = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}