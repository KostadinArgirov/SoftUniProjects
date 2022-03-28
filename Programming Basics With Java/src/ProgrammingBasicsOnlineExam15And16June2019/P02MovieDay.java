import java.util.Scanner;

public class P02MovieDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int timeForShooting = Integer.parseInt(scanner.nextLine());
        int scenes = Integer.parseInt(scanner.nextLine());
        int sceneTime = Integer.parseInt(scanner.nextLine());

        double preparation = timeForShooting * 0.15;
        double totalSceneShooting = scenes * sceneTime;
        double neededTime = preparation + totalSceneShooting;

        if (neededTime <= timeForShooting) {
            System.out.printf("You managed to finish the movie on time! You have %.0f minutes left!", timeForShooting - neededTime);
        } else {
            System.out.printf("Time is up! To complete the movie you need %.0f minutes.", neededTime - timeForShooting);
        }
    }
}