import java.util.Scanner;

public class P04Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsOnExam = Integer.parseInt(scanner.nextLine());

        double scoreSum = 0.0;
        int badStudents = 0;
        int middleStudents = 0;
        int averageStudents = 0;
        int topStudents = 0;

        for (int i = 0; i < studentsOnExam; i++) {
            double examScore = Double.parseDouble(scanner.nextLine());

            if (examScore >= 2.00 && examScore <= 2.99) {
                scoreSum += examScore;
                badStudents++;
            } else if (examScore >= 3.00 && examScore <= 3.99) {
                scoreSum += examScore;
                middleStudents++;
            } else if (examScore >= 4.00 && examScore <= 4.99) {
                scoreSum += examScore;
                averageStudents++;
            } else if (examScore >= 5) {
                scoreSum += examScore;
                topStudents++;
            }
        }
        System.out.printf("Top students: %.2f%%\n", (1.0 * topStudents / studentsOnExam) * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%\n", (1.0 * averageStudents / studentsOnExam) * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%\n", (1.0 * middleStudents / studentsOnExam) * 100);
        System.out.printf("Fail: %.2f%%\n", (1.0 * badStudents / studentsOnExam) * 100);
        System.out.printf("Average: %.2f", scoreSum / studentsOnExam);
    }
}
