import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int h = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int hour = h;
        int minute = m + 15;
        if (minute > 59) {
            hour++;
            minute -= 60;
        }
        if (hour > 23) {
            hour = 0;
        }
        if (minute < 10) {
            System.out.printf("%d:0%d", hour, minute);
        } else {
            System.out.printf("%d:%d", hour, minute);
        }

        }
    }
