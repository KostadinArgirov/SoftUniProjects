import java.util.Scanner;

public class P06BasketballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int totalMatches = 0;
        int winCounter = 0;
        int lostCounter = 0;

        while (!name.equals("End of tournaments")) {
            int gamesNumber = Integer.parseInt(scanner.nextLine());

            int diff = 0;
            int currentTournamentMatches = 0;

            for (int i = 0; i < gamesNumber; i++) {
                int hostsResult = Integer.parseInt(scanner.nextLine());
                int guestsResult = Integer.parseInt(scanner.nextLine());

                totalMatches++;
                currentTournamentMatches++;

                if (hostsResult > guestsResult) {
                    winCounter++;
                    diff = hostsResult - guestsResult;
                    System.out.printf("Game %d of tournament %s: win with %d points.\n", currentTournamentMatches, name, diff);

                } else if (hostsResult < guestsResult) {
                    lostCounter++;
                    diff = guestsResult - hostsResult;
                    System.out.printf("Game %d of tournament %s: lost with %d points.\n", currentTournamentMatches, name, diff);
                }
            }
            name = scanner.nextLine();
        }
        System.out.printf("%.2f%% matches win\n", (winCounter * 1.0 / totalMatches) * 100);
        System.out.printf("%.2f%% matches lost", (lostCounter * 1.0 / totalMatches) * 100);
    }
}