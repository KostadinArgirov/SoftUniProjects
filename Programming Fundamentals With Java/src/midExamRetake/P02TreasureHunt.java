package midExamRetake;

import java.util.*;
import java.util.stream.Collectors;

public class P02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        List<String> initialTreasureChest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());
//
//        String input = scanner.nextLine();
//
//        while (!input.equals("Yohoho!")) {
//            String[] data = input.split("\\s+");
//            String command = data[0];
//
//            switch (command) {
//                case "Loot":
//                    for (int i = 1; i < data.length; i++) {
//                        String item = data[i];
//                        if (!initialTreasureChest.contains(item)) {
//                            initialTreasureChest.add(0, item);
//                        }
//                    }
//                    break;
//                case "Drop":
//                    int index = Integer.parseInt(data[1]);
//                    if (index >= 0 && index < initialTreasureChest.size()) {
//                        String temp = initialTreasureChest.get(index);
//                        if (initialTreasureChest.contains(temp)) {
//                            initialTreasureChest.remove(index);
//                            initialTreasureChest.add(temp);
//                        }
//                }
//                    break;
//                case "Steal":
//                    List<String> stolenItemsList = new ArrayList<>();
//                    int stolenItemsNumber = Integer.parseInt(data[1]);
//                    if (stolenItemsNumber < initialTreasureChest.size()) {
//                        for (int i = initialTreasureChest.size() - 1; i > stolenItemsNumber + 1; i--) {
//                            stolenItemsList.add(initialTreasureChest.get(i));
//                        }
//                    } else {
//                        stolenItemsList = initialTreasureChest;
//                        initialTreasureChest.clear();
//                    }
//                    Collections.reverse(stolenItemsList);
//                    printResult(stolenItemsList);
//                    System.out.println();
//                    break;
//            }
//
//            input = scanner.nextLine();
//        }
//        String sumOfLetters = "";
//
//        for (int i = 0; i < initialTreasureChest.size(); i++) {
//            sumOfLetters += initialTreasureChest.get(i);
//        }
//        int sumAllLetters = sumOfLetters.length();
//        double averageTreasureGain = ((sumAllLetters * 1.0) / initialTreasureChest.size());
//
//        if (initialTreasureChest.isEmpty()) {
//            System.out.println("Failed treasure hunt.");
//        } else {
//            System.out.printf("Average treasure gain: %.2f pirate credits.", averageTreasureGain);
//        }
//    }
//    private static void printResult(List<String> str) {
//        for (int i = 0; i < str.size(); i++) {
//            if (i != str.size() -1) {
//                System.out.print(str.get(i) + ", ");
//            } else {
//                System.out.print(str.get(i));
//            }
//        }
//    }
//}


        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!"Yohoho!".equals(line)) {
            List<String> treasure = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
            String command = treasure.get(0);

            switch (command) {
                case "Loot":
                    for (int i = 1; i < treasure.size(); i++) {
                        if (!initialLoot.contains(treasure.get(i))) {
                            initialLoot.add(0, treasure.get(i));
                        }
                    }

                    break;
                case "Drop":
                    int index = Integer.parseInt(treasure.get(1));

                    if (index >= 0 && index < initialLoot.size()) {
                        String item = initialLoot.get(index);
                        initialLoot.remove(index);
                        initialLoot.add(item);
                    }

                    break;
                case "Steal":
                    int count = Integer.parseInt(treasure.get(1));

                    if (count > initialLoot.size()) {
                        count = initialLoot.size();
                    }

                    List<String> subList = initialLoot.subList(initialLoot.size() - count, initialLoot.size());

                    System.out.println(String.join(", ", subList));

                    initialLoot = initialLoot.subList(0, initialLoot.size() - count);

                    break;
            }

            line = scanner.nextLine();
        }

        if (!initialLoot.isEmpty()) {
            int sumLengthItem = 0;

            for (String currentItem : initialLoot) {
                sumLengthItem += currentItem.length();
            }

            double averageGain = sumLengthItem * 1.0 / initialLoot.size();

            System.out.printf("Average treasure gain: %.2f pirate credits.%n", averageGain);
        } else {
            System.out.println("Failed treasure hunt.");
        }
    }
}