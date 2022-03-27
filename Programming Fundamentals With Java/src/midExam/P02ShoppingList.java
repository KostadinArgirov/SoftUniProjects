package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!"Go Shopping!".equals(input)) {
            String[] commands = input.split("\\s+");
            String item = commands[1];

            switch (commands[0]) {
                case "Urgent":
                    if (!initialList.contains(commands[1])) {
                        initialList.add(0, commands[1]);
                    }
                    break;
                case "Unnecessary":
                    if (initialList.contains(commands[1])) {
                        initialList.remove(item);
                    }
                    break;
                case "Correct":
                    correct(initialList, commands, item);
                    break;
                case "Rearrange":
                    rearrange(initialList, commands, item);
                    break;
            }
            input = scanner.nextLine();
        }
        printResult(initialList);
    }

    private static void correct(List<String> initialList, String[] commands, String item) {
        String newItem = commands[2];
        if (initialList.contains(commands[1])) {
            for (int i = 0; i < initialList.size(); i++) {
                if (initialList.get(i).equals(item)) {
                    initialList.set(i, newItem);
                }
            }
        }
    }

    private static void rearrange(List<String> initialList, String[] commands, String item) {
        if (initialList.contains(commands[1])) {
            initialList.remove(item);
            initialList.add(item);
        }
    }

    private static void printResult(List<String> initialList) {
        for (int i = 0; i < initialList.size(); i++) {
            if (i != initialList.size() -1) {
                System.out.print(initialList.get(i) + ", ");
            } else {
                System.out.print(initialList.get(i));
            }
        }
    }
}