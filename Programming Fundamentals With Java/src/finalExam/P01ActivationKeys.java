package finalExam;

import java.util.Scanner;

public class P01ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String activationKey = scanner.nextLine();
//
//        String line = scanner.nextLine();
//
//        while (!line.equals("Generate")) {
//
//            String[] data = line.split(">>>");
//            String command = data[0];
//
//            switch (command) {
//                case "Contains":
//                    String substring = data[1];
//
//                    if (activationKey.contains(substring)) {
//                        System.out.printf("%s contains %s%n", activationKey, substring);
//                    } else {
//                        System.out.println("Substring not found!");
//                    }
//                    break;
//                case "Flip":
//                    String type = data[1];
//                    int startIndex = Integer.parseInt(data[2]);
//                    int endIndex = Integer.parseInt(data[3]);
//
//                    StringBuilder sb = new StringBuilder(activationKey);
//
//                    String firstPart = sb.substring(0, startIndex);
//                    String flip = sb.substring(startIndex, endIndex);
//                    String finalPart = sb.substring(endIndex);
//
//                    if (type.equals("Upper")) {
//                        flip = flip.toUpperCase();
//                    } else {
//                        flip = flip.toLowerCase();
//                    }
//                    activationKey = firstPart + flip + finalPart;
//                    System.out.println(activationKey);
//                    break;
//                case "Slice":
//                    startIndex = Integer.parseInt(data[1]);
//                    endIndex = Integer.parseInt(data[2]);
//
//                    sb = new StringBuilder(activationKey);
//
//                    firstPart = sb.substring(0, startIndex);
//                    finalPart = sb.substring(endIndex);
//
//                    activationKey = firstPart + finalPart;
//                    System.out.println(activationKey);
//                    break;
//            }
//
//
//            line = scanner.nextLine();
//        }
//        System.out.printf("Your activation key is: %s", activationKey);
//    }
//}


        StringBuilder sb = new StringBuilder(scanner.nextLine());

        String line = scanner.nextLine();

        while (!line.equals("Generate")) {

            String[] data = line.split(">>>");
            String command = data[0];

            switch (command) {
                case "Contains":
                    String substring = data[1];

                    if (sb.indexOf(substring) != -1) {
                        System.out.printf("%s contains %s%n", sb, substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String type = data[1];
                    int startIndex = Integer.parseInt(data[2]);
                    int endIndex = Integer.parseInt(data[3]);

                    for (int i = startIndex; i < endIndex; i++) {
                        char currentChar = sb.charAt(i);

                        if (type.equals("Upper")) {
                            sb.setCharAt(i, Character.toUpperCase(currentChar));
                        } else {
                            sb.setCharAt(i, Character.toLowerCase(currentChar));
                        }
                    }
                    System.out.println(sb);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(data[1]);
                    endIndex = Integer.parseInt(data[2]);

                    sb.delete(startIndex, endIndex);
                    System.out.println(sb);
                    break;
            }

            line = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s", sb);
    }
}