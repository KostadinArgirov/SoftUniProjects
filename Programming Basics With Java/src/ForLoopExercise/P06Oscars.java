import java.util.Scanner;

public class P06Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        double academyPoints = Double.parseDouble(scanner.nextLine());
        int evaluating = Integer.parseInt(scanner.nextLine());

        double sumPoints = academyPoints;
        boolean isTrue = false;
        int evaluatingNameLength = 0;

        for (int i = 1; i <= evaluating; i++) {
            String evaluatingName = scanner.nextLine();
            double evaluatingPoints = Double.parseDouble(scanner.nextLine());

            evaluatingNameLength = evaluatingName.length();
            double momentPoints = (evaluatingNameLength * evaluatingPoints) / 2;
            sumPoints += momentPoints;

            if (sumPoints >= 1250.5) {
                isTrue = true;
                System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", name, sumPoints);
                break;
            }
        }
        if (sumPoints < 1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!", name, 1250.5 - sumPoints);
        }
    }
}
