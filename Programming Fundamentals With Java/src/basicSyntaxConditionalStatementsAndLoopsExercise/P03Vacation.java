package basicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleNumber = Integer.parseInt(scanner.nextLine());
        String groupType = scanner.nextLine();
        String day = scanner.nextLine();

        double groupPrice = 0.0;

        switch (groupType) {
            case "Students":
                if (day.equals("Friday")) {
                    groupPrice = peopleNumber * 8.45;
                } else if (day.equals("Saturday")) {
                    groupPrice = peopleNumber * 9.80;
                } else if (day.equals("Sunday")) {
                    groupPrice = peopleNumber * 10.46;
                }
                if (peopleNumber >= 30) {
                    groupPrice *= 0.85;
                }
                break;
            case "Business":
                if (peopleNumber >= 100) {
                    peopleNumber -= 10;
                }
                    if (day.equals("Friday")) {
                        groupPrice = peopleNumber * 10.90;
                    } else if (day.equals("Saturday")) {
                        groupPrice = peopleNumber * 15.60;
                    } else if (day.equals("Sunday")) {
                        groupPrice = peopleNumber * 16;
                    }
                break;
            case "Regular":
                if (day.equals("Friday")) {
                    groupPrice = peopleNumber * 15;
                } else if (day.equals("Saturday")) {
                    groupPrice = peopleNumber * 20;
                } else if (day.equals("Sunday")) {
                    groupPrice = peopleNumber * 22.50;
                }
                if (10 <= peopleNumber && peopleNumber <= 20) {
                    groupPrice *= 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f", groupPrice);
    }
}