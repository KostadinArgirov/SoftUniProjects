import java.util.Scanner;

public class P04GameNumberWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String player1 = scanner.nextLine();
        String player2 = scanner.nextLine();

        int player1Points = 0;
        int player2Points = 0;

        String input = scanner.nextLine();

        while (!input.equals("End of game")) {

            int card1 = Integer.parseInt(input);
            int card2 = Integer.parseInt(scanner.nextLine());

            if (card1 > card2) {
                player1Points += card1 - card2;
            } else if (card1 < card2) {
                player2Points += card2 - card1;
            } else {
                System.out.println("Number wars!");
                card1 = Integer.parseInt(scanner.nextLine());
                card2 = Integer.parseInt(scanner.nextLine());
                if (card1 > card2) {
                    System.out.printf("%s is winner with %d points", player1, player1Points);
                } else {
                    System.out.printf("%s is winner with %d points", player2, player2Points);
                }
                return;
            }
            input = scanner.nextLine();
        }
        System.out.printf("%s has %d points\n", player1, player1Points);
        System.out.printf("%s has %d points", player2, player2Points);
    }
}