import java.util.Scanner;

public class P02ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int expectedSum = Integer.parseInt(scanner.nextLine());

        int moneyCollectedCc = 0;
        int moneyCollectedCs = 0;
        int counter = 0;
        int successfulCc = 0;
        int successfulCs = 0;

        while ((moneyCollectedCc + moneyCollectedCs) < expectedSum) {
            String text = scanner.nextLine();
            if (text.equals("End")) {
                break;
            }
            int currentPrice = Integer.parseInt(text);
            counter++;

            if (counter % 2 == 0) {
                if (currentPrice < 10) {
                    System.out.println("Error in transaction!");
                    continue;
                } else {
                    System.out.println("Product sold!");
                    successfulCc++;
                    moneyCollectedCc += currentPrice;
                }
            } else {
                if (currentPrice > 100) {
                    System.out.println("Error in transaction!");
                    continue;
                } else {
                    System.out.println("Product sold!");
                    successfulCs++;
                    moneyCollectedCs += currentPrice;
                }
            }
        }
        if ((moneyCollectedCc + moneyCollectedCs) >= expectedSum) {
            System.out.printf("Average CS: %.2f\n", (moneyCollectedCs * 1.0) / successfulCs);
            System.out.printf("Average CC: %.2f", (moneyCollectedCc * 1.0) / successfulCc);
        } else {
            System.out.println("Failed to collect required money for charity.");
        }
    }
}