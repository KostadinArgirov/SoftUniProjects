import java.util.Scanner;

public class P05SmallShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;

        switch (product) {
            case "coffee":
                if (town.equals("Sofia")) {
                    price = quantity * 0.50;
                    System.out.println(price);
                } else if (town.equals("Plovdiv")) {
                    price = quantity * 0.40;
                    System.out.println(price);
                } else if (town.equals("Varna")) {
                    price = quantity * 0.45;
                    System.out.println(price);
                }
                break;
            case "water":
                if (town.equals("Sofia")) {
                    price = quantity * 0.80;
                    System.out.println(price);
                } else if (town.equals("Plovdiv") || town.equals("Varna")) {
                    price = quantity * 0.70;
                    System.out.println(price);
                }
                break;
            case "beer":
                if (town.equals("Sofia")) {
                    price = quantity * 1.20;
                    System.out.println(price);
                } else if (town.equals("Plovdiv")) {
                    price = quantity * 1.15;
                    System.out.println(price);
                } else if (town.equals("Varna")) {
                    price = quantity * 1.10;
                    System.out.println(price);
                }
                break;
            case "sweets":
                if (town.equals("Sofia")) {
                    price = quantity * 1.45;
                    System.out.println(price);
                } else if (town.equals("Plovdiv")) {
                    price = quantity * 1.30;
                    System.out.println(price);
                } else if (town.equals("Varna")) {
                    price = quantity * 1.35;
                    System.out.println(price);
                }
                break;
            case "peanuts":
                if (town.equals("Sofia")) {
                    price = quantity * 1.60;
                    System.out.println(price);
                } else if (town.equals("Plovdiv")) {
                    price = quantity * 1.50;
                    System.out.println(price);
                } else if (town.equals("Varna")) {
                    price = quantity * 1.55;
                    System.out.println(price);
                }
                break;
        }

    }
}
