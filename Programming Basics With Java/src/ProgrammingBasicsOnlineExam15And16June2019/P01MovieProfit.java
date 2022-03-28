import java.util.Scanner;

public class P01MovieProfit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int tickets = Integer.parseInt(scanner.nextLine());
        double ticketPrice = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        double dayTicketsSum = tickets * ticketPrice;
        double totalTicketsSum = dayTicketsSum * days;
        double percentSum = totalTicketsSum * (percent * 1.0 / 100);
        double income = totalTicketsSum - percentSum;

        System.out.printf("The profit from the movie %s is %.2f lv.", name, income);
    }
}