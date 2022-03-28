import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double wInMeters = Double.parseDouble(scanner.nextLine());
        double hInMeters = Double.parseDouble(scanner.nextLine());
        double wInCentimeters = wInMeters * 100;
        double hInCentimeters = (hInMeters * 100) - 100;
        int deskRows = (int) (hInCentimeters / 70);
        int rows = (int) (wInCentimeters / 120);
        double numberOfSeats = deskRows * rows - 3;
        System.out.printf("%.0f", numberOfSeats);


    }
}
