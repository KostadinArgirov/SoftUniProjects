import java.util.Scanner;

public class P03PaintingEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        String colour = scanner.nextLine();
        int lots = Integer.parseInt(scanner.nextLine());

        double price = 0.0;

        switch (size) {
            case "Large":
                if (colour.equals("Red")) {
                    price = lots * 16;
                } else if (colour.equals("Green")) {
                    price = lots * 12;
                } else if (colour.equals("Yellow")) {
                    price = lots * 9;
                }
                break;
            case "Medium":
                if (colour.equals("Red")) {
                    price = lots * 13;
                } else if (colour.equals("Green")) {
                    price = lots * 9;
                } else if (colour.equals("Yellow")) {
                    price = lots * 7;
                }
                break;
            case "Small":
                if (colour.equals("Red")) {
                    price = lots * 9;
                } else if (colour.equals("Green")) {
                    price = lots * 8;
                } else if (colour.equals("Yellow")) {
                    price = lots * 5;
                }
                break;
        }
        double totalPrice = price * 0.65;

        System.out.printf("%.2f leva.", totalPrice);
    }
}