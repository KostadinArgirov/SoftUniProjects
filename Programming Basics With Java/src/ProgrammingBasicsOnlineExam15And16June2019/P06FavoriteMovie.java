import java.util.Scanner;

public class P06FavoriteMovie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = "";

        int maxPoints = Integer.MIN_VALUE;
        String bestMovie = "";
        int counter = 0;

        while (!"STOP".equals(movie = scanner.nextLine())) {
            counter++;
            int namePoints = 0;
            int movieLength = movie.length();

            if (counter == 7) {
                System.out.println("The limit is reached.");
                break;
            }
            for (int i = 0; i < movieLength; i++) {
                char symbol = movie.charAt(i);

                if (symbol >= 65 && symbol <= 90) {
                    namePoints += symbol - movieLength;
                } else if (symbol >= 97 && symbol <= 122) {
                    namePoints += symbol - (movieLength * 2);
                } else {
                    namePoints += symbol;
                }
            }
            if (namePoints > maxPoints) {
                maxPoints = namePoints;
                bestMovie = movie;
            }
        }
        System.out.printf("The best movie for you is %s with %d ASCII sum.", bestMovie, maxPoints);
    }
}