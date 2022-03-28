import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double targetTime = Double.parseDouble(scanner.nextLine());
        double metersDistance = Double.parseDouble(scanner.nextLine());
        double timeFor1MeterSwim = Double.parseDouble(scanner.nextLine());

        double mustSwim = metersDistance * timeFor1MeterSwim;
        double delay = (Math.floor(metersDistance / 15)) * 12.5;

        double totalTime = mustSwim + delay;
        double timeNeeded = totalTime - targetTime;

        if (targetTime > totalTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else if (targetTime <= totalTime) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeNeeded);
        }




    }
}
