package dataTypesAndVariablesLab;

import java.util.Scanner;

public class P07ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String concatChars = "";

        for (int i = 0; i < 3; i++) {
            char input = scanner.next().charAt(0);
            concatChars += input + " ";
        }
        String reverse = "";
        int length = concatChars.length() - 1;

        for (int i = length; i >= 0; i--) {
            reverse += concatChars.charAt(i);
        }
        System.out.println(reverse);
    }
}