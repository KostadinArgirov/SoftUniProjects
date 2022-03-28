import java.util.Scanner;

public class P01EasterBakery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double flourPriceKg = Double.parseDouble(scanner.nextLine());
        double flourKilograms = Double.parseDouble(scanner.nextLine());
        double sugarKilograms = Double.parseDouble(scanner.nextLine());
        int eggShellsNumber = Integer.parseInt(scanner.nextLine());
        int yeastNumber = Integer.parseInt(scanner.nextLine());

        double sugarPriceKg = flourPriceKg * 0.75;
        double eggShellPrice = flourPriceKg * 1.1;
        double yeastPrice = sugarPriceKg * 0.2;

        double flourPrice = flourPriceKg * flourKilograms;
        double sugarPrice = sugarPriceKg * sugarKilograms;
        double eggsPrice = eggShellPrice * eggShellsNumber;
        double totalYeastPrice = yeastPrice * yeastNumber;

        double totalPrice = flourPrice + sugarPrice + eggsPrice + totalYeastPrice;

        System.out.printf("%.2f", totalPrice);
    }
}