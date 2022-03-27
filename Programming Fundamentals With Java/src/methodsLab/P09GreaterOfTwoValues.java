package methodsLab;

import java.util.Scanner;

public class P09GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        if (type.equals("int")){
            int first = Integer.parseInt(scanner.nextLine());
            int second = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(first,second));
        }else
        if (type.equals("char")){
            char first = scanner.nextLine().charAt(0);
            char second = scanner.nextLine().charAt(0);
            System.out.println(getMax(first, second));
        }else if (type.equals("String".toLowerCase())){
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            System.out.println(getMax(first,second));
        }
    }
    static int getMax(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        }
        return num2;
    }
    static char getMax(char ch1, char ch2) {
        if (ch1 > ch2) {
            return ch1;
        }
        return ch2;
    }
    static String getMax(String str1, String str2) {
        if (str1.compareTo(str2) >= 0) {
            return str1;
        }
        return str2;
    }
}