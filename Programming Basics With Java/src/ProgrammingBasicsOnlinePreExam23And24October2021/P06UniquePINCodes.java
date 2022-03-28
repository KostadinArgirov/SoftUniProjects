import java.util.Scanner;

public class P06UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int limitFirst = Integer.parseInt(scanner.nextLine());
        int limitSecond = Integer.parseInt(scanner.nextLine());
        int limitThird = Integer.parseInt(scanner.nextLine());

        for (int first = 2; first <= limitFirst; first += 2) {
            for (int second = 2; second <= limitSecond; second++) {
                for (int third = 2; third <= limitThird; third += 2) {

                    if (second == 2 || second == 3 || second == 5 || second == 7) {
                        System.out.printf("%d %d %d\n", first, second, third);
                    }
                }
            }
        }
    }
}