import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        //1. две променливи a и b -> от конзолата
        //2. пресмятане на лицето a * b
        //3. отпечатване

        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int area = a * b;

        System.out.println(area);

    }
}
