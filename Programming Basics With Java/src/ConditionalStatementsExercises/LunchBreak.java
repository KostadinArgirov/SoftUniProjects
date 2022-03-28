import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String seriesName = scanner.nextLine();
        int seriesDuration = Integer.parseInt(scanner.nextLine());
        int brake = Integer.parseInt(scanner.nextLine());
        double launchTime = brake / 8.0;
        double relaxTime = brake / 4.0;
        double totalTime = seriesDuration + launchTime + relaxTime;


        if (brake >= totalTime) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", seriesName, Math.ceil(brake - totalTime));
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", seriesName, Math.ceil(totalTime - brake));
        }


    }
}
