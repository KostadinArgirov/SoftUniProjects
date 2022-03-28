import java.util.Scanner;

public class P01AgencyProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int adultTickets = Integer.parseInt(scanner.nextLine());
        int childrenTickets = Integer.parseInt(scanner.nextLine());
        double adultNetPrice = Double.parseDouble(scanner.nextLine());
        double serviceFee = Double.parseDouble(scanner.nextLine());

        double childrenNetPrice = adultNetPrice * 0.3;

        double adultTicketPlusFee = adultNetPrice + serviceFee;
        double childrenTicketPlusFee = childrenNetPrice + serviceFee;
        double totalTicketPrice = adultTickets * adultTicketPlusFee + childrenTickets * childrenTicketPlusFee;
        double income = totalTicketPrice * 0.2;

        System.out.printf("The profit of your agency from %s tickets is %.2f lv.", name, income);
    }
}