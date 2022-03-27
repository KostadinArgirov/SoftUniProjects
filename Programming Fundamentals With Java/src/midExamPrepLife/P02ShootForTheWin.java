package midExamPrepLife;

import java.util.Arrays;
import java.util.Scanner;

public class P02ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int totalShot = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            int targetIndex = Integer.parseInt(input);

            if (targetIndex >= 0 && targetIndex < targets.length) {
                int shotTarget = targets[targetIndex];
                if (shotTarget != -1) {
                    totalShot++;
                    targets[targetIndex] = -1;
                    registerTargetHits(targets, shotTarget);
                }

            }

            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", totalShot);
        printArray(targets, " ");
    }

    private static void registerTargetHits(int[] targets, int shotTarget) {
        for (int i = 0; i < targets.length; i++) {
            if (targets[i] == -1) {
                continue;
            }
            if (targets[i] > shotTarget) {
                targets[i] -= shotTarget;
            } else {
                targets[i] += shotTarget;
            }
        }
    }

    public static void printArray(int[] array, String separator) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(separator);
            }
        }
        System.out.println();
    }
}