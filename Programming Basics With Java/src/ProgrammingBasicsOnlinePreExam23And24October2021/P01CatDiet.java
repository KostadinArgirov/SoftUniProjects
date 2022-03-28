import java.util.Scanner;

public class P01CatDiet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fatPercent = Integer.parseInt(scanner.nextLine());
        int proteinPercent = Integer.parseInt(scanner.nextLine());
        int carbsPercent = Integer.parseInt(scanner.nextLine());
        int totalCalories = Integer.parseInt(scanner.nextLine());
        int waterPercent = Integer.parseInt(scanner.nextLine());

        double totalGramsFat = (totalCalories * (fatPercent * 1.0 / 100)) / 9;
        double totalGramsProteins = (totalCalories * (proteinPercent * 1.0 / 100)) / 4;
        double totalGramsCarbs = (totalCalories * (carbsPercent * 1.0 / 100)) / 4;

        double foodWeight = totalGramsFat + totalGramsProteins + totalGramsCarbs;
        double caloriesPerGram = totalCalories / foodWeight;
        double gramFoodWithoutWater = caloriesPerGram - caloriesPerGram * (waterPercent * 1.0 / 100);

        System.out.printf("%.4f", gramFoodWithoutWater);
    }
}