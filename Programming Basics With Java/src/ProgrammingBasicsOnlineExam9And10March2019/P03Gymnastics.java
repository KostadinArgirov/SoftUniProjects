import java.util.Scanner;

public class P03Gymnastics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();
        String tool = scanner.nextLine();

        double score = 0.0;

        switch (country) {
            case "Russia":
                if (tool.equals("ribbon")) {
                    score += 9.100 + 9.400;
                } else if (tool.equals("hoop")) {
                    score += 9.300 + 9.800;
            } else if (tool.equals("rope")) {
                    score += 9.600 + 9.000;
                }
                break;
            case "Bulgaria":
                if (tool.equals("ribbon")) {
                    score += 9.600 + 9.400;
                } else if (tool.equals("hoop")) {
                    score += 9.550 + 9.750;
                } else if (tool.equals("rope")) {
                    score += 9.500 + 9.400;
                }
                break;
            case "Italy":
                if (tool.equals("ribbon")) {
                    score += 9.200 + 9.500;
                } else if (tool.equals("hoop")) {
                    score += 9.450 + 9.350;
                } else if (tool.equals("rope")) {
                    score += 9.700 + 9.150;
                }
                break;
        }
        double leftToMax = 20 - score;
        System.out.printf("The team of %s get %.3f on %s.\n", country, score, tool);
        System.out.printf("%.2f%%", (leftToMax / 20) * 100);
    }
}