import java.util.Scanner;

public class P03Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double p1 = 0.0;
        double p2 = 0.0;
        double p3 = 0.0;
        double p4 = 0.0;
        double p5 = 0.0;
        String percent = "%";

        for (int i = 0; i < n ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number >= 1 && number < 200) {
                p1 ++;
            } else if (number < 400) {
                p2 ++;
            } else if (number < 600) {
                p3 ++;
            } else if (number < 800) {
                p4 ++;
            } else if (number <= 1000) {
                p5 ++;
            }
        }
        double p1Percents = (p1 / n) * 100;
        double p2Percents = (p2 / n) * 100;
        double p3Percents = (p3 / n) * 100;
        double p4Percents = (p4 / n) * 100;
        double p5Percents = (p5 / n) * 100;

        System.out.printf("%.2f%s\n", p1Percents, percent);
        System.out.printf("%.2f%s\n", p2Percents, percent);
        System.out.printf("%.2f%s\n", p3Percents, percent);
        System.out.printf("%.2f%s\n", p4Percents, percent);
        System.out.printf("%.2f%s", p5Percents, percent);
    }
}
