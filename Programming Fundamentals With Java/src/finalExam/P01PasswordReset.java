package finalExam;

import java.util.Scanner;

public class P01PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String line = scanner.nextLine();

        while (!line.equals("Done")) {
            String[] data = line.split(" ");
            String command = data[0];

            switch (command) {
                case "TakeOdd":
                    StringBuilder newPassword = new StringBuilder();
                    for (int i = 1; i < password.length(); i += 2) {
                        newPassword.append(password.charAt(i));
                    }
                    password = newPassword.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int start = Integer.parseInt(data[1]);
                    int end = start + Integer.parseInt(data[2]);

                    password = new StringBuilder(password)
                            .delete(start, end)
                            .toString();
                    System.out.println(password);
                    break;
                case "Substitute":
                    String target = data[1];
                    String replacement = data[2];

                    if (password.contains(target)) {
                        password = password.replace(target, replacement);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", password);
    }
}