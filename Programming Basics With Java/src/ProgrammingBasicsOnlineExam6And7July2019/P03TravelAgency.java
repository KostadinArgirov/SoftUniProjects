import java.util.Scanner;

public class P03TravelAgency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        String packageType = scanner.nextLine();
        String vip = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double pricePerDay = 0;

        if (days < 1) {
            System.out.println("Days must be positive number!");
            return;
        }

        switch (town) {
            case "Bansko":
            case "Borovets":
                if (packageType.equals("withEquipment")) {
                    pricePerDay = 100;
                    if (vip.equals("yes")) {
                        pricePerDay *= 0.9;
                    }
                } else if (packageType.equals("noEquipment")) {
                    pricePerDay = 80;
                    if (vip.equals("yes")) {
                        pricePerDay *= 0.95;
                    }
                } else {
                    System.out.println("Invalid input!");
                    return;
                }
                break;
            case "Varna":
            case "Burgas":
                if (packageType.equals("withBreakfast")) {
                    pricePerDay = 130;
                    if (vip.equals("yes")) {
                        pricePerDay *= 0.88;
                    }
                } else if (packageType.equals("noBreakfast")) {
                    pricePerDay = 100;
                    if (vip.equals("yes")) {
                        pricePerDay *= 0.93;
                    }
                } else {
                    System.out.println("Invalid input!");
                    return;
                }
                break;
            default:
                System.out.println("Invalid input!");
                return;
        }
        if (days > 7) {
            days -= 1;
        }
        System.out.printf("The price is %.2flv! Have a nice time!", pricePerDay * days);
    }
}