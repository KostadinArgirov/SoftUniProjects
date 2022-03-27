package midExam;

import java.util.Scanner;

public class P01CookingMasterclass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double packFlourPrice = Double.parseDouble(scanner.nextLine());
        double singleEggPrice = Double.parseDouble(scanner.nextLine());
        double singleApronPrice = Double.parseDouble(scanner.nextLine());

        int freePackeges = 0;

        for (int i = 1; i <= students; i++) {
            if (i % 5 == 0) {
                freePackeges++;
            }
        }
        double totalSum = singleApronPrice * Math.ceil(students * 1.2) + singleEggPrice * 10 * students + packFlourPrice * (students - freePackeges);

        if (totalSum <= budget) {
            System.out.printf("Items purchased for %.2f$.", totalSum);
        } else {
            System.out.printf("%.2f$ more needed.", totalSum - budget);
        }
    }
}