package listsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Add":
                    numbers.add(Integer.parseInt(data[1]));
                    break;
                case "Remove":
                    Integer integer = Integer.parseInt(data[1]);
                    numbers.remove(integer);
                    break;
                case "RemoveAt":
                    numbers.remove(Integer.parseInt(data[1]));
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