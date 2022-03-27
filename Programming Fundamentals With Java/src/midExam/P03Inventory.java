package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] data = input.split(" - ");
            String command = data[0];
            String item = data[1];

            switch (command) {
                case "Collect":
                    if (!items.contains(item)) {
                        items.add(item);
                    }
                    break;
                case "Drop":
                    items.remove(item);
                    break;
                case "Combine Items":
                    combineItems(items, data[1]);
                    break;
                case "Renew":
                    if (items.contains(item)) {
                        items.remove(item);
                        items.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        printResult(items);
    }

    private static void combineItems(List<String> items, String datum) {
        String[] oldNewItem = datum.split(":");
        String oldItem = oldNewItem[0];
        String newItem = oldNewItem[1];
        if (items.contains(oldNewItem[0])) {
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).equals(oldItem)) {
                    items.add(i + 1, newItem);
                }
            }
        }
    }

    private static void printResult(List<String> str) {
        for (int i = 0; i < str.size(); i++) {
            if (i != str.size() -1) {
                System.out.print(str.get(i) + ", ");
            } else {
                System.out.print(str.get(i));
            }
        }
    }
}