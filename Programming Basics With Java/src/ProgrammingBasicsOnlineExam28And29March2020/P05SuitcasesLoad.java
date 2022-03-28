import java.util.Scanner;

public class P05SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        double trunkCapacity = Double.parseDouble(scanner.nextLine());
//
//        double trunkTaken = 0;
//        int counter = 0;
//        boolean isFull = false;
//
//        String input = scanner.nextLine();
//
//        while (!input.equals("End")) {
//            double currentSuitcase = Double.parseDouble(input);
//            counter++;
//            if (counter % 3 == 0) {
//                trunkTaken += currentSuitcase * 1.1;
//                input = scanner.nextLine();
//                continue;
//            }
//            trunkTaken += currentSuitcase;
//
//            if (trunkTaken > trunkCapacity) {
//                isFull = true;
//                break;
//            }
//            input = scanner.nextLine();
//        }
//        if (isFull) {
//            counter--;
//            System.out.printf("No more space!\nStatistic: %d suitcases loaded.", counter);
//        } else {
//            System.out.printf("Congratulations! All suitcases are loaded!\nStatistic: %d suitcases loaded.", counter);
//        }
//    }
//}
        double capacity = Double.parseDouble(scanner.nextLine());
        String input = "";
        double suitcaseVol = 0;
        int counter = 0;

        while (true) {
            input = scanner.nextLine();

            if (input.equals("End")) {
                System.out.println("Congratulations! All suitcases are loaded!");
                break;
            }

            suitcaseVol = Double.parseDouble(input);

            if (counter % 2 == 0 && counter != 0) {
                suitcaseVol = suitcaseVol + (suitcaseVol * 0.1);
            }

            if (capacity < suitcaseVol) {
                System.out.println("No more space!");
                break;
            }

            capacity -= suitcaseVol;
            counter++;
        }

        System.out.printf("Statistic: %d suitcases loaded.\n", counter);
    }
}