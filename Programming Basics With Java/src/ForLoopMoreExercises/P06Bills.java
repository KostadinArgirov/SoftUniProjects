import java.util.Scanner;

public class P06Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());

        double electricitySum = 0.0;
        int waterSum = 0;
        int internetSum = 0;
        double otherSum = 0.0;

        for (int i = 0; i < months; i++) {
            double electricityBill = Double.parseDouble(scanner.nextLine());

            electricitySum += electricityBill;
            waterSum += 20;
            internetSum += 15;
            otherSum += ((electricityBill + 20 + 15) * 1.2);
        }
        System.out.printf("Electricity: %.2f lv\n", electricitySum);
        System.out.printf("Water: %.2f lv\n", waterSum * 1.0);
        System.out.printf("Internet: %.2f lv\n", internetSum * 1.0);
        System.out.printf("Other: %.2f lv\n", otherSum);
        System.out.printf("Average: %.2f lv", (electricitySum + waterSum + internetSum + otherSum) / months);
    }
}
