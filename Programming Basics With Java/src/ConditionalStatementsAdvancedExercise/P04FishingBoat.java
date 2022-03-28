import java.util.Scanner;

public class P04FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fishermen = Integer.parseInt(scanner.nextLine());

        double totalSum = 0.0;
        double discount = 0.0;

        switch (season) {
            case "Spring":
                totalSum = 3000;
                break;
            case "Summer":
            case "Autumn":
                totalSum = 4200;
                break;
            case "Winter":
                totalSum = 2600;
                break;
        }
        if (fishermen <= 6) {
            discount = 0.10;
        } else if (fishermen <= 11) {
            discount = 0.15;
        } else {
            discount = 0.25;
        }
        double moneyNeeded = totalSum - totalSum * discount;

        if (fishermen % 2 == 0 && !season.equals("Autumn")) {
            moneyNeeded *= 0.95;
        }
        if (budget >= moneyNeeded) {
            System.out.printf("Yes! You have %.2f leva left.", budget - moneyNeeded);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", moneyNeeded - budget);
        }

//        double totalSum = 0;
//
//        switch (season) {
//            case "Spring":
//                totalSum = 3000;
//                if (fishermen <= 6) {
//                    totalSum *= 0.9;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//
//                } else if (fishermen >= 7 && fishermen <= 11) {
//                    totalSum *= 0.85;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//
//                } else if (fishermen > 12) {
//                    totalSum *= 0.75;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//                }
//                break;
//            case "Summer":
//                totalSum = 4200;
//                if (fishermen <= 6) {
//                    totalSum *= 0.9;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//
//                } else if (fishermen >= 7 && fishermen <= 11) {
//                    totalSum *= 0.85;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//
//                } else if (fishermen > 12) {
//                    totalSum *= 0.75;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//                }
//                break;
//            case "Autumn":
//                totalSum = 4200;
//                if (fishermen <= 6) {
//                    totalSum *= 0.9;
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//
//                } else if (fishermen >= 7 && fishermen <= 11) {
//                    totalSum *= 0.85;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//
//                } else if (fishermen > 12) {
//                    totalSum *= 0.75;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//                }
//                break;
//            case "Winter":
//                totalSum = 2600;
//                if (fishermen <= 6) {
//                    totalSum *= 0.9;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//
//                } else if (fishermen >= 7 && fishermen <= 11) {
//                    totalSum *= 0.85;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//
//                } else if (fishermen > 12) {
//                    totalSum *= 0.75;
//                    if (fishermen % 2 == 0) {
//                        totalSum *= 0.95;
//                    }
//                    if (budget >= totalSum) {
//                        System.out.printf("Yes! You have %.2f leva left.", budget - totalSum);
//                    } else {
//                        System.out.printf("Not enough money! You need %.2f leva.", totalSum - budget);
//                    }
//                }
//                break;
//        }

    }
}
