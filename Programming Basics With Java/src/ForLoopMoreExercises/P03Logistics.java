import java.util.Scanner;

public class P03Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cargoNumber = Integer.parseInt(scanner.nextLine());
        int allCargoWeightVan = 0;
        int allCargoWeightTruck = 0;
        int allCargoWeightTrain = 0;
        int van = 0;
        int truck = 0;
        int train = 0;

        for (int i = 1; i <= cargoNumber; i++) {
            int cargoWeight = Integer.parseInt(scanner.nextLine());

            if (cargoWeight <= 3) {
                allCargoWeightVan += cargoWeight;
                van++;
            } else if (cargoWeight < 12) {
                allCargoWeightTruck += cargoWeight;
                truck++;
            } else {
                allCargoWeightTrain += cargoWeight;
                train++;
            }
        }
        double allCargoWeight = allCargoWeightVan + allCargoWeightTruck + allCargoWeightTrain;
        double averagePricePerTon = (allCargoWeightVan * 200.0 + allCargoWeightTruck * 175 + allCargoWeightTrain * 120) / allCargoWeight;

        System.out.printf("%.2f\n", averagePricePerTon);
        System.out.printf("%.2f%%\n", ((allCargoWeightVan * 1.0) / allCargoWeight) * 100);
        System.out.printf("%.2f%%\n", ((allCargoWeightTruck * 1.0) / allCargoWeight) * 100);
        System.out.printf("%.2f%%", ((allCargoWeightTrain * 1.0) / allCargoWeight) * 100);
    }
}
