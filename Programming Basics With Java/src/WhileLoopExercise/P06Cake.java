import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cakeLength = Integer.parseInt(scanner.nextLine());
        int cakeWidth = Integer.parseInt(scanner.nextLine());

        int cakePieces = cakeLength * cakeWidth;

        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int currentCutting = Integer.parseInt(input);
            cakePieces -= currentCutting;

            if (cakePieces <= 0) {
                System.out.printf("No more cake left! You need %d pieces more.", Math.abs(cakePieces));
                return;
            }
            input = scanner.nextLine();
        }
        System.out.printf("%d pieces are left.", cakePieces);
    }
}