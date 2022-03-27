package midExam;

import java.util.Arrays;
import java.util.Scanner;

public class P02ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commands = input.split("\\s+");
            String token = commands[0];

            switch (token) {
                case "swap":
                    int index1;
                    int index2;
                    swap(numbers, commands);
                    break;
                case "multiply":
                    index1 = Integer.parseInt(commands[1]);
                    index2 = Integer.parseInt(commands[2]);
                    int multiply = numbers[index1] * numbers[index2];
                    numbers[index1] = multiply;
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] -= 1;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.print(Arrays.toString(numbers).replaceAll("[\\[\\]]", ""));
    }

    private static void swap(int[] numbers, String[] commands) {
        int index1 = Integer.parseInt(commands[1]);
        int index2 = Integer.parseInt(commands[2]);
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}