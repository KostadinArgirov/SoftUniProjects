package midExamPrepLife;

import java.util.Scanner;

public class P01SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = scanner.nextInt();
        int secondEmployee = scanner.nextInt();
        int thirdEmployee = scanner.nextInt();

        int studentsPerHour = firstEmployee + secondEmployee + thirdEmployee;

        int remainingStudents = scanner.nextInt();

        int hoursPassed = 0;

        while (remainingStudents > 0) {
            hoursPassed++;
            if (hoursPassed % 4 != 0) {
                remainingStudents -= studentsPerHour;
            }
            if (remainingStudents < 1) {
                break;
            }
        }
        System.out.printf("Time needed: %dh.", hoursPassed);
    }
}