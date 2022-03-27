package methodsMoreExercise;

import java.util.Scanner;

public class P01DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int number = Integer.parseInt(scanner.nextLine());
                printResult(number);
                break;
            case "real":
                double realNumber = Double.parseDouble(scanner.nextLine());
                printResult(realNumber);
                break;
            case "string":
                String input = scanner.nextLine();
                printResult(input);
                break;
        }
    }
    private static void printResult(int num) {
        num *= 2;
        System.out.println(num);
    }

    private static void printResult(double num) {
        num *= 1.5;
        System.out.printf("%.2f", num);
    }

    private static void printResult(String line) {
        System.out.print("$" + line + "$");
    }
}