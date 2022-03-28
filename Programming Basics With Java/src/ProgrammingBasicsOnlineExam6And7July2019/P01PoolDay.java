import java.util.Scanner;

public class P01PoolDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleNumber = Integer.parseInt(scanner.nextLine());
        double entrancePrice = Double.parseDouble(scanner.nextLine());
        double sunbedPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());
        double totalEntrancePrice = peopleNumber * entrancePrice;
        double allUmbrellaPrice = (Math.ceil(peopleNumber * 0.5)) * umbrellaPrice;
        double allSunbedPrice = (Math.ceil(peopleNumber * 0.75)) * sunbedPrice;

        System.out.printf("%.2f lv.", totalEntrancePrice + allSunbedPrice + allUmbrellaPrice);
    }
}