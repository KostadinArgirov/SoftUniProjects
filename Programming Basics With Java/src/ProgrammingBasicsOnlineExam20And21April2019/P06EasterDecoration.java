import java.util.Scanner;

public class P06EasterDecoration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int customers = Integer.parseInt(scanner.nextLine());

        double averageBill = 0.0;

        for (int i = 0; i < customers; i++) {

            int counter = 0;
            double bill = 0.0;

            String currentBuy = "";

            while (!"Finish".equals(currentBuy = scanner.nextLine())) {
                counter++;

                switch (currentBuy) {
                    case "basket":
                        bill += 1.5;
                        break;
                    case "wreath":
                        bill += 3.8;
                        break;
                    case "chocolate bunny":
                        bill += 7;
                        break;
                }
            }
            if (counter % 2 == 0) {
                bill *= 0.8;
            }
            averageBill += bill;
            System.out.printf("You purchased %d items for %.2f leva.\n", counter, bill);
        }
        System.out.printf("Average bill per client is: %.2f leva.", averageBill / customers);
    }
}