package methodsExercise;

import java.util.Scanner;

public class P05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        int addResult = addTwoInts(num1, num2);
        int result = subtractTwoInts(addResult, num3);

        System.out.println(result);
    }
    private static int addTwoInts(int n1, int n2) {
        int addSum = n1 + n2;
        return addSum;
    }
    private static int subtractTwoInts(int n1, int n2) {
        return n1 - n2;
    }
}