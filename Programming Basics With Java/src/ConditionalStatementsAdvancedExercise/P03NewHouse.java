import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowerType = scanner.nextLine();
        int numberOfFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double totalSum = 0;

        switch (flowerType) {
            case "Roses":
                totalSum = numberOfFlowers * 5;
                if (numberOfFlowers > 80)
                    totalSum *= 0.9;
                    if (budget >= totalSum) {
                        double moneyLeft = budget - totalSum;
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, flowerType, moneyLeft);
                    } else {
                        double moneyNeeded = totalSum - budget;
                        System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
                    }
                break;
            case "Dahlias":
                totalSum = numberOfFlowers * 3.8;
                if (numberOfFlowers > 90)
                    totalSum *= 0.85;
                if (budget >= totalSum) {
                    double moneyLeft = budget - totalSum;
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, flowerType, moneyLeft);
                } else {
                    double moneyNeeded = totalSum - budget;
                    System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
                }
                break;
            case "Tulips":
                totalSum = numberOfFlowers * 2.8;
                if (numberOfFlowers > 80)
                    totalSum *= 0.85;
                if (budget >= totalSum) {
                    double moneyLeft = budget - totalSum;
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, flowerType, moneyLeft);
                } else {
                    double moneyNeeded = totalSum - budget;
                    System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
                }
                break;
            case "Narcissus":
                totalSum = numberOfFlowers * 3;
                if (numberOfFlowers < 120)
                    totalSum *= 1.15;
                if (budget >= totalSum) {
                    double moneyLeft = budget - totalSum;
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, flowerType, moneyLeft);
                } else {
                    double moneyNeeded = totalSum - budget;
                    System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
                }
                break;
            case "Gladiolus":
                totalSum = numberOfFlowers * 2.5;
                if (numberOfFlowers < 80)
                    totalSum *= 1.2;
                if (budget >= totalSum) {
                    double moneyLeft = budget - totalSum;
                    System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", numberOfFlowers, flowerType, moneyLeft);
                } else {
                    double moneyNeeded = totalSum - budget;
                    System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
                }
                break;
                }
        }
    }
