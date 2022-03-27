import java.util.Scanner;

public class GreetingByName {
    public static void main(String[] args) {
        //1. Прочитаме име от конзолата
        //2. Отпечатваме: "Hello, <name>!"
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "!");
    }
}
