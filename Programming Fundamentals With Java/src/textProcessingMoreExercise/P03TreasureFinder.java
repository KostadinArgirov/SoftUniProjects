package textProcessingMoreExercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03TreasureFinder {
    private static final Pattern MESSAGE_PATTERN = Pattern.compile("^.*&(?<type>.+)&.*<(?<coordinates>.+)>$");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] keys = Arrays
                .stream(scanner.nextLine().trim().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input;
        while (!"find".equals(input = scanner.nextLine())) {
            String message = decryptMessage(input, keys);
            Matcher matcher = MESSAGE_PATTERN.matcher(message);
            if (matcher.matches()) {
                String type = matcher.group("type");
                String coordinates = matcher.group("coordinates");
                System.out.printf("Found %s at %s%n", type, coordinates);
            }
        }
    }

    private static String decryptMessage(String encryptedMessage, int[] keys) {
        char[] chars = new char[encryptedMessage.length()];
        encryptedMessage.getChars(0, encryptedMessage.length(), chars, 0);

        int keysIndex = 0;
        for (int charsIndex = 0; charsIndex < chars.length; charsIndex++) {
            if (keysIndex >= keys.length) {
                keysIndex = 0;
            }
            chars[charsIndex] -= keys[keysIndex++];
        }

        return String.valueOf(chars);
    }
}