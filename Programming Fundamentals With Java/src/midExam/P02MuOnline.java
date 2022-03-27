package midExam;

import java.util.Scanner;

public class P02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dungeonsRooms = scanner.nextLine().split("\\|");

        int initialHealth = 100;
        int totalBitcoins = 0;

        for (int i = 0; i < dungeonsRooms.length; i++) {
            String[] data = dungeonsRooms[i].split(" ");
            String command = data[0];

            switch (command) {
                case "potion":
                    int heal = Integer.parseInt(data[1]);
                    if (initialHealth + heal <= 100) {
                        initialHealth += heal;
                        System.out.printf("You healed for %d hp.%n", heal);
                        System.out.printf("Current health: %d hp.%n", initialHealth);
                    } else {
                        System.out.printf("You healed for %d hp.%n", 100 - initialHealth);
                        initialHealth = 100;
                        System.out.printf("Current health: %d hp.%n", initialHealth);
                    }
                    break;
                case "chest":
                    int bitcoinsFound = Integer.parseInt(data[1]);
                    System.out.printf("You found %d bitcoins.%n", bitcoinsFound);
                    totalBitcoins += bitcoinsFound;
                    break;
                default:
                    int monsterAttack = Integer.parseInt(data[1]);
                    if (initialHealth - monsterAttack > 0) {
                        System.out.printf("You slayed %s.%n", command);
                        initialHealth -= monsterAttack;
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d", i + 1);
                        return;
                    }
                    break;
            }
        }
        System.out.printf("You've made it!%n" +
                "Bitcoins: %d%n" +
                "Health: %d", totalBitcoins, initialHealth);
    }
}