package midExam;

import java.util.Scanner;

public class P02FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // дава 90/100 точки в Judge

        String[] friends = scanner.nextLine().split(", ");

        int blacklistedCount = 0;
        int lostCount = 0;

        String input = scanner.nextLine();

        while (!input.equals("Report")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Blacklist":
                    String name = data[1];
                    for (int i = 0; i < friends.length; i++) {
                        if (friends[i].equals(name)) {
                            friends[i] = "Blacklisted";
                            blacklistedCount++;
                            System.out.printf("%s was blacklisted.%n", name);
                        }
                    }
                    boolean isNotFound = true;
                    for (int i = 0; i < friends.length; i++) {
                        if (friends[i].equals("Blacklisted")) {
                            isNotFound = false;
                        }
                    }
                    if (isNotFound) {
                        System.out.printf("%s was not found.%n", name);
                    }
                    break;
                case "Error":
                    int index = Integer.parseInt(data[1]);
                    if (index >= 0 && index < friends.length) {
                            if (!friends[index].equals("Blacklisted") && !friends[index].equals("Lost")) {
                                lostCount++;
                                System.out.printf("%s was lost due to an error.%n", friends[index]);
                                friends[index] = "Lost";
                            }
                    }
                    break;
                case "Change":
                    index = Integer.parseInt(data[1]);
                    String newName = data[2];
                    if (index >= 0 && index < friends.length) {
                        System.out.printf("%s changed his username to %s.%n", friends[index], newName);
                        friends[index] = newName;
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d %n" +
                "Lost names: %d%n", blacklistedCount, lostCount);

        for (int i = 0; i < friends.length; i++) {
            if (i != friends.length - 1) {
                System.out.print(friends[i] + " ");
            } else {
                System.out.print(friends[i]);
            }
        }
    }
}