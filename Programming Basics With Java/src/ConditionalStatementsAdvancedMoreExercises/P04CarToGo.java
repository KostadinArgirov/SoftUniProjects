import java.util.Scanner;

public class P04CarToGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            double budget = Double.parseDouble(scanner.nextLine());
            String season = scanner.nextLine();
            String output1 = "";
            String output2 = "";
            double price = 0.0;
            String carClass = "";
            String carType = "";



            switch (season) {
                case "Summer":
                    if (budget <= 100) {
                        carClass.equals("Economy class");
                        carType = "Cabrio";
                        price = budget * 0.35;
                        output1 = String.format("Economy class");
                        output2 = String.format("%s - %.2f", carType, price);
                    } else if (budget <= 500) {
                        carClass.equals("Compact class");
                        carType = "Cabrio";
                        price = budget * 0.45;
                        output1 = String.format("Compact class");
                        output2 = String.format("%s - %.2f", carType, price);
                    } else if (budget > 500) {
                        carClass.equals("Luxury class");
                        carType = "Jeep";
                        price = budget * 0.9;
                        output1 = String.format("Luxury class");
                        output2 = String.format("%s - %.2f", carType, price);
                    }
                    break;
                case "Winter":
                    if (budget <= 100) {
                        carClass.equals("Economy class");
                        carType = "Jeep";
                        price = budget * 0.65;
                        output1 = String.format("Economy class");
                        output2 = String.format("%s - %.2f", carType, price);
                    } else if (budget <= 500) {
                        carClass.equals("Compact class");
                        carType = "Jeep";
                        price = budget * 0.8;
                        output1 = String.format("Compact class");
                        output2 = String.format("%s - %.2f", carType, price);
                    } else if (budget > 500) {
                        carClass.equals("Luxury class");
                        carType = "Jeep";
                        price = budget * 0.9;
                        output1 = String.format("Luxury class");
                        output2 = String.format("%s - %.2f", carType, price);
                    }
                    break;
            }
        System.out.println(output1);
        System.out.println(output2);
    }
}
