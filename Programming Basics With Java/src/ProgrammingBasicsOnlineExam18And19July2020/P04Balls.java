import java.util.Scanner;

public class P04Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ballsNumber = Integer.parseInt(scanner.nextLine());

        String ballsColor = "";
        double totalPoints = 0;
        int redBallsCount = 0;
        int orangeBallsCount = 0;
        int yellowBallsCount = 0;
        int whiteBallsCount = 0;
        int otherBallsCount = 0;
        int blackBallsCount = 0;

        for (int i = 0; i < ballsNumber; i++) {
            ballsColor = scanner.nextLine();
            switch (ballsColor) {
                case "red":
                    totalPoints += 5;
                    redBallsCount++;
                    break;
                case "orange":
                    totalPoints += 10;
                    orangeBallsCount++;
                    break;
                case "yellow":
                    totalPoints += 15;
                    yellowBallsCount++;
                    break;
                case "white":
                    totalPoints += 20;
                    whiteBallsCount++;
                    break;
                case "black":
                    totalPoints = Math.floor(totalPoints / 2);
                    blackBallsCount++;
                    break;
                default:
                    otherBallsCount++;
                    break;
            }
        }
        System.out.printf("Total points: %.0f\n", totalPoints);
        System.out.printf("Points from red balls: %d\n", redBallsCount);
        System.out.printf("Points from orange balls: %d\n", orangeBallsCount);
        System.out.printf("Points from yellow balls: %d\n", yellowBallsCount);
        System.out.printf("Points from white balls: %d\n", whiteBallsCount);
        System.out.printf("Other colors picked: %d\n", otherBallsCount);
        System.out.printf("Divides from black balls: %d", blackBallsCount);
    }
}