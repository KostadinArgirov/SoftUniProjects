import java.util.Scanner;

public class P01ChangeBureau {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bitcoinNumber = Integer.parseInt(scanner.nextLine());
        double chineseYuan = Double.parseDouble(scanner.nextLine());
        double commission = Double.parseDouble(scanner.nextLine());

        double sumInLv = bitcoinNumber * 1168 + chineseYuan * 0.264;
        double sumInEur = sumInLv / 1.95;
        commission = sumInEur * (commission / 100);

        System.out.printf("%.2f", sumInEur - commission);

    }
}
