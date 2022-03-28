import java.util.Scanner;

public class P04CinemaVoucher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int voucher = Integer.parseInt(scanner.nextLine());

        int ticketsCount = 0;
        int othersCount = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String name = input;

            var currentLine = name.toCharArray();
            int first = currentLine[0];
            int second = currentLine[1];

            if (name.length() > 8) {
                ticketsCount++;
                voucher -= first + second;
            } else {
                othersCount++;
                voucher -= first;
            }
            if (voucher == 0) {
                break;
            }
            if (voucher < 0 ) {
                if (name.length() > 8) {
                    voucher += first + second;
                    ticketsCount--;
                    break;
                } else {
                    voucher += first;
                    othersCount--;
                    break;
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(ticketsCount);
        System.out.println(othersCount);
    }
}