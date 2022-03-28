import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juryNumber = Integer.parseInt(scanner.nextLine());

        String presentationName = scanner.nextLine();
        double allScoresSum = 0.0;
        int presentationsCount = 0;

        while (!"Finish".equals(presentationName)) {

            double scoreSum = 0;

            for (int i = 0; i < juryNumber; i++) {
                double currentScore = Double.parseDouble(scanner.nextLine());
                scoreSum += currentScore;
            }
            allScoresSum += scoreSum;
            System.out.printf("%s - %.2f.\n", presentationName, scoreSum / juryNumber);
            presentationsCount++;
            scoreSum = 0.0;
            presentationName = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", allScoresSum / (juryNumber * presentationsCount));
    }
}