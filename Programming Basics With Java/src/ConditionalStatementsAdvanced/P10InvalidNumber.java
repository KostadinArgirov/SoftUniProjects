import java.util.Scanner;

public class P10InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

//        първи верен вариант
//        if (number >= 100 && number <= 200 || number == 0) {
//
//        } else {
//            System.out.println("invalid");
//        }

//        втори верен вариант
        boolean isValid = ( number >= 100 && number <= 200 ) || number == 0;

        if (!isValid) {
            System.out.println("invalid");
        }

    }
}
