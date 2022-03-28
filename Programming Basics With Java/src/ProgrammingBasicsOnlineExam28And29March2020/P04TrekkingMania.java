import java.util.Scanner;

public class P04TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groupNumber = Integer.parseInt(scanner.nextLine());

        int membersSum = 0;
        int musala = 0;
        int montBlanc = 0;
        int kilimanjaro = 0;
        int k2 = 0;
        int everest = 0;

        for (int i = 0; i < groupNumber; i++) {
            int groupMembersNumber = Integer.parseInt(scanner.nextLine());
            membersSum += groupMembersNumber;

            if (groupMembersNumber < 6) {
                musala+= groupMembersNumber;
            } else if (groupMembersNumber < 13) {
                montBlanc+= groupMembersNumber;
            } else if (groupMembersNumber < 26) {
                kilimanjaro+= groupMembersNumber;
            } else if (groupMembersNumber < 41) {
                k2+= groupMembersNumber;
            } else {
                everest+= groupMembersNumber;
            }
        }
        System.out.printf("%.2f%%\n", (musala * 1.0 / membersSum) * 100);
        System.out.printf("%.2f%%\n", (montBlanc * 1.0 / membersSum) * 100);
        System.out.printf("%.2f%%\n", (kilimanjaro * 1.0 / membersSum) * 100);
        System.out.printf("%.2f%%\n", (k2 * 1.0 / membersSum) * 100);
        System.out.printf("%.2f%%", (everest * 1.0 / membersSum) * 100);

    }
}
