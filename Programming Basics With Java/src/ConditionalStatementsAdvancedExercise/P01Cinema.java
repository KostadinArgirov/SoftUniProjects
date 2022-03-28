import java.util.Scanner;

public class P01Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projectionType = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());

        double income = 0;

        switch (projectionType) {
            case "Premiere":
                income = rows * columns * 12;
                System.out.printf("%.2f leva", income);
                break;
            case "Normal":
                income = rows * columns * 7.5;
                System.out.printf("%.2f leva", income);
                break;
            case "Discount":
                income = rows * columns * 5;
                System.out.printf("%.2f leva", income);
                break;
        }

    }
}
