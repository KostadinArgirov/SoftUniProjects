import java.util.Scanner;

public class P03WorldSnookerChampionship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String stage = scanner.nextLine();
//        String ticketType = scanner.nextLine();
//        int ticketsNumber = Integer.parseInt(scanner.nextLine());
//        String photo = scanner.nextLine();
//
//        double price = 0.0;
//
//        switch (stage) {
//            case "Quarter final":
//                if (ticketType.equals("Standard")) {
//                    price += 55.50;
//                } else if (ticketType.equals("Premium")) {
//                    price += 105.20;
//                } else if (ticketType.equals("VIP")) {
//                    price += 118.90;
//                }
//                break;
//            case "Semi final":
//                if (ticketType.equals("Standard")) {
//                    price += 75.88;
//                } else if (ticketType.equals("Premium")) {
//                    price += 125.22;
//                } else if (ticketType.equals("VIP")) {
//                    price += 300.40;
//                }
//                break;
//            case "Final":
//                if (ticketType.equals("Standard")) {
//                    price += 110.10;
//                } else if (ticketType.equals("Premium")) {
//                    price += 160.66;
//                } else if (ticketType.equals("VIP")) {
//                    price += 400;
//                }
//                break;
//        }
//        double allTicketsPrice = price * ticketsNumber;
//
//        if (allTicketsPrice > 4000) {
//            allTicketsPrice *= 0.75;
//        } else if (allTicketsPrice > 2500) {
//            allTicketsPrice *= 0.9;
//        }
//        if (photo.equals("Y") && allTicketsPrice <= 4000) {
//            allTicketsPrice += 40 * ticketsNumber;
//        }
//        System.out.printf("%.2f", allTicketsPrice);
//    }
//}

        String typeOfChampionship = scanner.nextLine().toLowerCase();
        String typeOfTicket = scanner.nextLine().toLowerCase();
        int countOfTickets = Integer.parseInt(scanner.nextLine());
        String pictureWithTrophy = scanner.nextLine().toLowerCase();
        double totalPrice = 0;
        double picturePrice = 0;

        switch (typeOfChampionship) {
            case "final":
                if (typeOfTicket.equals("premium")) {
                    totalPrice = countOfTickets * 160.66;
                } else if (typeOfTicket.equals("standard")) {
                    totalPrice = countOfTickets * 110.10;
                } else if (typeOfTicket.equals("vip")) {
                    totalPrice = countOfTickets * 400;
                }
                break;
            case "semi final":
                if (typeOfTicket.equals("premium")) {
                    totalPrice = countOfTickets * 125.22;
                } else if (typeOfTicket.equals("standard")) {
                    totalPrice = countOfTickets * 75.88;
                } else if (typeOfTicket.equals("vip")) {
                    totalPrice = countOfTickets * 300.40;
                }
                break;
            case "quarter final":
                if (typeOfTicket.equals("premium")) {
                    totalPrice = countOfTickets * 105.20;
                } else if (typeOfTicket.equals("standard")) {
                    totalPrice = countOfTickets * 55.50;
                } else if (typeOfTicket.equals("vip")) {
                    totalPrice = countOfTickets * 118.90;
                }
                break;
            default: {
                break;
            }
        }

        if (totalPrice > 4000) {
            totalPrice = 0.75 * totalPrice;
            System.out.printf("%.2f", totalPrice);
        } else if (totalPrice > 2500) {
            totalPrice *= 0.9;
            if (pictureWithTrophy.equals("y")) {
                picturePrice = countOfTickets * 40;
                totalPrice += picturePrice;
                System.out.printf("%.2f", totalPrice);
            } else {
                System.out.printf("%.2f", totalPrice);
            }
        } else {
            if (pictureWithTrophy.equals("y")) {
                picturePrice = countOfTickets * 40;
                totalPrice += picturePrice;
                System.out.printf("%.2f", totalPrice);
            } else {
                System.out.printf("%.2f", totalPrice);
            }
        }
    }
}