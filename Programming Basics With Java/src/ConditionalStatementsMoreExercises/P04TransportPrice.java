import java.util.Scanner;

public class P04TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int nKm = Integer.parseInt(scanner.nextLine());
//        String dayOrNight = scanner.nextLine();
//
//        if (nKm < 20) {
//            if (dayOrNight.equals("day")) {
//                double taxiPriceDay = 0.70 + nKm * 0.79;
//                System.out.printf("%.2f", taxiPriceDay);
//            } else if (dayOrNight.equals("night")) {
//                double taxiPriceNight = 0.70 + nKm * 0.90;
//                System.out.printf("%.2f", taxiPriceNight);
//            }
//        } else if (nKm >= 20) {
//            double busPrice = nKm * 0.09;
//            System.out.printf("%.2f", busPrice);
//
//        } else if (nKm >= 100) {
//            double trainPrice = nKm * 0.06;
//            System.out.printf("%.2f", trainPrice);
        int distance = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();
        double price = 0.0d;
        double taxiRate = 0.0d;

        if (dayOrNight.equals("day")) {
            taxiRate = 0.79;
        } else if (dayOrNight.equals("night")) {
            taxiRate = 0.90;
        }

        if (distance < 20) {
            price = 0.70 + (distance * taxiRate);
        } else if (distance < 100) {
            price = distance * 0.09;
        }else{
            price = distance * 0.06;
        }
        System.out.printf("%.2f", price);
        }

    }

