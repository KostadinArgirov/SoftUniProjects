package finalExam;

import java.util.Scanner;

public class P01WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stops = new StringBuilder(scanner.nextLine());

        String line = scanner.nextLine();

        while (!line.equals("Travel")) {

            String[] data = line.split(":");
            String command = data[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(data[1]);
                    String destination = data[2];

                    if (index >= 0 && index < stops.length()) {
                        stops.insert(index, destination);
                    }
                    System.out.println(stops.toString());
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(data[1]);
                    int endIndex = Integer.parseInt(data[2]);

                    if ((startIndex >= 0 && startIndex < stops.length()) && endIndex >= 0 && endIndex < stops.length()) {
                        stops.delete(startIndex, endIndex + 1);
                    }
                    System.out.println(stops.toString());
                    break;
                case "Switch":
                    String oldString = data[1];
                    String newString = data[2];
                    String replacedString = stops.toString().replaceAll(oldString, newString);
                    stops.setLength(0);
                    stops.append(replacedString);
                    System.out.println(stops.toString());
                    break;
            }


            line = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s",stops.toString());
    }
}