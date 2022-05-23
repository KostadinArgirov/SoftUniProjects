package stacksAndQueuesExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P09PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> plants = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(plants::push);
        int day =-1;
        boolean haveDead = false;
        do {
            haveDead = false;
            for (int i = plants.size()-1; i > 0; i--) {
                int temp = plants.pop();
                int left = plants.peek();
                if (temp > left) {
                    haveDead = true;
                } else {
                    plants.offer(temp);
                }
            }
            plants.offer(plants.pop());
            day++;
        } while (haveDead);
        System.out.println(day);
    }
}