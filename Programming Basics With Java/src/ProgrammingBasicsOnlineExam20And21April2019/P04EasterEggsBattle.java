import java.util.Scanner;

public class P04EasterEggsBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int player1Eggs = Integer.parseInt(scanner.nextLine());
        int player2Eggs = Integer.parseInt(scanner.nextLine());
        String winner = "";

        while (!"End of battle".equals(winner = scanner.nextLine())) {

            switch (winner) {
                case "one":
                    player2Eggs -= 1;
                    break;
                case "two":
                    player1Eggs -= 1;
                    break;
            }
            if (player1Eggs == 0) {
                System.out.printf("Player one is out of eggs. Player two has %d eggs left.", player2Eggs);
                return;
            } else if (player2Eggs == 0) {
                System.out.printf("Player two is out of eggs. Player one has %d eggs left.", player1Eggs);
                return;
            }
        }
            System.out.printf("Player one has %d eggs left.\nPlayer two has %d eggs left.", player1Eggs, player2Eggs);
    }
}