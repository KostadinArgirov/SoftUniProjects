import java.util.Scanner;

public class P05MovieRatings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int movies = Integer.parseInt(scanner.nextLine());

        double maxRating = Double.MIN_VALUE;
        double minRating = Double.MAX_VALUE;
        double ratingsSum = 0.0;
        String bestRating = "";
        String worstRating = "";

        for (int i = 0; i < movies; i++) {
            String name = scanner.nextLine();
            double rating = Double.parseDouble(scanner.nextLine());

            ratingsSum += rating;

            if (rating > maxRating) {
                maxRating = rating;
                bestRating = name;
            }
            if (rating < minRating) {
                minRating = rating;
                worstRating = name;
            }
        }
        System.out.printf("%s is with highest rating: %.1f\n", bestRating, maxRating);
        System.out.printf("%s is with lowest rating: %.1f\n", worstRating, minRating);
        System.out.printf("Average rating: %.1f", ratingsSum / movies);
    }
}