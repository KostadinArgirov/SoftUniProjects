import java.util.Scanner;

public class ConverterInchToCm {
    public static void main(String[] args) {
        //1. Прочитаме инчове от конзолата (реално число)
        //2. Изчисляваме см: инчове * 2.54
        //3. Отпечатване см

        Scanner scanner = new Scanner(System.in);
        double inches = Double.parseDouble(scanner.nextLine());
        double sm = inches * 2.54;
        System.out.println(sm);
    }
}
