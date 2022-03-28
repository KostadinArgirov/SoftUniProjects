import java.util.Scanner;

public class P02CatWalking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int minutesWalk = Integer.parseInt(scanner.nextLine());
        int numberOfWalks = Integer.parseInt(scanner.nextLine());
        int catDayCalories = Integer.parseInt(scanner.nextLine());

        int totalWalkTime = minutesWalk * numberOfWalks;
        int totalBurnedCalories = totalWalkTime * 5;
        double halfCatDayCalories = catDayCalories * 0.5;

        if (totalBurnedCalories >= halfCatDayCalories) {
            System.out.printf("Yes, the walk for your cat is enough. Burned calories per day: %d.", totalBurnedCalories);
        } else {
            System.out.printf("No, the walk for your cat is not enough. Burned calories per day: %d.", totalBurnedCalories);
        }
    }
}
