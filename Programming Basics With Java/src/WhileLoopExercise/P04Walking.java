import java.util.Scanner;

public class P04Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String steps = scanner.nextLine();
//        int stepsSum = 0;
//        int currentSteps = 0;
//
//
//        while (stepsSum < 10000) {
//            if (!steps.equals("Going home")) {
//                currentSteps = Integer.parseInt(steps);
//                stepsSum += currentSteps;
//
//                if (stepsSum >= 10000) {
//                    System.out.printf("Goal reached! Good job!%n%d steps over the goal!", stepsSum - 10000);
//                    break;
//                }
//                steps = scanner.nextLine();
//            } else {
//                steps = scanner.nextLine();
//                currentSteps = Integer.parseInt(steps);
//                stepsSum += currentSteps;
//
//                if (stepsSum < 10000) {
//                    System.out.printf("%d more steps to reach goal.", 10000 - stepsSum);
//                } else {
//                    System.out.printf("Goal reached! Good job!%n%d steps over the goal!", stepsSum - 10000);
//                }
//                break;
//            }
//        }

        int goal = 10000;
        int steps = 0;

        while (goal > steps) {
            String input = scanner.nextLine();

            if (input.equals("Going home")) {
                steps += Integer.parseInt(scanner.nextLine());
                break;
            }
            steps += Integer.parseInt(input);
        }
        if (steps >= goal) {
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", steps - goal);
        } else {
            System.out.printf("%d more steps to reach goal.", goal - steps);
        }
    }
}