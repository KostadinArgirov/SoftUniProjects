import java.util.Scanner;

public class P05AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double accountBalance = 0.0;

        while (!input.equals("NoMoreMoney")) {

            double currentNum = Double.parseDouble(input);

            if (currentNum < 0) {

                System.out.println("Invalid operation!");

                break;
            }
            System.out.printf("Increase: %.2f%n", currentNum);

            accountBalance += currentNum;

            input = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", accountBalance);
    }
}