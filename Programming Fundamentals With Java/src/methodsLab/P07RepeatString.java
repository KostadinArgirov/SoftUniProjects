package methodsLab;

import java.util.Scanner;

public class P07RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int repeats = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatStringThreeTimes(str, repeats));
    }
    private static String repeatStringThreeTimes(String str, int repeats) {
        String result = "";
        for (int i = 0; i < repeats; i++) {
            result += str;
        }
        return result;
    }
}