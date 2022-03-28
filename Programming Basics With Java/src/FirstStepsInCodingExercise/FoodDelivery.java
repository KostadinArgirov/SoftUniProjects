import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chickenMenu = Integer.parseInt(scanner.nextLine());
        int fishMenu = Integer.parseInt(scanner.nextLine());
        int vegetarianMenu = Integer.parseInt(scanner.nextLine());
        double totalMenuPrice = chickenMenu * 10.35 + fishMenu * 12.4 + vegetarianMenu * 8.15;
        double dessertPrice = totalMenuPrice * 0.2;
        double orderPrice = totalMenuPrice + dessertPrice + 2.5;
        System.out.println(orderPrice);


    }
}
