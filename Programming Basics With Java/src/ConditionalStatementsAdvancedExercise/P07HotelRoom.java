import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());
        double apartmentPrice = 0.00;
        double studioPrice = 0.00;
        String output1 = "";
        String output2 = "";

        switch (month) {
            case "May":
            case "October":
                apartmentPrice = nights * 65;
                studioPrice = nights * 50;
                if (nights > 7 && nights <= 14) {
                    studioPrice *= 0.95;
                } else if (nights > 14) {
                    apartmentPrice *= 0.9;
                    studioPrice *= 0.7;
                }
                output1 = String.format("Apartment: %.2f lv.", apartmentPrice);
                output2 = String.format("Studio: %.2f lv.", studioPrice);
                break;
            case "June":
            case "September":
                apartmentPrice = nights * 68.7;
                studioPrice = nights * 75.2;
                if (nights > 14) {
                    apartmentPrice *= 0.9;
                    studioPrice *= 0.8;
                }
                output1 = String.format("Apartment: %.2f lv.", apartmentPrice);
                output2 = String.format("Studio: %.2f lv.", studioPrice);
                break;
            case "July":
            case "August":
                apartmentPrice = nights * 77;
                studioPrice = nights * 76;
                if (nights > 14) {
                    apartmentPrice *= 0.9;
                }
                output1 = String.format("Apartment: %.2f lv.", apartmentPrice);
                output2 = String.format("Studio: %.2f lv.", studioPrice);
                break;
        }
        System.out.println(output1);
        System.out.println(output2);
    }
}
