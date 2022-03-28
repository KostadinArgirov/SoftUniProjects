import java.util.Scanner;

public class P02EasterGuests {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int guests = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double easterBreads = Math.ceil(guests / 3.0);
        double eggs = guests * 2;
        double easterBreadsPrice = easterBreads * 4;
        double eggsPrice = eggs * 0.45;
        double totalPrice = easterBreadsPrice + eggsPrice;

        if (budget >= totalPrice) {
            System.out.printf("Lyubo bought %.0f Easter bread and %.0f eggs.\nHe has %.2f lv. left.", easterBreads, eggs, budget - totalPrice);
        } else {
            System.out.printf("Lyubo doesn't have enough money.\nHe needs %.2f lv. more.", totalPrice - budget);
        }
    }
}