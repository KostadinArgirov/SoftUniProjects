
package oop.workingWithAbstractionExercise.greedyTimes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String item;
    static String itemType;
    static long quantity;
    static long quantityInTheBag;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] treasure = scanner.nextLine().split("\\s+");

        List<ItemType> bag = new ArrayList<>();

        for (int i = 0; i < treasure.length; i += 2) {
            item = treasure[i];

            quantity = Long.parseLong(treasure[i + 1]);

            itemType = getItemKind();

            if (itemType == null ||
                    bagCapacity < quantityInTheBag + quantity ||
                    notCoverRules()) {
                continue;
            }

            putItemInBag(bag);
        }

        print(bag);
    }

    private static void putItemInBag(List<ItemType> bag) {

        if (bag.contains(ItemType.parse(itemType))) {

            int index = bag.indexOf(ItemType.parse(itemType));

            ItemType itemTypeToUpdate = bag.get(index);

            itemTypeToUpdate.addItem(item, quantity);

        } else {
            Item itemToPut = new Item(item, quantity);

            List<Item> listToPut = new ArrayList<>();

            listToPut.add(itemToPut);

            ItemType.parse(itemType).setListOfItems(listToPut);

            bag.add(ItemType.parse(itemType));
        }

        quantityInTheBag += quantity;
    }

    private static void print(List<ItemType> bag) {
        bag.forEach(s -> System.out.println(s.getInfo()));
    }

    private static boolean notCoverRules() {
        long goldInBag = ItemType.GOLD.sumQuantity();
        long gemInBag = ItemType.GEM.sumQuantity();
        long newItemTypeQuantity = ItemType.parse(itemType).sumQuantity() + quantity;

        if (itemType.equals("Gem") && quantity > goldInBag) {
            return true;
        }

        return itemType.equals("Cash") && (quantity > goldInBag || newItemTypeQuantity > gemInBag);
    }

    private static String getItemKind() {
        itemType = null;

        if (item.length() == 3) {
            itemType = "Cash";
        } else if (item.toLowerCase().endsWith("gem")) {
            itemType = "Gem";
        } else if (item.equals("Gold")) {
            itemType = "Gold";
        }

        return itemType;
    }
}