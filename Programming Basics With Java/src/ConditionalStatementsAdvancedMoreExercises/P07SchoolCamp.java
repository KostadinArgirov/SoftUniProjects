import java.util.Scanner;

public class P07SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String groupType = scanner.nextLine();
        int studentsNumber = Integer.parseInt(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        String sport = "";
        double price = 0.0;
        String output = "";

        switch (season) {
            case "Winter":
                if (groupType.equals("boys")) {
                    price = studentsNumber * 9.6 * nights;
                    sport = "Judo";
                    output = String.format("%s %.2f lv.", sport, price);
                } else if (groupType.equals("girls")) {
                    price = studentsNumber * 9.6 * nights;
                    sport = "Gymnastics";
                    output = String.format("%s %.2f lv.", sport, price);
                } else if (groupType.equals("mixed")) {
                    price = studentsNumber * 10 * nights;
                    sport = "Ski";
                    output = String.format("%s %.2f lv.", sport, price);
                }
                break;
            case "Spring":
                if (groupType.equals("boys")) {
                    price = studentsNumber * 7.2 * nights;
                    sport = "Tennis";
                    output = String.format("%s %.2f lv.", sport, price);
                } else if (groupType.equals("girls")) {
                    price = studentsNumber * 7.2 * nights;
                    sport = "Athletics";
                    output = String.format("%s %.2f lv.", sport, price);
                } else if (groupType.equals("mixed")) {
                    price = studentsNumber * 9.5 * nights;
                    sport = "Cycling";
                    output = String.format("%s %.2f lv.", sport, price);
                }
                break;
            case "Summer":
                if (groupType.equals("boys")) {
                    price = studentsNumber * 15 * nights;
                    sport = "Football";
                    output = String.format("%s %.2f lv.", sport, price);
                } else if (groupType.equals("girls")) {
                    price = studentsNumber * 15 * nights;
                    sport = "Volleyball";
                    output = String.format("%s %.2f lv.", sport, price);
                } else if (groupType.equals("mixed")) {
                    price = studentsNumber * 20 * nights;
                    sport = "Swimming";
                    output = String.format("%s %.2f lv.", sport, price);
                    break;
                }
        }
        if (studentsNumber >= 10 && studentsNumber < 20) {
            price *= 0.95;
            output = String.format("%s %.2f lv.", sport, price);
        } else if (studentsNumber >= 20 && studentsNumber < 50) {
            price *= 0.85;
            output = String.format("%s %.2f lv.", sport, price);
        } else if (studentsNumber >= 50) {
            price *= 0.5;
            output = String.format("%s %.2f lv.", sport, price);
        }
        System.out.println(output);
    }
}
