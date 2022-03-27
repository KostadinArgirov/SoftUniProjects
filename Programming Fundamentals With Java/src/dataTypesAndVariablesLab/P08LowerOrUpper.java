package dataTypesAndVariablesLab;

import java.util.Scanner;

public class P08LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char input = scanner.next().charAt(0);

        boolean isUpperCase = Character.isUpperCase(input);

        if (isUpperCase == true) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}