import java.util.Scanner;

public class P03AluminumJoinery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int joineryNumber = Integer.parseInt(scanner.nextLine());
        String joineryType = scanner.nextLine();
        String deliveryOrNot = scanner.nextLine();
        double price = 0.0;

        if (joineryNumber < 10) {
            System.out.println("Invalid order");
            return;
        }

        switch (joineryType) {
            case "90X130":
                price = 110 * joineryNumber;
                if (joineryNumber > 30 && joineryNumber <= 60) {
                    price *= 0.95;
                } else if (joineryNumber > 60) {
                    price *= 0.92;
                }
                    break;
            case "100X150":
                price = 140 * joineryNumber;
                if (joineryNumber > 40 && joineryNumber <= 80) {
                    price *= 0.94;
                } else if (joineryNumber > 80) {
                    price *= 0.90;
                }
                break;
            case "130X180":
                price = 190 * joineryNumber;
                if (joineryNumber > 20 && joineryNumber <= 50) {
                    price *= 0.93;
                } else if (joineryNumber > 50) {
                    price *= 0.88;
                }
                break;
            case "200X300":
                price = 250 * joineryNumber;
                if (joineryNumber > 25 && joineryNumber <= 50) {
                    price *= 0.91;
                } else if (joineryNumber > 50) {
                    price *= 0.86;
                }
                break;

        }
        if (deliveryOrNot.equals("With delivery")) {
            price += 60;
        }
        if (joineryNumber > 99) {
            price *= 0.96;
        }
        System.out.printf("%.2f BGN", price);
    }
}