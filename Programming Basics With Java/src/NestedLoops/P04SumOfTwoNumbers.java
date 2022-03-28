import java.util.Scanner;

public class P04SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magic = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        int firstNum = 0;
        int secondNum = 0;
        boolean hasMagicalNum = false;

        for (firstNum = start; firstNum <= end; firstNum++) {
            for (secondNum = start; secondNum <= end; secondNum++) {
                counter++;
                if (firstNum + secondNum == magic) {
                    hasMagicalNum = true;
                    break;
                }
            }
            if (hasMagicalNum) {
                break;
            }
        }
        if (hasMagicalNum) {
            System.out.printf("Combination N:%d (%d + %d = %d)",
                    counter, firstNum, secondNum, magic);
        }else {
            System.out.printf("%d combinations - neither equals %d",
                    counter, magic);
        }
    }
}