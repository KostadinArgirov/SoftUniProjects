package arraysExercise;

import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        String[] firstArr = new String[lines];
        String[] secondArr = new String[lines];

        for (int i = 1; i <= lines; i++) {
            String[] line = scanner.nextLine().split(" ");
            if (i % 2 != 0) {
                firstArr[i - 1] = line[0];
                secondArr[i - 1] = line[1];
            } else {
                firstArr [i - 1] = line[1];
                secondArr [i - 1] = line[0];
            }
        }
        for (String s : firstArr) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : secondArr) {
            System.out.print(s + " ");
        }
    }
}