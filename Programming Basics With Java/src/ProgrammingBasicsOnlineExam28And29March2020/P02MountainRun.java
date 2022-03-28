import java.util.Scanner;

public class P02MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double recordInSeconds = Double.parseDouble(scanner.nextLine());
        double distanceInMeters = Double.parseDouble(scanner.nextLine());
        double timeFor1MeterInSeconds = Double.parseDouble(scanner.nextLine());

        double mustClimb = distanceInMeters * timeFor1MeterInSeconds;
        double delay = Math.floor(distanceInMeters / 50) * 30;
        double totalTime = mustClimb + delay;

        if (totalTime < recordInSeconds) {
            System.out.printf("Yes! The new record is %.2f seconds.", totalTime);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", totalTime - recordInSeconds);
        }
    }
}
