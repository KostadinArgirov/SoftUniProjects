import java.util.Scanner;
import  java.text.DecimalFormat;

public class P06OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        double result = 0.00;
        String evenOdd = "";

        if (n2 == 0 && (operator.equals("/") || operator.equals("%"))) {
            System.out.printf("Cannot divide %d by zero", n1);
        } else if (operator.equals("/")) {
            double n2D = n2;
            result = n1 / n2D;
            System.out.printf("%d %s %d = %.2f", n1, operator, n2, result);
            } else if (operator.equals("%")) {
            result = n1 % n2;
            System.out.printf("%d %s %d = %.0f", n1, operator, n2, result);
        } else {
            if (operator.equals("+")) {
                result = n1 + n2;
            } else if (operator.equals("-")) {
                result = n1 - n2;
            } else if (operator.equals("*")) {
                result = n1 * n2;
            }
            if (result % 2 == 0) {
                evenOdd = "even";
            } else {
                evenOdd = "odd";
            }
            System.out.printf("%d %s %d = %.0f - %s", n1, operator, n2, result, evenOdd);
        }
    }
}
