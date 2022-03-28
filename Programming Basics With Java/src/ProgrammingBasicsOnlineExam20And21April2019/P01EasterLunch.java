import java.util.Scanner;

public class P01EasterLunch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int easterBreads = Integer.parseInt(scanner.nextLine());
        int eggshells = Integer.parseInt(scanner.nextLine());
        int cookies = Integer.parseInt(scanner.nextLine());

        double easterBreadsPrice = easterBreads * 3.2;
        double eggsPrice = eggshells * 4.35;
        double cookiesPrice = cookies * 5.4;
        double eggsPaint = eggshells * 12 * 0.15;
        double totalPrice = easterBreadsPrice + eggsPrice + cookiesPrice + eggsPaint;

        System.out.printf("%.2f", totalPrice);
    }
}