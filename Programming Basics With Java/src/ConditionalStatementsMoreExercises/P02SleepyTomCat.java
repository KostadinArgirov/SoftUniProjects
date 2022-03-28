import java.util.Scanner;

public class P02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberRestDays = Integer.parseInt(scanner.nextLine());
        int restDays = numberRestDays * 127;
        int workDays = (365 - numberRestDays) * 63;
        int realGameTime = restDays + workDays;
        int normDifference = 30000 - realGameTime;
        int hour = normDifference / 60;
        int minutes = normDifference % 60;

        if (normDifference >= 0) {
            System.out.println("Tom" + " sleeps" + " well");
            System.out.printf("%d hours and %d minutes less for play", hour, minutes);
        } else {
            System.out.println("Tom will run away");
            int timeMore = realGameTime - 30000;
            int hoursMore = timeMore / 60;
            int minMore = timeMore % 60;
            System.out.printf("%d hours and %d minutes more for play", hoursMore, minMore);
        }


    }
}
