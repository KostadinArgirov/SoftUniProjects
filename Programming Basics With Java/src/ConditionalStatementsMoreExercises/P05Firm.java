import java.util.Scanner;

public class P05Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hoursNeeded = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int numEmployeeOvertime = Integer.parseInt(scanner.nextLine());

        double educationTime = Math.floor((days * 0.9) * 8);
        double educationTimeOvertime = (numEmployeeOvertime * 2) * days;
        double totalEducationTime = educationTime + educationTimeOvertime;
        double timeLeft = totalEducationTime - hoursNeeded;

        if (totalEducationTime >= hoursNeeded) {
            System.out.printf("Yes!%.0f hours left.", timeLeft);
        } else {
            double timeNeeded = hoursNeeded - totalEducationTime;
            System.out.printf("Not enough time!%.0f hours needed.", timeNeeded);
        }


    }
}
