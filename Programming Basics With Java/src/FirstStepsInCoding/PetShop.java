import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // една опаковка храна за кучета е на цена 2.50 лв, а опаковка храна за котки струва 4 лв.
        // прочети от конзолата 2 реда за броя пакети (за кучета и котки)
        // отпечатване на: "{крайната сума} lv."

        double dogFood = 2.50;
        int catFood = 4;
        int dogFoodPackage = Integer.parseInt(scanner.nextLine());
        int catFoodPackage = Integer.parseInt(scanner.nextLine());
        double totalSum = dogFood * dogFoodPackage + catFood * catFoodPackage;
        System.out.println(totalSum + " lv.");

    }
}
