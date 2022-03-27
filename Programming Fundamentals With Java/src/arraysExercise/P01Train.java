package arraysExercise;

import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagonsNumber = Integer.parseInt(scanner.nextLine());

        int[] trainWagons = new int[wagonsNumber];
        int allPassengers = 0;

        for (int i = 0; i < wagonsNumber; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            trainWagons[i] = number;
            allPassengers += trainWagons[i];
        }
        for (int i = 0; i < wagonsNumber; i++) {
            System.out.print(trainWagons[i]);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(allPassengers);
    }
}