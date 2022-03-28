import java.util.Scanner;

public class Fishland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mackerelPrice = Double.parseDouble(scanner.nextLine());
        double spratPrice = Double.parseDouble(scanner.nextLine());
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        double scadKg = Double.parseDouble(scanner.nextLine());
        int musselsKg = Integer.parseInt(scanner.nextLine());
        double bonitoPrice = mackerelPrice + mackerelPrice * 0.60;
        double bonitoTotal = bonitoKg * bonitoPrice;
        double scadPrice = spratPrice + spratPrice * 0.80;
        double scadTotal = scadKg * scadPrice;
        double musselsTotal = musselsKg * 7.5;
        double total = bonitoTotal + scadTotal + musselsTotal;
        System.out.printf("%.2f", total);

    }
}
