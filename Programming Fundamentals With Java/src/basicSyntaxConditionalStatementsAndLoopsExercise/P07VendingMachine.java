package basicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class P07VendingMachine {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        double totalSum = 0.0;
//
//        String input = scanner.nextLine();
//
//        while (!input.equals("Start")) {
//            double sum = Double.parseDouble(input);
//            if (sum != 0.1 && sum != 0.2 && sum != 0.5 && sum != 1 && sum != 2) {
//                System.out.printf("Cannot accept %.2f%n", sum);
//                totalSum -= sum;
//            }
//            totalSum += sum;
//
//            input = scanner.nextLine();
//        }
//        String product = scanner.nextLine();
//
//        double price = 0.0;
//        double totalPrice = 0.0;
//
//        while (!product.equals("End")) {
//            switch (product) {
//                case "Nuts":
//                    price = 2.0;
//                    break;
//                case "Water":
//                    price = 0.7;
//                    break;
//                case "Crisps":
//                    price = 1.5;
//                    break;
//                case "Soda":
//                    price = 0.8;
//                    break;
//                case "Coke":
//                    price = 1.0;
//                    break;
//                default:
//                    System.out.println("Invalid product");
//                    product = scanner.nextLine();
//                    break;
//            }
//            totalPrice += price;
//            if (price > totalSum) {
//                System.out.println("Sorry, not enough money");
//            } else {
//                System.out.printf("Purchased %s%n", product);
//                totalSum -= price;
//            }
//            product = scanner.nextLine();
//        }
//        System.out.printf("Change: %.2f", totalSum);
//    }
//}

        Scanner scanner = new Scanner(System.in);
        double coins = 0;

        String input = scanner.nextLine();
        while (!input.equals("Start")) {
            double currentCoins = Double.parseDouble(input);
            if (currentCoins == 0.1 || currentCoins == 0.2 || currentCoins == 0.5 || currentCoins == 1 || currentCoins == 2) {
                coins += currentCoins;
            } else {

                System.out.printf("Cannot accept %.02f", Double.parseDouble(input));
            }
            input = scanner.nextLine();
        }
        // Start is entered
        input = scanner.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    if (coins < 2.0) System.out.println("Sorry, not enough money");
                    else {
                        System.out.println("Purchased " + input);
                        coins -= 2.0;
                    }
                    break;
                case "Water":
                    if (coins < .7) System.out.println("Sorry, not enough money");
                    else {
                        System.out.println("Purchased " + input);
                        coins -= .7;
                    }
                    break;
                case "Crisps":
                    if (coins < 1.5) System.out.println("Sorry, not enough money");
                    else {
                        System.out.println("Purchased " + input);
                        coins -= 1.5;
                    }
                    break;
                case "Soda":
                    if (coins < .8) System.out.println("Sorry, not enough money");
                    else {
                        System.out.println("Purchased " + input);
                        coins -= .8;
                    }
                    break;
                case "Coke":
                    if (coins < 1.0) System.out.println("Sorry, not enough money");
                    else {
                        System.out.println("Purchased " + input);
                        coins -= 1.0;
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.02f", coins);
    }
}