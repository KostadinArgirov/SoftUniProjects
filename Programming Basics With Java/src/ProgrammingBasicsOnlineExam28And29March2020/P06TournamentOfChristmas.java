import java.util.Scanner;

public class P06TournamentOfChristmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        double totalRaisedMoney = 0;
        boolean isWin = false;
        double dayMoneySave = 0;
        int totalWinsCount = 0;
        int totalLoseCount = 0;

        for (int i = 0; i < days; i++) {

            int winsCount = 0;
            int loseCount = 0;

            String sport = scanner.nextLine();

            while (!"Finish".equals(sport)) {
                String result = scanner.nextLine();

                switch (result) {
                    case "win":
                        winsCount++;
                        dayMoneySave += 20;
                        totalWinsCount++;
                        break;
                    case "lose":
                        loseCount++;
                        totalLoseCount++;
                        break;
                }
                sport = scanner.nextLine();
            }
            if (winsCount > loseCount) {
                dayMoneySave *= 1.1;
            }
            winsCount = 0;

            totalRaisedMoney += dayMoneySave;
            dayMoneySave = 0;
        }
        if (totalWinsCount > totalLoseCount) {
            totalRaisedMoney *= 1.2;
            System.out.printf("You won the tournament! Total raised money: %.2f", totalRaisedMoney);
        } else {
            System.out.printf("You lost the tournament! Total raised money: %.2f", totalRaisedMoney);
        }
    }
}