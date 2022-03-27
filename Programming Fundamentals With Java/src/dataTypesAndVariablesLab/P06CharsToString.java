package dataTypesAndVariablesLab;

import java.util.Scanner;

public class P06CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String concatChars = "";
//
//        for (int i = 0; i < 3; i++) {
//            String input = scanner.next();
//            concatChars += input;
//        }
//        System.out.println(concatChars);
//    }
//}


        String concatChars = "";

        for (int i = 0; i < 3; i++) {
            char input = scanner.next().charAt(0);
            concatChars += input;
        }
        System.out.println(concatChars);
    }
}