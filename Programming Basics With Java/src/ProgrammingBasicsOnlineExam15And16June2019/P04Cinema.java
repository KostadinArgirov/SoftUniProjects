import java.util.Scanner;

public class P04Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();

        int totalPeople = 0;
        int income = 0;

        while (!"Movie time!".equals(input)) {
            int people = Integer.parseInt(input);

            totalPeople += people;

            if (totalPeople > capacity) {
                System.out.println("The cinema is full.");
                break;
            }

            if (people % 3 == 0) {
                income += people * 5 - 5;
            } else {
                income += people * 5;
            }

            input = scanner.nextLine();
        }
        if (totalPeople <= capacity) {
            System.out.printf("There are %d seats left in the cinema.\n", capacity - totalPeople);
        }
        System.out.printf("Cinema income - %d lv.", income);

    }
}