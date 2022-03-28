import java.util.Scanner;

public class P02Skeleton {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int controlMinutes = Integer.parseInt(scanner.nextLine());
        int controlSeconds = Integer.parseInt(scanner.nextLine());
        double runwayLength = Double.parseDouble(scanner.nextLine());
        int secondsPer100M = Integer.parseInt(scanner.nextLine());

        int controlInSeconds = controlMinutes * 60 +controlSeconds;
        double timeMinus = runwayLength / 120;
        double totalTimeMinus = timeMinus * 2.5;
        double marinTime = (runwayLength / 100) * secondsPer100M - totalTimeMinus;

        if (marinTime <= controlInSeconds) {
            System.out.println("Marin Bangiev won an Olympic quota!");
            System.out.printf("His time is %.3f.", marinTime);
        } else {
            System.out.printf("No, Marin failed! He was %.3f second slower.", marinTime - controlInSeconds);
        }
    }
}