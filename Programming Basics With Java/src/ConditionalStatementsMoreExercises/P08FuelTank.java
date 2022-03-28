import java.util.Scanner;

public class P08FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuelKind = scanner.nextLine();
        double fuelLeft = Double.parseDouble(scanner.nextLine());

        if (fuelLeft >= 25) {
            if (fuelKind.equals("Diesel")) System.out.printf("You have enough %s.", fuelKind.toLowerCase());
            else if (fuelKind.equals("Gasoline")) System.out.printf("You have enough %s.", fuelKind.toLowerCase());
            else if (fuelKind.equals("Gas")) System.out.printf("You have enough %s.", fuelKind.toLowerCase());
            else System.out.println("Invalid fuel!");
        } else {
            if (fuelKind.equals("Diesel")) System.out.printf("Fill your tank with %s!", fuelKind.toLowerCase());
            else if (fuelKind.equals("Gasoline")) System.out.printf("Fill your tank with %s!", fuelKind.toLowerCase());
            else if (fuelKind.equals("Gas")) System.out.printf("Fill your tank with %s!", fuelKind.toLowerCase());
            else System.out.println("Invalid fuel!");
        }
    }
}
