import java.util.Scanner;

public class P01BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int annualFee = Integer.parseInt(scanner.nextLine());

        double sneakers = annualFee - annualFee * 0.4;
        double outfit = sneakers * 0.8;
        double ball = outfit * 0.25;
        double accessories = ball * 0.2;
        double totalExpenses = annualFee + sneakers + outfit + ball + accessories;

        System.out.printf("%.2f", totalExpenses);
    }
}