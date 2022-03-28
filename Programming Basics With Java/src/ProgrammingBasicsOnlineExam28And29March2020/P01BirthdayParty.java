import java.util.Scanner;

public class P01BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double rent = Double.parseDouble(scanner.nextLine());

        double cake = rent * 0.2;
        double drinks = cake * 0.55;
        double animator = rent * 0.3333333333333333;
        double moneyNeeded = rent + cake + drinks + animator;

        System.out.printf("%.1f", moneyNeeded);

    }
}
