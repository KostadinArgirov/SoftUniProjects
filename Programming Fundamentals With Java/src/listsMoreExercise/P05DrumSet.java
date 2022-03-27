package listsMoreExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05DrumSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double savings = Double.parseDouble(scanner.nextLine());

        List<Integer> drumSet = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Hit it again, Gabsy!")) {
            int power = Integer.parseInt(command);

            for (int i = 0; i < drumSet.size(); i++) {
                drumSet.set(i, (drumSet.get(i) - power));
                if (drumSet.get(i) <= 0) {
                    if (savings - (drumSet.get(i) * 3) >= 0) {
                        savings = savings - (drumSet.get(i) * 3);
                    }
                }
            }


            command = scanner.nextLine();
        }
        System.out.println();
    }
}
//  не е довършена