import java.util.Scanner;

public class P01FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberries = Double.parseDouble(scanner.nextLine());
        double bananasAmount = Double.parseDouble(scanner.nextLine());
        double orangesAmount = Double.parseDouble(scanner.nextLine());
        double raspberriesAmount = Double.parseDouble(scanner.nextLine());
        double strawberriesAmount = Double.parseDouble(scanner.nextLine());

        double raspberries = strawberries / 2;
        double oranges = raspberries * 0.6;
        double bananas = raspberries * 0.2;

        double totalSum = strawberries * strawberriesAmount + bananas * bananasAmount +
                oranges * orangesAmount + raspberries * raspberriesAmount;

        System.out.printf("%.2f", totalSum);
    }
}