import java.util.Scanner;

public class P02EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int n1 = Integer.parseInt(scanner.nextLine());
//        int n2 = Integer.parseInt(scanner.nextLine());
//
//        for (int i = n1; i <= n2; i++) {
//            String currentNum = "" + i;
//            int oddSum = 0;
//            int evenSum = 0;
//            for (int j = 0; j < currentNum.length(); j++) {
//                int currentDigit = Integer.parseInt("" + currentNum.charAt(j));
//                if (j % 2 == 0) {
//                    evenSum += currentDigit;
//                } else {
//                    oddSum += currentDigit;
//                }
//            }
//            if (oddSum == evenSum) {
//                System.out.print(i + " ");
//            }
//        }
//    }
//}

// втори вариант

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        for (int i = n1; i <= n2; i++) {
            int currentNumber = i;
            int oddSum = 0;
            int evenSum = 0;

            for (int pos = 6; pos > 0; pos--) {
                int digit = currentNumber % 10;
                currentNumber /= 10;
                if (pos % 2 == 0) {
                    evenSum += digit;
                } else {
                    oddSum += digit;
                }
            }
            if (oddSum == evenSum) {
                System.out.print(i + " ");
            }
        }
    }
}