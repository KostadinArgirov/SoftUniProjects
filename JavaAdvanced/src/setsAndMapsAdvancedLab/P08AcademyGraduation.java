package setsAndMapsAdvancedLab;

import java.text.DecimalFormat;
import java.util.*;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> map = new TreeMap<>();

        while (numberOfStudents-- > 0) {

            String studentName = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            map.put(studentName, scores);
        }

        String pattern = "#.###################################";

        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        for (Map.Entry<String, double[]> entry : map.entrySet()) {
            double sum = 0;
            for (double v : entry.getValue()) {
                sum += v;
            }
            sum /= entry.getValue().length;

            System.out.printf("%s is graduated with %s%n", entry.getKey(), decimalFormat.format(sum));
        }
    }
}