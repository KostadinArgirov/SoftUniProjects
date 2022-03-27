package regularExpressionsMoreExercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P4SantasSecretHelper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("@([A-Za-z]+)[^@\\-!:>]*!([G])!");

        int key = Integer.parseInt(scanner.nextLine());

        String input;
        while (!"end".equals(input = scanner.nextLine())) {
            StringBuilder decrypted = new StringBuilder();

            for (int i = 0; i < input.length(); i++) {
                char symbol = (char) (input.charAt(i) - key);
                decrypted.append(symbol);
            }
            Matcher matcher = pattern.matcher(decrypted.toString());
            if (matcher.find()) {
                String name = matcher.group(1);
                System.out.println(name);
            }
        }
    }
}