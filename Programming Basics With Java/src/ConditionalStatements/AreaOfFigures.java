import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String figure = scanner.nextLine();
        if (figure.equals("square")) {
            double sideSquare = Double.parseDouble(scanner.nextLine());
            double squareArea = sideSquare * sideSquare;
            System.out.printf("%.3f", squareArea);

        } else if (figure.equals("rectangle")) {
            double sideA = Double.parseDouble(scanner.nextLine());
            double sideB = Double.parseDouble(scanner.nextLine());
            double rectangleArea = sideA * sideB;
            System.out.printf("%.3f", rectangleArea);

        } else if (figure.equals("circle")) {
            double r = Double.parseDouble(scanner.nextLine());
            double circleArea = Math.PI * r * r;
            System.out.printf("%.3f", circleArea);

        } else if (figure.equals("triangle")) {
            double height = Double.parseDouble(scanner.nextLine());
            double base = Double.parseDouble(scanner.nextLine());
            double triangleArea = 0.5 * height * base;
            System.out.printf("%.3f", triangleArea);
        }

    }
}
