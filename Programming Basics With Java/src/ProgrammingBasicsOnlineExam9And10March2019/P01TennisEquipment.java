import java.util.Scanner;

public class P01TennisEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rocketPrice = Double.parseDouble(scanner.nextLine());
        int rocketsNumber = Integer.parseInt(scanner.nextLine());
        int sneakersNumber = Integer.parseInt(scanner.nextLine());

        double allRockets = rocketPrice * rocketsNumber;
        double sneakersPrice = rocketPrice / 6;
        double allSneakers = sneakersPrice * sneakersNumber;
        double equipmentPrice = (allRockets + allSneakers) * 0.2;
        double totalSum = allRockets + allSneakers + equipmentPrice;
        double djokovicPrice = totalSum / 8;
        double sponsorsPrice = totalSum - djokovicPrice;

        System.out.printf("Price to be paid by Djokovic %.0f\n", Math.floor(djokovicPrice));
        System.out.printf("Price to be paid by sponsors %.0f", Math.ceil(sponsorsPrice));
    }
}