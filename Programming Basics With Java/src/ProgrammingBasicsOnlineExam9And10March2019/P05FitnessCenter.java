import java.util.Scanner;

public class P05FitnessCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        int back = 0;
        int chest = 0;
        int legs = 0;
        int abs = 0;
        int shake = 0;
        int bar = 0;

        for (int i = 0; i < people; i++) {
            String activity = scanner.nextLine();

            switch (activity) {
                case "Back":
                    back++;
                    break;
                case "Chest":
                    chest++;
                    break;
                case "Legs":
                    legs++;
                    break;
                case "Abs":
                    abs++;
                    break;
                case "Protein shake":
                    shake++;
                    break;
                case "Protein bar":
                    bar++;
                    break;
            }
        }
        int workout = back + chest + legs + abs;
        int protein = shake + bar;

        System.out.printf("%d - back\n", back);
        System.out.printf("%d - chest\n", chest);
        System.out.printf("%d - legs\n", legs);
        System.out.printf("%d - abs\n", abs);
        System.out.printf("%d - protein shake\n", shake);
        System.out.printf("%d - protein bar\n", bar);
        System.out.printf("%.2f%% - work out\n", (workout * 1.0 / people) * 100);
        System.out.printf("%.2f%% - protein", (protein * 1.0 / people) * 100);
    }
}