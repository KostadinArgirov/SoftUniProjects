package genericsExercises.GenericCountMethodString;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<String> box = new Box<>();

        while (n-- > 0) {

            String element = scanner.nextLine();
            box.add(element);
        }

        String elementToCompare = scanner.nextLine();

        System.out.println(box.countGreaterItems(elementToCompare));
    }
}