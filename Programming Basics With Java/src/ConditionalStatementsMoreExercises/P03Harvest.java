import java.util.Scanner;

public class P03Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int xWineYardArea = Integer.parseInt(scanner.nextLine());
            double yGrapesPerSqM = Double.parseDouble(scanner.nextLine());
            int zWineLitersNeeded = Integer.parseInt(scanner.nextLine());
            int numberWorkers = Integer.parseInt(scanner.nextLine());

            double totalGrapes = (xWineYardArea * 0.4) * yGrapesPerSqM;
            double wine = totalGrapes / 2.5;
            double wineLeft = Math.abs(wine - zWineLitersNeeded);
            double wineLitersPerWorker = wineLeft / numberWorkers;

            if (wine >= zWineLitersNeeded) {
                System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", Math.floor(wine));
                System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(wineLeft), Math.ceil(wineLitersPerWorker));

            } else {
                double vineNeeded = Math.floor(zWineLitersNeeded - wine);
                System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(vineNeeded));

            }


    }
}
