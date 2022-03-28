import java.util.Scanner;

public class P06EasterCompetition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreads = Integer.parseInt(scanner.nextLine());

        int maxPoints = Integer.MIN_VALUE;
        String winner = "";

        for (int i = 0; i < easterBreads; i++) {

            int points = 0;

            String name = scanner.nextLine();

            String input = scanner.nextLine();

            while (!input.equals("Stop")) {
                int score = Integer.parseInt(input);

                points += score;

                input = scanner.nextLine();
            }
            System.out.printf("%s has %d points.\n", name, points);

            if (points > maxPoints) {
                maxPoints = points;
                winner = name;
                System.out.printf("%s is the new number 1!\n", name);
            }
            points = 0;
        }
        System.out.printf("%s won competition with %d points!", winner, maxPoints);
    }
}