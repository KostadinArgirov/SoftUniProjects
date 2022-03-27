package finalExam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^@#+(?=[A-Z])(?<barcode>[A-Za-z0-9]{6,})(?<=[A-Z])@#+$";
        int nums = Integer.parseInt(scanner.nextLine());
        Pattern pattern = Pattern.compile(regex);

        while (nums > 0) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                String numbers = "";
                for (char c : input.toCharArray()) {
                    if (Character.isDigit(c)) {
                        numbers += c;
                    }
                }
                if (!numbers.equals("")) {
                    System.out.print("Product group: " + numbers);
                    System.out.println();
                } else {
                    System.out.print("Product group: 00");
                    System.out.println();
                }
            } else {
                System.out.print("Invalid barcode");
                System.out.println();
            }
            nums--;
        }
    }
}