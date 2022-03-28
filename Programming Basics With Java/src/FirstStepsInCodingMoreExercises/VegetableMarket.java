import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double kgVegetablesInLev = Double.parseDouble(scanner.nextLine());
        double kgFruitsInLev = Double.parseDouble(scanner.nextLine());
        int totalVegetablesKilograms = Integer.parseInt(scanner.nextLine());
        int totalFruitsKilograms = Integer.parseInt(scanner.nextLine());
        double totalBgn = kgVegetablesInLev * totalVegetablesKilograms + kgFruitsInLev * totalFruitsKilograms;
        double totalEur = totalBgn / 1.94;
        System.out.printf("%.2f", totalEur);

    }
}
