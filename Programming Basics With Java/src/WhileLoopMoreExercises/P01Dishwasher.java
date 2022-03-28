import java.util.Scanner;

public class P01Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dishSoap = 750 * Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int platesCount = 0;
        int potsCount = 0;

        while (dishSoap >= 0) {
            String text = scanner.nextLine();
            if (text.equals("End")) {
                break;
            }
            int items = Integer.parseInt(text);
            counter++;

            if (counter % 3 == 0) {
                int neededDetergent = items * 15;
                dishSoap -= neededDetergent;

                if (dishSoap >= 0) {
                    potsCount += items;
                }
            } else {
                int neededDetergent = items * 5;
                dishSoap -= neededDetergent;

                if (dishSoap >= 0) {
                    platesCount += items;
                }
            }
        }
        if (dishSoap >= 0) {
            System.out.printf("Detergent was enough!\n" + "%d dishes and %d pots were washed.\n" + "Leftover detergent %d ml.\n", platesCount, potsCount, dishSoap);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", Math.abs(dishSoap));
        }
    }
}