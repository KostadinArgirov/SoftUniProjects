import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int paintThinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        double materials = ((nylon + 2) * 1.5) + ((paint * 1.1) * 14.5) + paintThinner * 5 + 0.4;
        double workersSum = materials * 0.3 * hours;
        double totalSum = materials + workersSum;
        System.out.println(totalSum);

    }
}
