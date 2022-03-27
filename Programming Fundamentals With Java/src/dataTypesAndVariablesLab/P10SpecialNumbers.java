package dataTypesAndVariablesLab;

import java.util.Scanner;

public class P10SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int num = 1; num <= n; num++) {

            int sumOfDigits = 0;
            int digits = num;

            while (digits > 0) {
                sumOfDigits += digits % 10;
                digits /= 10;
            }
            boolean isSpecial = sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11;

            if (isSpecial) {
                System.out.println(num + " -> " + "True");
            } else {
                System.out.println(num + " -> " + "False");
            }
        }
    }
}