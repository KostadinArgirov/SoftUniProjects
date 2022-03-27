package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> friends = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        int blacklistedCount = 0;
        int lostCount = 0;

        String input = scanner.nextLine();

        while (!input.equals("Report")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Blacklist":
                    String name = data[1];
                    if (!friends.contains(name)) {
                        System.out.printf("%s was not found.%n", name);
                        break;
                    }
                    for (int i = 0; i < friends.size(); i++) {
                        if (friends.get(i).equals(name)) {
                            friends.set(i, "Blacklisted");
                            blacklistedCount++;
                            System.out.printf("%s was blacklisted.%n", name);
                        }
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < friends.size()) {
                        if (!friends.get(index).equals("Blacklisted") && !friends.get(index).equals("Lost")) {
                            lostCount++;
                            System.out.printf("%s was lost due to an error.%n", friends.get(index));
                            friends.set(index, "Lost");
                        }
                    }
                    break;
                case "Change":
                    change(friends, data);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d %n" +
                "Lost names: %d%n", blacklistedCount, lostCount);

        printResult(friends);
    }

    private static void change(List<String> friends, String[] data) {
        int index;
        index = Integer.parseInt(data[1]);
        String newName = data[2];
        if (index >= 0 && index < friends.size()) {
            System.out.printf("%s changed his username to %s.%n", friends.get(index), newName);
            friends.set(index, newName);
        }
    }

    private static void printResult(List<String> initialList) {
        for (int i = 0; i < initialList.size(); i++) {
            if (i != initialList.size() -1) {
                System.out.print(initialList.get(i) + " ");
            } else {
                System.out.print(initialList.get(i));
            }
        }
    }
}