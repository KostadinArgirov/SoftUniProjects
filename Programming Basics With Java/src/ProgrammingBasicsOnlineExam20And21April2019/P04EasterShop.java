import java.util.Scanner;

public class P04EasterShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();

        int eggsSold = 0;

        while (!command.equals("Close")) {
            int currentOrder = Integer.parseInt(scanner.nextLine());

            if (command.equals("Buy") && currentOrder > startNumber) {
                System.out.printf("Not enough eggs in store!\nYou can buy only %d.", startNumber);
                return;
            }
            switch (command) {
                case "Buy":
                    eggsSold += currentOrder;
                    startNumber -= currentOrder;
                    break;
                case "Fill":
                    startNumber += currentOrder;
                    break;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Store is closed!\n%d eggs sold.", eggsSold);
    }
}