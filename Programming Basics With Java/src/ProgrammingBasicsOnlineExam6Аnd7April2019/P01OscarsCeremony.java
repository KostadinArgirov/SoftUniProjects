import java.util.Scanner;

public class P01OscarsCeremony {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rent = Integer.parseInt(scanner.nextLine());

        double statuette = rent * 0.7;
        double catering = statuette * 0.85;
        double sound = catering * 0.5;
        double totalSum = rent + statuette + catering + sound;

        System.out.printf("%.2f", totalSum);
    }
}