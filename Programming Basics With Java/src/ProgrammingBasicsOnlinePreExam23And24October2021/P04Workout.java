import java.util.Scanner;

public class P04Workout {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysNumber = Integer.parseInt(scanner.nextLine());
        double km = Double.parseDouble(scanner.nextLine());

        double totalKm = 0.0;
        double kmWithout1Km = km;


        for (int i = 0; i < daysNumber; i++) {
            int percent = Integer.parseInt(scanner.nextLine());
            kmWithout1Km += kmWithout1Km * (percent / 100.0);
            totalKm += kmWithout1Km;
        }
        double allKm = totalKm + km;

        if (allKm < 1000) {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(1000 - allKm));
        } else {
            System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(allKm - 1000));
        }
    }
}
