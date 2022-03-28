import java.util.Scanner;

public class P04Club {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double expectMoney = Double.parseDouble(scanner.nextLine());

        String name = scanner.nextLine();

        double totalPrice = 0.00;
        double money = 0.00;

        while (!name.equals("Party!")) {

            int number = Integer.parseInt(scanner.nextLine());
            int price = name.length();
            totalPrice = price * number;
            if (totalPrice % 2 != 0) {
                totalPrice = totalPrice - (totalPrice * 0.25);
            }
            money += totalPrice;
            if (money >= expectMoney) {
                System.out.println("Target acquired.");
                break;
            }
            name = scanner.nextLine();
        }
        if (name.equals("Party!")) {
            double diff = expectMoney - money;
            System.out.printf("We need %.2f leva more.\n", diff);
        }
        System.out.printf("Club income - %.2f leva.", money);
    }
}