package advanced.examPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(tulips::push);

        ArrayDeque<Integer> daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int bouquets = 0;
        int otherTulips = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int tulip = tulips.pop();
            int daffodil = daffodils.poll();

            int sum = tulip + daffodil;

            while (sum > 15) {
                tulip -= 2;
                sum = tulip + daffodil;
            }

            if (sum == 15) {
                bouquets++;
            } else if (sum < 15) {
                otherTulips += sum;
            }
        }

        int leftoverBouquets = otherTulips / 15;
        bouquets += leftoverBouquets;

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}