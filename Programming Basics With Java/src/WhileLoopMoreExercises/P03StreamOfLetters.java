import java.util.Scanner;

public class P03StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String message = "";
//        int counterC = 0;
//        int counterO = 0;
//        int counterN = 0;
//
//        while (true) {
//            String word = scanner.nextLine();
//            if (word.equals("End")) {
//                break;
//            }
//            switch (word) {
//                case "c":
//                    if (counterC == 0) {
//                        counterC++;
//                        continue;
//                    } else {
//                        message = "message" + "word";
//                        continue;
//                    }
//                case "o":
//                    if (counterO == 0) {
//                        counterO++;
//                        continue;
//                    } else {
//                        message = "message" + "word";
//                        continue;
//                    }
//                case "n":
//                    if (counterN == 0) {
//                        counterN++;
//                        continue;
//                    } else {
//                        message = "message" + "word";
//                        continue;
//                    }
//            }
//            message = "message" + "word";
//        }
//        System.out.println(message);
//    }
//}
        String command = scanner.nextLine();
        int c = 0, o = 0, n = 0;
        String word = "";

        while (!command.equals("End")) {
            char letter = command.charAt(0);
            if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')) {
                switch (letter) {
                    case 'c':
                        if (c > 0) {
                            word += letter;
                        }
                        c++;
                        break;
                    case 'o':
                        if (o > 0) {
                            word += letter;
                        }
                        o++;
                        break;
                    case 'n':
                        if (n > 0) {
                            word += letter;
                        }
                        n++;
                        break;
                    default:
                        word += letter;
                }
            }

            if (c > 0 && o > 0 && n > 0) {
                System.out.print(word + " ");
                c = 0;
                o = 0;
                n = 0;
                word = "";
            }

            command = scanner.next();
        }

    }
}
