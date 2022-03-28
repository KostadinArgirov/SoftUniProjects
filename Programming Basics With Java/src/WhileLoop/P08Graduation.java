import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int counter = 0;
        int poor = 0;
        double gradesSum = 0.0;

        while (counter < 12) {
            double gradeScore = Double.parseDouble(scanner.nextLine());

            if (gradeScore >= 4) {
                gradesSum += gradeScore;
            } else {
                gradesSum += gradeScore;
                ++poor;
                if (poor == 2) {
                    System.out.printf("%s has been excluded at %d grade", name, counter);
                    break;
                }
            }
            counter++;
        }
        if (counter == 12) {
            gradesSum /= 12;
            System.out.printf("%s graduated. Average grade: %.2f", name, gradesSum);
        }
    }
}