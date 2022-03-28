import java.util.Scanner;

public class P05BestPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        String maxScoreName = "";
        int maxScore = Integer.MIN_VALUE;
        boolean isMadeHatTrick = false;
        int scoreNumber = 0;

        while (!name.equals("END")) {
            scoreNumber = Integer.parseInt(scanner.nextLine());

            if (scoreNumber > maxScore) {
                maxScore = scoreNumber;
                maxScoreName = name;
            }

            if (scoreNumber >= 3) {
                isMadeHatTrick = true;
                if (scoreNumber >= 10) {
                    break;
                }
            }
            name = scanner.nextLine();
        }
        if (isMadeHatTrick) {
            System.out.printf("%s is the best player!\nHe has scored %d goals and made a hat-trick !!!", maxScoreName, maxScore);
        } else {
            System.out.printf("%s is the best player!\nHe has scored %d goals.", maxScoreName, maxScore);
            return;
        }
    }
}
