import java.util.Scanner;

public class P02BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniorsNumber = Integer.parseInt(scanner.nextLine());
        int seniorsNumber = Integer.parseInt(scanner.nextLine());
        String trackType = scanner.nextLine();
        double amountCollected = 0.0;
        String output = "";

        switch (trackType) {
            case "trail":
                amountCollected = (juniorsNumber * 5.5 + seniorsNumber * 7) * 0.95;
                output = String.format("%.2f", amountCollected);
                break;
            case "cross-country":
                amountCollected = (juniorsNumber * 8 + seniorsNumber * 9.5) * 0.95;
                if (juniorsNumber + seniorsNumber >= 50) {
                    amountCollected = amountCollected *  0.75;
                }
                output = String.format("%.2f", amountCollected);
                break;
            case "downhill":
                amountCollected = (juniorsNumber * 12.25 + seniorsNumber * 13.75) * 0.95;
                output = String.format("%.2f", amountCollected);
                break;
            case "road":
                amountCollected = (juniorsNumber * 20 + seniorsNumber * 21.5) * 0.95;
                output = String.format("%.2f", amountCollected);
                break;
        }
        System.out.println(output);
    }
}
