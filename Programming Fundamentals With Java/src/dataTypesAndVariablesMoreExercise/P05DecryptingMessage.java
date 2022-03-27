package dataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class P05DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            char ch = scanner.nextLine().charAt(0);
            ch += key;
            System.out.print(ch);
        }
    }
}