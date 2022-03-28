import java.util.Scanner;

public class P05Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        String accommodation = "";
        String location = "";
        double price = 0.0;
        String output = "";

        if (budget <= 1000) {
            accommodation = "Camp";
        } else if (budget <= 3000) {
            accommodation = "Hut";
        } else {
            accommodation = "Hotel";
        }

        switch (season) {
            case "Summer":
                location = "Alaska";
                if (accommodation.equals("Camp")) {
                    price = budget * 0.65;
                    output = String.format("%s - %s - %.2f",location, accommodation, price);
                } else if (accommodation.equals("Hut")) {
                    price = budget * 0.80;
                    output = String.format("%s - %s - %.2f",location, accommodation, price);
                } else if (accommodation.equals("Hotel")) {
                    price = budget * 0.9;
                    output = String.format("%s - %s - %.2f",location, accommodation, price);
                }
                break;
            case "Winter":
                location = "Morocco";
                if (accommodation.equals("Camp")) {
                    price = budget * 0.45;
                    output = String.format("%s - %s - %.2f",location, accommodation, price);
                } else if (accommodation.equals("Hut")) {
                    price = budget * 0.60;
                    output = String.format("%s - %s - %.2f",location, accommodation, price);
                } else if (accommodation.equals("Hotel")) {
                    price = budget * 0.9;
                    output = String.format("%s - %s - %.2f",location, accommodation, price);
                }
                break;
        }
        System.out.println(output);
    }
}
