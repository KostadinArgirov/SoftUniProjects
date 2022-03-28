import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double twoPipesFilled = p1 * h + p2 * h;

        if (twoPipesFilled <= v){
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.",
                    (twoPipesFilled / v) * 100,
                    (p1*h / twoPipesFilled) * 100,
                    (p2*h / twoPipesFilled) * 100);
        }else{
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, twoPipesFilled - v);
        }


    }
}
