package midExamRetake;

import java.util.Scanner;

public class P01CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());

        int wins = 0;

        String input = scanner.nextLine();

        while (initialEnergy >= 0) {

            if (input.equals("End of battle")) {
                break;
            } else {
                int distance = Integer.parseInt(input);

                if (initialEnergy < distance) {
                    System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wins, initialEnergy);
                    return;
                }
                initialEnergy -= distance;
                wins++;
                if (wins % 3 == 0) {
                    initialEnergy += wins;
                }
            }
            input = scanner.nextLine();
        }
        if (initialEnergy >= 0) {
            System.out.printf("Won battles: %d. Energy left: %d",wins,initialEnergy);
        }
    }
}