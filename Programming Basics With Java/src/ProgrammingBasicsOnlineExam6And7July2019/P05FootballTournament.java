import java.util.Scanner;

public class P05FootballTournament {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int numberGames = Integer.parseInt(scanner.nextLine());

        int w = 0;
        int d = 0;
        int l = 0;

        for (int i = 1; i <= numberGames; i++) {
            String result = scanner.nextLine();

            switch (result) {
                case "W":
                    w++;
                    break;
                case "D":
                    d++;
                    break;
                case "L":
                    l++;
                    break;
            }
        }
        if (numberGames < 1) {
            System.out.printf("%s hasn't played any games during this season.", name);
        } else {
            System.out.printf("%s has won %d points during this season.\n", name, w * 3 + d);
            System.out.println("Total stats:");
            System.out.printf("## W: %d\n", w);
            System.out.printf("## D: %d\n", d);
            System.out.printf("## L: %d\n", l);
            System.out.printf("Win rate: %.2f%%", (w * 1.0 / numberGames) * 100);
        }
    }
}