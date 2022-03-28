import java.util.Scanner;

public class P03EasterTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String destination = scanner.nextLine();
        String dates = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double totalSum = 0.0;

        switch (destination) {
            case "France":
                if (dates.equals("21-23")) {
                    totalSum = nights * 30;
                } else if (dates.equals("24-27")) {
                    totalSum = nights * 35;
                } else if (dates.equals("28-31")) {
                    totalSum = nights * 40;
                }
                break;
            case "Italy":
                if (dates.equals("21-23")) {
                    totalSum = nights * 28;
                } else if (dates.equals("24-27")) {
                    totalSum = nights * 32;
                } else if (dates.equals("28-31")) {
                    totalSum = nights * 39;
                }
                break;
            case "Germany":
                if (dates.equals("21-23")) {
                    totalSum = nights * 32;
                } else if (dates.equals("24-27")) {
                    totalSum = nights * 37;
                } else if (dates.equals("28-31")) {
                    totalSum = nights * 43;
                }
                break;
        }
        System.out.printf("Easter trip to %s : %.2f leva.", destination, totalSum);
    }
}