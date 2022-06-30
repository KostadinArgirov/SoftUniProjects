package advanced.definingClassesExercises.Google;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Map<String, Person> personInfo = new HashMap<>();
        String input;

        while (!"End".equals(input = scan.nextLine())) {
            String[] inputData = input.split("\\s+");
            String nameOfPerson = inputData[0];
            personInfo.putIfAbsent(nameOfPerson,
                    new Person(nameOfPerson,new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
            switch (inputData[1]) {
                case "company":
                    Company company =
                            new Company(inputData[2],inputData[3],Double.parseDouble(inputData[4]));
                    personInfo.get(nameOfPerson).setCompany(company);
                    break;
                case "pokemon":
                    Pokemon pokemon = new Pokemon(inputData[2],inputData[3]);
                    personInfo.get(nameOfPerson).getPokemonList().add(pokemon);
                    break;
                case "parents":
                    Parent parent = new Parent(inputData[2],inputData[3]);
                    personInfo.get(nameOfPerson).getParentList().add(parent);
                    break;
                case "children":
                    Children children = new Children(inputData[2],inputData[3]);
                    personInfo.get(nameOfPerson).getChildrenList().add(children);
                    break;
                case "car":
                    Car car = new Car(inputData[2],Integer.parseInt(inputData[3]));
                    personInfo.get(nameOfPerson).setCar(car);
                    break;
            }
        }
        personInfo.get(scan.nextLine()).printFormat();
    }
}