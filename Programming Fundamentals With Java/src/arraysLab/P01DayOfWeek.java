package arraysLab;

import java.util.Scanner;

public class P01DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        String days[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (input > 0 && input < 8) {
            System.out.println(days[input - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}