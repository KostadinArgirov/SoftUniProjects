import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double sideWallArea = x * y;
        double windowArea = 1.5 * 1.5;
        double twoSidesArea = 2 * sideWallArea - 2 * windowArea;
        double backSide = x * x;
        double entrance = 1.2 * 2;
        double frontAndRearSide = 2 * backSide - entrance;
        double totalHouseArea = twoSidesArea + frontAndRearSide;
        double totalGreenPaint = totalHouseArea / 3.4;

        double twoRectangleRoof = 2 * sideWallArea;
        double twoTriangleRoof = 2 * (x * h / 2);
        double totalAreaRoof = twoRectangleRoof + twoTriangleRoof;
        double totalRedPaint = totalAreaRoof / 4.3;
        System.out.printf("%.2f%n", totalGreenPaint);
        System.out.printf("%.2f%n", totalRedPaint);

    }
}
