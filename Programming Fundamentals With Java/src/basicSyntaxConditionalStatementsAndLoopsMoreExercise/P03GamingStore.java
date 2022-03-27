package basicSyntaxConditionalStatementsAndLoopsMoreExercise;

import java.util.Scanner;

public class P03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double currentBalance = Double.parseDouble(scanner.nextLine());
        double totalSpent = 0.0;

        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Game Time")) {
                System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalSpent, currentBalance);
                break;
            }
            if (currentBalance == 0) {
                System.out.println("Out of money!");
                break;
            }
            double price = 0.0;
            switch (input) {
                case "OutFall 4":
                    price = 39.99;
                    if (currentBalance >= price)
                    {
                        System.out.printf("Bought %s%n", input);
                    }
                    else
                    {
                        System.out.println("Too Expensive");
                        price = 0;
                    }
                    break;
                case "CS: OG":
                    price = 15.99;
                    if (currentBalance >= price)
                    {
                        System.out.printf("Bought %s%n", input);
                    }
                    else
                    {
                        System.out.println("Too Expensive");
                        price = 0;
                    }
                    break;
                case "Zplinter Zell":
                    price = 19.99;
                    if (currentBalance >= price)
                    {
                        System.out.printf("Bought %s%n", input);
                    }
                    else
                    {
                        System.out.println("Too Expensive");
                        price = 0;
                    }
                    break;
                case "Honored 2":
                    price = 59.99;
                    if (currentBalance >= price)
                    {
                        System.out.printf("Bought %s%n", input);
                    }
                    else
                    {
                        System.out.println("Too Expensive");
                        price = 0;
                    }
                    break;
                case "RoverWatch":
                    price = 29.99;
                    if (currentBalance >= price)
                    {
                        System.out.printf("Bought %s%n", input);
                    }
                    else
                    {
                        System.out.println("Too Expensive");
                        price = 0;
                    }
                    break;
                case "RoverWatch Origins Edition":
                    price = 39.99;
                    if (currentBalance >= price)
                    {
                        System.out.printf("Bought %s%n", input);
                    }
                    else
                    {
                        System.out.println("Too Expensive");
                        price = 0;
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }
            currentBalance -= price;
            totalSpent += price;
        }
    }
}