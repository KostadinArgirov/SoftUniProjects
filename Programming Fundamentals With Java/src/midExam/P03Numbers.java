package midExam;

import java.util.*;
import java.util.stream.Collectors;

public class P03Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int sum = 0;

        for (Integer currentInteger : numbers) {
            sum += currentInteger;
        }

        double averageSum = sum * 1.0 / numbers.size();

        List<Integer> topFiveNumbers = new ArrayList<>();

        for (Integer currentNumber : numbers) {
            if (currentNumber > averageSum) {
                topFiveNumbers.add(currentNumber);
            }
        }

        if (topFiveNumbers.isEmpty()) {
            System.out.println("No");
        } else if (topFiveNumbers.size() < 5) {
            for (Integer number : topFiveNumbers) {
                System.out.printf("%d ", number);
            }
        } else {
            topFiveNumbers = topFiveNumbers.stream().limit(5).collect(Collectors.toList());

            for (Integer number : topFiveNumbers) {
                System.out.printf("%d ", number);
            }
        }
    }
}