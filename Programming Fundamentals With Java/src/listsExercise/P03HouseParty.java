package listsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        partyGuests(scanner);
    }

    private static void partyGuests(Scanner scanner) {
        List<String> guests = new ArrayList<>();
        int commandsNumber = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < commandsNumber; i++) {
            String line = scanner.nextLine();
            String[] data = line.split("\\s+");
            String name = data[0];
            if (!line.contains("is not going!")) {
                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!\n", name);
                } else {
                    guests.add(name);
                }
            } else {
                if (guests.contains(name)) {
                    guests.remove(name);
                } else {
                    System.out.printf("%s is not in the list!\n", name);
                }
            }
        }
        for (int i = 0; i < guests.size(); i++) {
            System.out.println(guests.get(i));
        }
    }
}