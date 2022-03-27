package basicSyntaxConditionalStatementsAndLoopsLab;

import java.util.Scanner;

public class P07TheatrePromotion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine().toLowerCase();
        int age = Integer.parseInt(scanner.nextLine());
        double price = 0.0;

        if (0 > age || age > 122) {
            System.out.println("Error!");
            return;
        }

        if (day.equals("weekday")) {
            if ((0 <= age && age <= 18) || (64 < age && age <= 122)) {
                price = 12;
            } else if (18 < age && age <= 64) {
                price = 18;
            }
        } else if (day.equals("weekend")) {
            if ((0 <= age && age <= 18) || (64 < age && age <= 122)) {
                price = 15;
            } else if (18 < age && age <= 64) {
                price = 20;
            }
        } else if (day.equals("holiday")) {
            if (0 <= age && age <= 18) {
                price = 5;
            } else if (18 < age && age <= 64) {
                price = 12;
            } else if (64 < age && age <= 122) {
                price = 10;
            }
        }
        System.out.printf("%.0f$", price);
    }
}