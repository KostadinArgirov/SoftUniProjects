import java.util.Scanner;

public class P02ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int failedThreshold = Integer.parseInt(scanner.nextLine());
//
//        int failedTimes = 0;
//        int solvedProblemsCount = 0;
//        double gradesSum = 0.0;
//        String lastProblem = "";
//        boolean isFailed = true;
//
//        while (failedTimes < failedThreshold) {
//            String problemName = scanner.nextLine();
//            if ("Enough".equals(problemName)) {
//                isFailed = false;
//                break;
//            }
//            int grade = Integer.parseInt(scanner.nextLine());
//            if (grade <= 4) {
//                failedTimes++;
//            }
//            gradesSum += grade;
//            solvedProblemsCount++;
//            lastProblem = problemName;
//        }
//        if (isFailed) {
//            System.out.printf("You need a break, %d poor grades.", failedThreshold);
//        } else {
//            System.out.printf("Average score: %.2f\n", gradesSum / solvedProblemsCount);
//            System.out.printf("Number of problems: %d\n", solvedProblemsCount);
//            System.out.printf("Last problem: %s", lastProblem);
//        }

        int poorGradesLimits =  Integer.parseInt(scanner.nextLine());

        boolean isFailed = false;
        double gradesSum = 0;

        String problem = scanner.nextLine();
        int poorGradesCount = 0;

        int gradesCount = 0;
        String lastProblem = "";

        while (!problem.equals("Enough")) {
            int grade = Integer.parseInt(scanner.nextLine());
            gradesSum += grade;
            gradesCount++;
            lastProblem = problem;
            if (grade <= 4) {
                poorGradesCount++;
                if (poorGradesCount == poorGradesLimits) {
                    isFailed = true;
                    break;
                }
            }
            problem = scanner.nextLine();
        }
        if (isFailed) {
            System.out.printf("You need a break, %d poor grades.", poorGradesCount);
        } else {
            System.out.printf("Average score: %.2f\n", gradesSum / gradesCount);
            System.out.printf("Number of problems: %d\n", gradesCount);
            System.out.printf("Last problem: %s", lastProblem);
        }
    }
}