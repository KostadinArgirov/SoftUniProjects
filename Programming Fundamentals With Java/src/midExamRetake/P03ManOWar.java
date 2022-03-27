package midExamRetake;

import java.util.Arrays;
import java.util.Scanner;

public class P03ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int[] warship = Arrays.stream(scanner.nextLine().split(">")).mapToInt(Integer::parseInt).toArray();
        int maxHealth = Integer.parseInt(scanner.nextLine());

        int sumPirateShip = 0;
        int sumWarship = 0;

        String input = scanner.nextLine();

        while (!input.equals("Retire")) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Fire":
                    if (fire(pirateShip, warship, data)) return;
                    break;
                case "Defend":
                    if (defend(pirateShip, data)) return;
                    break;
                case "Repair":
                    repair(pirateShip, maxHealth, data);
                    break;
                case "Status":
                    status(pirateShip, maxHealth);
                    break;
            }
            input = scanner.nextLine();
        }
        for (int section : pirateShip) {
            sumPirateShip += section;
        }
        for (int section : warship) {
            sumWarship += section;
        }
        System.out.printf("Pirate ship status: %d%n" +
                "Warship status: %d%n", sumPirateShip, sumWarship);
    }

    private static boolean fire(int[] pirateShip, int[] warship, String[] data) {
        int index = Integer.parseInt(data[1]);
        int damage = Integer.parseInt(data[2]);
        if (index >= 0 && index < pirateShip.length) {
            if (warship[index] <= damage) {
                System.out.println("You won! The enemy ship has sunken.");
                return true;
            } else {
                warship[index] -= damage;
            }
        }
        return false;
    }

    private static boolean defend(int[] pirateShip, String[] data) {
        int index;
        int damage;
        index = Integer.parseInt(data[1]);
        int endIndex = Integer.parseInt(data[2]);
        damage = Integer.parseInt(data[3]);
        if (index >= 0 && index < pirateShip.length && endIndex >= 0 && endIndex < pirateShip.length) {
            for (int i = index; i <= endIndex; i++) {
                if (pirateShip[i] <= damage) {
                    System.out.println("You lost! The pirate ship has sunken.");
                    return true;
                } else {
                    pirateShip[i] -= damage;
                }
            }
        }
        return false;
    }

    private static void repair(int[] pirateShip, int maxHealth, String[] data) {
        int index;
        index = Integer.parseInt(data[1]);
        int heal = Integer.parseInt(data[2]);
        if (index >= 0 && index < pirateShip.length) {
            if (pirateShip[index] + heal <= maxHealth) {
                pirateShip[index] += heal;
            } else {
                pirateShip[index] = maxHealth;
            }
        }
    }

    private static void status(int[] pirateShip, int maxHealth) {
        int count = 0;
        for (int i = 0; i < pirateShip.length; i++) {
            if (pirateShip[i] < 0.2 * maxHealth) {
                count++;
            }
        }
        System.out.printf("%d sections need repair.%n", count);
    }
}