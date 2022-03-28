import java.util.Scanner;

public class P06TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kmPerMonth = Double.parseDouble(scanner.nextLine());
        double income = 0.0;
        String output = "";

        switch (season) {
            case "Spring":
            case "Autumn":
                if (kmPerMonth <= 5000) {
                    income = kmPerMonth * 0.75 * 0.9;
                    output = String.format("%.2f", income * 4);
                } else if (kmPerMonth <= 10000) {
                    income = kmPerMonth * 0.95 * 0.9;
                    output = String.format("%.2f", income * 4);
                } else if (kmPerMonth <= 20000) {
                    income = kmPerMonth * 1.45 * 0.9;
                    output = String.format("%.2f", income * 4);
                }
                break;
            case "Summer":
                if (kmPerMonth <= 5000) {
                    income = kmPerMonth * 0.9 * 0.9;
                    output = String.format("%.2f", income * 4);
                } else if (kmPerMonth <= 10000) {
                    income = kmPerMonth * 1.1 * 0.9;
                    output = String.format("%.2f", income * 4);
                } else if (kmPerMonth <= 20000) {
                    income = kmPerMonth * 1.45 * 0.9;
                    output = String.format("%.2f", income * 4);
                }
                break;
            case "Winter":
                if (kmPerMonth <= 5000) {
                    income = kmPerMonth * 1.05 * 0.9;
                    output = String.format("%.2f", income * 4);
                } else if (kmPerMonth <= 10000) {
                    income = kmPerMonth * 1.25 * 0.9;
                    output = String.format("%.2f", income * 4);
                } else if (kmPerMonth <= 20000) {
                    income = kmPerMonth * 1.45 * 0.9;
                    output = String.format("%.2f", income * 4);
                }
                break;
        }
        System.out.println(output);
    }
}
