import java.util.Scanner;

public class P05Everest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int allMetersClimbed = 5364;
        boolean isClimbed = false;
        int daysCount = 1;

        while (!input.equals("END")) {

            if (input.equals("Yes")) {
                daysCount++;
            }

            if (daysCount > 5) {
                break;
            }

            int currentMetersClimbed = Integer.parseInt(scanner.nextLine());

            allMetersClimbed += currentMetersClimbed;

            if (allMetersClimbed >= 8848) {
                isClimbed = true;
                break;
            }

            input = scanner.nextLine();
        }
        if (isClimbed == true) {
            System.out.printf("Goal reached for %d days!", daysCount);
        } else {
            System.out.printf("Failed!\n%d", allMetersClimbed);
        }
    }
}