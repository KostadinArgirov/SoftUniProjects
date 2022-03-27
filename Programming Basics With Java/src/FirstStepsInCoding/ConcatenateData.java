import java.util.Scanner;

public class ConcatenateData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1. прочит от конзолата: име, фамилия, възраст и град
        //2. Отпечатване на следното съобщение: "You are <firstName> <lastName>, a <age>-years old person from <town>."

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String city = scanner.nextLine();

        System.out.println("You are " + firstName + " " + lastName + ", a " + age + "-years old person from " + city + ".");

    }
}
