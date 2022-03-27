package midExam;

import java.util.Scanner;

public class P01GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodKg = Double.parseDouble(scanner.nextLine());
        double hayKg = Double.parseDouble(scanner.nextLine());
        double coverKg = Double.parseDouble(scanner.nextLine());
        double guineaKg = Double.parseDouble(scanner.nextLine());

        for (int i = 1; i <= 30; i++) {
            foodKg -= 0.3;
            if (i % 2 == 0) {
                hayKg -= foodKg * 0.05;
            }
            if (i % 3 == 0) {
                coverKg -= guineaKg * (1.0 / 3);
            }
            if (foodKg < 0.1 || hayKg < 0.1 || coverKg < 0.1) {
                System.out.println("Merry must go to the pet store!");
                return;
            }
        }
        System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodKg, hayKg, coverKg);
    }
}