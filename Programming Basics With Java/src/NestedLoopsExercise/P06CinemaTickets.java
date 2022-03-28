import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Решение с while & for

//        String movie = "";
//
//        int totalTickets = 0;
//        int student = 0;
//        int standard = 0;
//        int kids = 0;
//
//        while (!"Finish".equals(movie = scanner.nextLine())) {
//            int freeSits = Integer.parseInt(scanner.nextLine());
//
//            double human = 0.0;
//
//            for (int i = 0; i < freeSits; i++) {
//
//                String ticketType = scanner.nextLine();
//
//                switch (ticketType) {
//                    case "student":
//                        student++;
//                        break;
//                    case "standard":
//                        standard++;
//                        break;
//                    case "kid":
//                        kids++;
//                        break;
//                }
//                if (ticketType.equals("End") || human >= freeSits) {
//                    break;
//                }
//                human++;
//                totalTickets++;
//            }
//            System.out.printf("%s - %.2f%% full.\n", movie, (human / freeSits) * 100.00);
//        }
//        System.out.printf("Total tickets: %d\n", totalTickets);
//        System.out.printf("%.2f%% student tickets.\n", (student * 1.0 / totalTickets) * 100);
//        System.out.printf("%.2f%% standard tickets.\n", (standard * 1.0 / totalTickets) * 100);
//        System.out.printf("%.2f%% kids tickets.", (kids * 1.0 / totalTickets) * 100);
//    }
//}

//        Решение с while & while

        String input = scanner.nextLine();

        int totalTickets = 0;
        int kids = 0;
        int students = 0;
        int standard = 0;

        while (!input.equals("Finish")) {
            int places = Integer.parseInt(scanner.nextLine());
            int currentTickets = 0;

            String ticket = scanner.nextLine();
            while (!ticket.equals("End")) {
                currentTickets++;
                totalTickets++;

                switch (ticket) {
                    case "student":
                        students++;
                        break;
                    case "standard":
                        standard++;
                        break;
                    case "kid":
                        kids++;
                        break;
                }
                if (currentTickets >= places) {
                    break;
                }
                ticket = scanner.nextLine();
            }
            System.out.printf("%s - %.2f%% full.\n", input, (currentTickets * 1.0 / places) * 100.00);
            input = scanner.nextLine();
        }
        System.out.printf("Total tickets: %d\n", totalTickets);
        System.out.printf("%.2f%% student tickets.\n", (students * 1.0 / totalTickets) * 100);
        System.out.printf("%.2f%% standard tickets.\n", (standard * 1.0 / totalTickets) * 100);
        System.out.printf("%.2f%% kids tickets.", (kids * 1.0 / totalTickets) * 100);
    }
}