import java.util.Scanner;

public class P04Darts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String player = scanner.nextLine();
        int initialPoints = 301;
        boolean isWon = false;
        int successfulShots = 0;
        int unSuccessfulShots = 0;

        String command = scanner.nextLine();

        while (!command.equals("Retire")) {
            int points = Integer.parseInt(scanner.nextLine());

            switch (command) {
                case "Double":
                    points *= 2;
                    break;
                case "Triple":
                    points *= 3;
                    break;
            }
            if (points <= initialPoints) {
                initialPoints -= points;
                successfulShots++;
                if (initialPoints == 0) {
                    isWon = true;
                    break;
                }
            } else {
                unSuccessfulShots++;
            }
            command = scanner.nextLine();
        }
        if (isWon) {
            System.out.printf("%s won the leg with %d shots.", player, successfulShots);
        } else {
            System.out.printf("%s retired after %d unsuccessful shots.", player, unSuccessfulShots);
        }
    }
}