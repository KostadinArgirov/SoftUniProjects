import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = "";

        int totalTickets = 0;
        int student = 0;
        int standard = 0;
        int kids = 0;

        while (!"Finish".equals(movie = scanner.nextLine())) {
            int freeSits = Integer.parseInt(scanner.nextLine());

            double human = 0.0;

            for (int i = 0; i < freeSits; i++) {

                String ticketType = scanner.nextLine();

                switch (ticketType) {
                    case "student":
                        student++;
                        break;
                    case "standard":
                        standard++;
                        break;
                    case "kid":
                        kids++;
                        break;
                }
                if (ticketType.equals("End") || human >= freeSits) {
                    break;
                }
                human++;
                totalTickets++;
            }
            System.out.printf("%s - %.2f%% full.\n", movie, (human / freeSits) * 100.00);
        }
        System.out.printf("Total tickets: %d\n", totalTickets);
        System.out.printf("%.2f%% student tickets.\n", (student * 1.0 / totalTickets) * 100);
        System.out.printf("%.2f%% standard tickets.\n", (standard * 1.0 / totalTickets) * 100);
        System.out.printf("%.2f%% kids tickets.", (kids * 1.0 / totalTickets) * 100);
    }
}