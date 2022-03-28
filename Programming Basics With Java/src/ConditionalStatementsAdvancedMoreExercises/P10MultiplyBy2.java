import java.util.InputMismatchException;
import java.util.Scanner;

public class P10MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        double multiplyByTwo = 0.0;

        while (number >= 0)
        {
            multiplyByTwo = number * 2;
            System.out.printf("Result: %.2f\n", multiplyByTwo);
            number = Double.parseDouble(scanner.nextLine());
        }
        System.out.println("Negative number!");
        scanner.close();
    }
}
