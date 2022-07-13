package oop.interfacesAndAbstractionExercises.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Birthable> creatures = new ArrayList<>();

        while (!"End".equals(input)) {
            String[] data = input.split(" ");
            String typeToCreate = data[0];

            switch (typeToCreate) {
                case "Citizen":
                    String citizenName = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String citizenBirthDate = data[4];

                    Birthable citizen = new Citizen(citizenName, age, id, citizenBirthDate);
                    creatures.add(citizen);
                    break;
                case "Pet":
                    String petName = data[1];
                    String birthDate = data[2];

                    Birthable pet = new Pet(petName, birthDate);
                    creatures.add(pet);
                    break;
                case "Robot":
                    //ToDo: Create Robots!!!
                    break;
            }
            input = scanner.nextLine();

        }

        String year = scanner.nextLine();

        for (Birthable birthable : creatures) {
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}