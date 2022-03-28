import java.util.Scanner;

public class P06NameGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        String name = scanner.nextLine();
//        int points = 0;
//        int maxPoints = Integer.MIN_VALUE;
//        String winner = " ";
//
//        while (!name.equals("Stop")) {
//            for (int i = 0; i < name.length(); i++) {
//                char symbol = name.charAt(i);
//                int number = Integer.parseInt(scanner.nextLine());
//
//                if (number == symbol) {
//                    points += 10;
//                } else {
//                    points += 2;
//                }
//            }
//            if (points >= maxPoints) {
//                maxPoints = points;
//                winner = name;
//                points = 0;
//            }
//            name = scanner.nextLine();
//        }
//        System.out.printf("The winner is %s with %d points!", winner, maxPoints);
//    }
//}


        String name = scanner.nextLine();

        int maxPoints = Integer.MIN_VALUE;
        String winner = "";

        while (!name.equals("Stop")) {
            int currentScore = 0;

            for (int i = 0; i < name.length(); i++) {
                char symbol = name.charAt(i);
                int number = Integer.parseInt(scanner.nextLine());

                if (number == symbol) {
                    currentScore += 10;
                } else {
                    currentScore += 2;
                }
                if (currentScore >= maxPoints) {
                    maxPoints = currentScore;
                    winner = name;
                }
            }
            name = scanner.nextLine();
        }

        System.out.printf("The winner is %s with %d points!", winner, maxPoints);
    }
}