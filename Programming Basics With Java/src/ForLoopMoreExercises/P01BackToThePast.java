import java.util.Scanner;

public class P01BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inheritedMoney = Double.parseDouble(scanner.nextLine());
        int yearToLive = Integer.parseInt(scanner.nextLine());
        int age = 18;
        double moneySpent = 0.0;

        for (int i = 1800; i <= yearToLive; i++) {
            if (i % 2 == 0) {
                moneySpent += 12000;
                age++;
            } else {
                moneySpent = moneySpent + 12000 + (50 * age);
                age++;
            }
        }
        if (moneySpent <= inheritedMoney) {
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", inheritedMoney - moneySpent);
        } else {
            System.out.printf("He will need %.2f dollars to survive.", moneySpent - inheritedMoney);
        }
    }
}
