package finalExam;

import java.util.Scanner;

public class ProblemOneStringManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String line = scanner.nextLine();

        while (!line.equals("End")) {

            String[] data = line.split("\\s+");
            String command = data[0];

            switch (command) {
                case "Translate":
                    translate(sb, data);
                    break;
                case "Includes":
                    includesSubstring(sb, data);
                    break;
                case "Start":
                    containsStart(sb, data);
                    break;
                case "Lowercase":
                    toLowercase(sb);
                    break;
                case "FindIndex":
                    findIndex(sb, data);
                    break;
                case "Remove":
                    removeSubstring(sb, data);
                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static void translate(StringBuilder sb, String[] data) {
        String ch = data[1];
        String replacement = data[2];

        String text = sb.toString().replace(ch, replacement);
        sb.setLength(0);
        sb.append(text);
        System.out.println(sb.toString());
    }

    private static void includesSubstring(StringBuilder sb, String[] data) {
        String text;
        String substring = data[1];
        text = sb.toString();

        if (text.contains(substring)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static void containsStart(StringBuilder sb, String[] data) {
        String text;
        String substring;
        substring = data[1];

        text = sb.toString();

        String start = text.substring(0, substring.length());

        if (start.equals(substring)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    private static void toLowercase(StringBuilder sb) {
        String text;
        text = sb.toString().toLowerCase();

        System.out.println(text);

        sb.setLength(0);
        sb.append(text);
    }

    private static void findIndex(StringBuilder sb, String[] data) {
        String text;
        String ch;
        ch = data[1];

        text = sb.toString();
        int lastIndex = text.lastIndexOf(ch);
        System.out.println(lastIndex);
    }

    private static void removeSubstring(StringBuilder sb, String[] data) {
        int startIndex = Integer.parseInt(data[1]);
        int count = Integer.parseInt(data[2]);

        sb.replace(startIndex, count + startIndex, "");
        System.out.println(sb.toString());
    }
}