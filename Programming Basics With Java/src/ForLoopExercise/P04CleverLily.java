import java.util.Scanner;

public class P04CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int age = Integer.parseInt(scanner.nextLine());
        double washMachinePrice = Double.parseDouble(scanner.nextLine());
        int toyPrice = Integer.parseInt(scanner.nextLine());
        int moneyCollected = 0;
        int moneySum = 0;
        int toysCollected = 0;
        int brotherCount = 0;

        for (int i = 1; i <= age; i++) {
            if (i % 2 != 0) {
                toysCollected ++;
            } else {
                brotherCount ++;
                moneyCollected += 10;
                moneySum += moneyCollected;
            }
        }
        double allSavedMoney = (toysCollected * toyPrice) + (moneySum - brotherCount);

        if (allSavedMoney >= washMachinePrice) {
            System.out.printf("Yes! %.2f", allSavedMoney - washMachinePrice);
        } else {
            System.out.printf("No! %.2f", washMachinePrice - allSavedMoney);
        }
    }
}
