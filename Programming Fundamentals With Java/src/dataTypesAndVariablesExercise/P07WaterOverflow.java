package dataTypesAndVariablesExercise;

import java.util.Scanner;

public class P07WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int tank = 0;

        for (int i = 0; i < numberOfLines; i++) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (tank + quantity > 255) {
                System.out.println("Insufficient capacity!");
                continue;
            }
            tank += quantity;
        }
        System.out.println(tank);
    }
}