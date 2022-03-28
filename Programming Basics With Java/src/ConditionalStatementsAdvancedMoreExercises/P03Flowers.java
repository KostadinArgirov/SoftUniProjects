import java.util.Scanner;

public class P03Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemumsNumber = Integer.parseInt(scanner.nextLine());
        int rosesNumber = Integer.parseInt(scanner.nextLine());
        int tulipsNumber = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String yesNo = scanner.nextLine();
        double price = 0.0;
        String output = "";

        switch (season) {
            case "Spring":
            case "Summer":
                price = chrysanthemumsNumber * 2.00 + rosesNumber * 4.10 + tulipsNumber * 2.50;
                if (season.equals("Spring")) {
                    if (tulipsNumber > 7) {
                        price *= 0.95;
                    }
                }
                output = String.format("%.2f", price);
                break;
            case "Autumn":
            case "Winter":
                price = chrysanthemumsNumber * 3.75 + rosesNumber * 4.50 + tulipsNumber * 4.15;
                if (season.equals("Winter")) {
                    if (tulipsNumber >= 10) {
                        price *= 0.90;
                    }
                }
                output = String.format("%.2f", price);
                break;
        }
        if (chrysanthemumsNumber + rosesNumber + tulipsNumber > 20) {
            price *= 0.8;
            output = String.format("%.2f", price);
        }
        if (yesNo.equals("Y")) {
            price *= 1.15;
            output = String.format("%.2f", price);
        }
        price = price + 2;
        output = String.format("%.2f", price);
        System.out.println(output);
    }
}
