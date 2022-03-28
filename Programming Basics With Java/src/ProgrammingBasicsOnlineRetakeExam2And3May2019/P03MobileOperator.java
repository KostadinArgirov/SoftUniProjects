import java.util.Scanner;

public class P03MobileOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String contractTerm = scanner.nextLine();
        String contractType = scanner.nextLine();
        String mobileNet = scanner.nextLine();
        int monthsPay = Integer.parseInt(scanner.nextLine());

        double monthPrice = 0.0;

        switch (contractType) {
            case "Small":
                if (contractTerm.equals("one")) {
                    monthPrice = 9.98;
                } else if (contractTerm.equals("two")) {
                    monthPrice = 8.58;
                }
                break;
            case "Middle":
                if (contractTerm.equals("one")) {
                    monthPrice = 18.99;
                } else if (contractTerm.equals("two")) {
                    monthPrice = 17.09;
                }
                break;
            case "Large":
                if (contractTerm.equals("one")) {
                    monthPrice = 25.98;
                } else if (contractTerm.equals("two")) {
                    monthPrice = 23.59;
                }
                break;
            case "ExtraLarge":
                if (contractTerm.equals("one")) {
                    monthPrice = 35.99;
                } else if (contractTerm.equals("two")) {
                    monthPrice = 31.79;
                }
                break;
        }
        if (mobileNet.equals("yes")) {
            if (monthPrice <= 10) {
                monthPrice += 5.5;
            } else if (monthPrice <= 30) {
                monthPrice += 4.35;
            } else {
                monthPrice += 3.85;
            }
        }
        double totalPrice = monthsPay * monthPrice;
        if (contractTerm.equals("two")) {
            totalPrice *= 0.9625;
        }
        System.out.printf("%.2f lv.", totalPrice);
    }
}