package methodsExercise;

import java.util.Scanner;

public class P08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        double factN1 = factorial(n1);
        double factN2 = factorial(n2);

        divideFact1WithFact2(factN1, factN2);
    }
    static double factorial(double n){
        if (n == 0)
            return 1;
        else
            return(n * factorial(n-1));
    }
    static void divideFact1WithFact2(double v1, double v2) {
        System.out.printf("%.2f", v1 / v2);
    }
}