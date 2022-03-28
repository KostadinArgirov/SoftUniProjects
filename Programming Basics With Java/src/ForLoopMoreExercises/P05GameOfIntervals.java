import java.util.Scanner;

public class P05GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int gameTurns = Integer.parseInt(scanner.nextLine());

        double score = 0.0;
        int case1 = 0;
        int case2 = 0;
        int case3 = 0;
        int case4 = 0;
        int case5 = 0;
        int case6 = 0;

        for (int i = 0; i < gameTurns; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (number >= 0 && number < 10) {
                score += number * 0.2;
                case1++;
            } else if (number >= 10 && number < 20) {
                score += number * 0.3;
                case2++;
            } else if (number >= 20 && number < 30) {
                score += number * 0.4;
                case3++;
            } else if (number >= 30 && number < 40) {
                score += 50;
                case4++;
            } else if (number >= 40 && number <= 50) {
                score += 100;
                case5++;
            } else {
                score = score / 2;
                case6++;
            }
        }
        System.out.printf("%.2f\n", score);
        System.out.printf("From 0 to 9: %.2f%%\n", (1.0 * case1 / gameTurns) * 100);
        System.out.printf("From 10 to 19: %.2f%%\n", (1.0 * case2 / gameTurns) * 100);
        System.out.printf("From 20 to 29: %.2f%%\n", (1.0 * case3 / gameTurns) * 100);
        System.out.printf("From 30 to 39: %.2f%%\n", (1.0 * case4 / gameTurns) * 100);
        System.out.printf("From 40 to 50: %.2f%%\n", (1.0 * case5 / gameTurns) * 100);
        System.out.printf("Invalid numbers: %.2f%%", (1.0 * case6 / gameTurns) * 100);
    }
}
