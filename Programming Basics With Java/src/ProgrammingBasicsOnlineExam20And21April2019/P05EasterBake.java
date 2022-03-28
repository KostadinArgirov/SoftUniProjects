import java.util.Scanner;

public class P05EasterBake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreads = Integer.parseInt(scanner.nextLine());

        int totalSugarUsed = 0;
        int totalFlourUsed = 0;
        int maxUsedSugar = Integer.MIN_VALUE;
        int maxUsedFlour = Integer.MIN_VALUE;

        for (int i = 0; i < easterBreads; i++) {
            int sugarUsed = Integer.parseInt(scanner.nextLine());
            int flourUsed = Integer.parseInt(scanner.nextLine());

            totalSugarUsed += sugarUsed;
            totalFlourUsed += flourUsed;

            if (sugarUsed > maxUsedSugar) {
                maxUsedSugar = sugarUsed;
            }
            if (flourUsed > maxUsedFlour) {
                maxUsedFlour = flourUsed;
            }
        }
        double sugarPacks = Math.ceil(totalSugarUsed / 950.0);
        double flourPacks = Math.ceil(totalFlourUsed / 750.0);

        System.out.printf("Sugar: %.0f\n" +
                "Flour: %.0f\n" +
                "Max used flour is %d grams, max used sugar is %d grams.", sugarPacks, flourPacks, maxUsedFlour, maxUsedSugar);
    }
}