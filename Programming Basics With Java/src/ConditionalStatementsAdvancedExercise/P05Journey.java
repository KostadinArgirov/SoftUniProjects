import java.util.Scanner;

public class P05Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String accommodation = "";
        double moneySpent = 0;
        String destination = "";

        if (budget <= 100) {
            if ("summer".equals(season)) {
                accommodation = "Camp";
                moneySpent = budget * 0.3;
                destination = "Bulgaria";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accommodation, moneySpent);
            } else if ("winter".equals(season)) {
                accommodation = "Hotel";
                moneySpent = budget * 0.7;
                destination = "Bulgaria";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accommodation, moneySpent);
            }
        } else if (budget <= 1000) {
            if ("summer".equals(season)) {
                accommodation = "Camp";
                moneySpent = budget * 0.4;
                destination = "Balkans";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accommodation, moneySpent);
            } else if ("winter".equals(season)) {
                accommodation = "Hotel";
                moneySpent = budget * 0.8;
                destination = "Balkans";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accommodation, moneySpent);
            }
        } else if (budget > 1000) {
            if ("summer".equals(season) || "winter".equals(season)) {
                accommodation = "Hotel";
                moneySpent = budget * 0.9;
                destination = "Europe";
                System.out.printf("Somewhere in %s\n", destination);
                System.out.printf("%s - %.2f", accommodation, moneySpent);
            }
        }

    }
}
