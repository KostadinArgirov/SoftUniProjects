package listsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ListManipulationAdvanced {
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
                case "Contains":
                    contains(numbers, data);
                    break;
                case "Print":
                    printEvenOrOdd(numbers, data);
                    break;
                case "Get":
                    get(numbers);
                    break;
                case "Filter":
                    filter(numbers, data);
                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static void contains(List<Integer> numbers, String[] data) {
        if (numbers.contains(Integer.parseInt(data[1]))) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
    private static void printEvenOrOdd(List<Integer> numbers, String[] data) {
        if (data[1].equals("even")) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 == 0) {
                    System.out.print(numbers.get(i) + " ");
                }
            }
        } else if (data[1].equals("odd")) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 != 0) {
                    System.out.print(numbers.get(i) + " ");
                }
            }
        }
        System.out.println();
    }
    private static void get(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        System.out.println(sum);
    }
    private static void filter(List<Integer> numbers, String[] data) {
        String outputFilter = "";
        int num = Integer.parseInt(data[2]);
        if (data[1].equals("<")) {
            for (Integer aList : numbers) {
                if (aList < num) {
                    outputFilter += String.valueOf(aList) + " ";

                }
            }
            System.out.println(outputFilter);
        } else if (data[1].equals(">")) {
            for (Integer aList : numbers) {
                if (aList > num) {
                    outputFilter += String.valueOf(aList) + " ";

                }
            }
            System.out.println(outputFilter);
        } else if (data[1].equals(">=")) {
            for (Integer aList : numbers) {
                if (aList >= num) {
                    outputFilter += String.valueOf(aList) + " ";

                }
            }
            System.out.println(outputFilter);
        } else if (data[1].equals("<=")) {
            for (Integer aList : numbers) {
                if (aList <= num) {
                    outputFilter += String.valueOf(aList) + " ";

                }
            }
            System.out.println(outputFilter);
        }
    }
}