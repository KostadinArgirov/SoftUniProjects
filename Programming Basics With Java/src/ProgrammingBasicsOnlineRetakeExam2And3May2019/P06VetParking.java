import java.util.Scanner;

public class P06VetParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysNumber = Integer.parseInt(scanner.nextLine());
        int hoursPerDay = Integer.parseInt(scanner.nextLine());

        double totalPrice = 0.0;

        for (int i = 1; i <= daysNumber; i++) {
            boolean isDayEven = false;
            double parkingPrice = 0.0;

            if (i % 2 == 0) {
                isDayEven = true;
            }

            for (int j = 1; j <= hoursPerDay; j++) {
                if (isDayEven && j % 2 != 0) {
                    parkingPrice += 2.5;
                } else if (!isDayEven && j % 2 == 0) {
                    parkingPrice += 1.25;
                } else {
                    parkingPrice += 1;
                }
            }
            totalPrice += parkingPrice;
            System.out.printf("Day: %d - %.2f leva\n", i, parkingPrice);
        }
        System.out.printf("Total: %.2f leva", totalPrice);
    }
}