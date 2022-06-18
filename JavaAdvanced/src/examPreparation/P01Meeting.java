package examPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class P01Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Integer> males = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(males::push);

        ArrayDeque<Integer> females = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches = 0;

        while (!(males.isEmpty() || females.isEmpty())) {

            if (males.peek() <= 0) {
                males.pop();
                continue;
            }

            if (females.peek() <= 0) {
                females.poll();
                continue;
            }

            if (males.peek() % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }

            if (females.peek() % 25 == 0) {
                females.poll();
                females.poll();
                continue;
            }

            int male = males.pop();
            int female = females.poll();

            if (male == female) {
                matches++;
            } else {
                males.push(male - 2);
            }
        }

        String result;

        System.out.printf("Matches: %d%n", matches);

        if (males.isEmpty()) {
            result = "Males left: none";
        } else {
            result = String.format("Males left: %s", males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);

        if (females.isEmpty()) {
            result = "Females left: none";
        } else {
            result = String.format("Females left: %s", females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);
    }
}