package midExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cards = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfCommands; i++) {
            String[] data = scanner.nextLine().split(", ");
            String command = data[0];

            switch (command) {
                case "Add":
                    add(cards, data[1]);
                    break;
                case "Remove":
                    remove(cards, data);
                    break;
                case "Remove At":
                    removeAt(cards, data[1]);
                    break;
                case "Insert":
                    insert(cards, data);
                    break;
            }
        }
        printResult(cards);
    }

    private static void add(List<String> cards, String datum) {
        String card = datum;
        if (cards.contains(card)) {
            System.out.println("Card is already in the deck");
        } else {
            cards.add(card);
            System.out.println("Card successfully added");
        }
    }

    private static void remove(List<String> cards, String[] data) {
        String card;
        card = data[1];
        if (cards.contains(card)) {
            cards.remove(card);
            System.out.println("Card successfully removed");
        } else {
            System.out.println("Card not found");
        }
    }

    private static void removeAt(List<String> cards, String datum) {
        int index = Integer.parseInt(datum);
        if (index >= 0 && index < cards.size()) {
            cards.remove(index);
            System.out.println("Card successfully removed");
        } else {
            System.out.println("Index out of range");
        }
    }

    private static void insert(List<String> cards, String[] data) {
        String card;
        int index;
        index = Integer.parseInt(data[1]);
        card = data[2];
        if (index >= 0 && index < cards.size()) {
            if (cards.contains(card)) {
                System.out.println("Card is already added");
            } else {
                cards.add(index, card);
                System.out.println("Card successfully added");
            }
        } else {
            System.out.println("Index out of range");
        }
    }

    private static void printResult(List<String> cards) {
        for (int i = 0; i < cards.size(); i++) {
            if (i != cards.size() -1) {
                System.out.print(cards.get(i) + ", ");
            } else {
                System.out.print(cards.get(i));
            }
        }
    }
}