import java.util.Scanner;

public class P05Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moneySave = 0.0;
        String destination = "";

        while (!"End".equals(destination = scanner.nextLine())) {
            double minBudget = Double.parseDouble(scanner.nextLine());

            while (moneySave < minBudget) {
                double money = Double.parseDouble(scanner.nextLine());
                moneySave += money;
            }
            System.out.printf("Going to %s!\n", destination);
            moneySave = 0;
        }
    }
}