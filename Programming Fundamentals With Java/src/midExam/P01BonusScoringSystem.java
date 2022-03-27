package midExam;

import java.util.Scanner;

public class P01BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfLectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int totalAttendances = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            int attendance = Integer.parseInt(scanner.nextLine());
            double totalBonus = (1.0 * attendance / numberOfLectures) * (5 + additionalBonus);
            if (totalBonus > maxBonus) {
                maxBonus = totalBonus;
                totalAttendances = attendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.\n" +
                "The student has attended %d lectures.\n", Math.ceil(maxBonus), totalAttendances);
    }
}