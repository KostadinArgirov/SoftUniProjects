import java.util.Scanner;

public class P01SeriesCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int seasons = Integer.parseInt(scanner.nextLine());
        int episodes = Integer.parseInt(scanner.nextLine());
        double length = Double.parseDouble(scanner.nextLine());

        double commercials = length * 0.2;
        double episodeAndCommercials = commercials + length;
        int allSpecialTime = seasons * 10;

        double totalWatchTime = episodeAndCommercials * episodes * seasons + allSpecialTime;

        System.out.printf("Total time needed to watch the %s series is %.0f minutes.", name, totalWatchTime);
    }
}