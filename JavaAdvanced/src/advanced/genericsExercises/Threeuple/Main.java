package advanced.genericsExercises.Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        String firstName = input[0];
        String secondName = input[1];
        String district = input[2];
        String address = input[3];

        Threeuple<String, String, String> threeuple = new Threeuple<>(firstName + " " + secondName, district, address);

        System.out.println(threeuple);

        input = scanner.nextLine().split("\\s+");
        String name = input[0];
        int beerLiters = Integer.parseInt(input[1]);
        String drunkStatus = input[2];

        Threeuple<String, Integer, String> secondThreeuple = new Threeuple<>(name, beerLiters, drunkStatus.equals("drunk") ? "true" : "false");

        System.out.println(secondThreeuple);

        input = scanner.nextLine().split("\\s+");
        name = input[0];
        double accountBalance = Double.parseDouble(input[1]);
        String bankName = input[2];

        Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(name, accountBalance, bankName);

        System.out.println(thirdThreeuple);
    }
}