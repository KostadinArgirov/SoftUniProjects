package midExamRetake;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] line = input.split("\\s+");
            String command = line[0];
            int index = Integer.parseInt(line[1]);

            switch (command) {
                case "Shoot":
                    shoot(targets, line[2], index);
                    break;
                case "Add":
                    add(targets, line[2], index);
                    break;
                case "Strike":
                    strike(targets, line[2], index);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.print(Arrays.toString(new List[]{targets}).replaceAll("[\\[\\]]", "").replaceAll(", ", "|"));
    }

    private static void shoot(List<Integer> targets, String s, int index) {
        int power = Integer.parseInt(s);
        if (index >= 0 && index < targets.size()) {
            targets.set(index, targets.get(index) - power);
            if (targets.get(index) <= 0) {
                targets.remove(index);
            }
        }
    }

    private static void add(List<Integer> targets, String v, int index) {
        int value = Integer.parseInt(v);
        if (index >= 0 && index < targets.size()) {
            targets.add(index, value);
        } else {
            System.out.println("Invalid placement!");
        }
    }

    private static void strike(List<Integer> targets, String r, int index) {
        int radius = Integer.parseInt(r);
        int start = index - radius;
        int end = index + radius;
        if (start >= 0 && end < targets.size()) {
            targets.subList(start, end + 1).clear();
        } else {
            System.out.println("Strike missed!");
        }
    }
}