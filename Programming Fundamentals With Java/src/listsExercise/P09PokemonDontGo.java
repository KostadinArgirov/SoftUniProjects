package listsExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Дава Runtime Error в Judge 70/100
//        List<Integer> distance = Arrays
//                .stream(scanner.nextLine().split("\\s+"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//
//        int sum = 0;
//
//        while (!distance.isEmpty()) {
//            int index = Integer.parseInt(scanner.nextLine());
//
//            if (index >= 0 && index <= distance.size() - 1) {
//                int element = distance.get(index);
//                sum += element;
//                distance.remove(index);
//                changeListContent(distance, element);
//            } else if (index < 0) {
//                int element = distance.get(index);
//                sum += element;
//                distance.set(0, distance.get(distance.size()-1));
//                changeListContent(distance, element);
//            } else {
//                int element = distance.get(distance.size()-1);
//                sum += element;
//                distance.set((distance.size()-1), distance.get(0));
//                changeListContent(distance, element);
//            }
//        }
//        System.out.println(sum);
//    }
//
//    static void changeListContent(List<Integer> numbersList, int element) {
//        for (int i = 0; i < numbersList.size(); i++) {
//            if (numbersList.get(i) <= element){
//                numbersList.set(i, numbersList.get(i) + element);
//            } else {
//                numbersList.set(i, numbersList.get(i) - element);
//            }
//        }
//    }
//}

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> temp = new ArrayList<>();

        int sum = 0;
        while (numbers.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index == 0 && numbers.size() == 1) {
                sum += numbers.get(0);
                numbers.remove(0);
                break;
            }
            if (index < 0) {
                int keyNumIndex = numbers.get(0);
                sum += keyNumIndex;

                numbers.remove(0);
                numbers.add(0, numbers.get(numbers.size() - 1));

                for (int j = 0; j < numbers.size(); j++) {
                    if (keyNumIndex >= numbers.get(j)) {
                        numbers.set(j, numbers.get(j) + keyNumIndex);
                    } else {
                        numbers.set(j, numbers.get(j) - keyNumIndex);
                    }
                }

            }
            if (index >= numbers.size()) {
                int keyNumIndex = numbers.get(numbers.size() - 1);
                sum += keyNumIndex;

                numbers.remove(numbers.size() - 1);
                numbers.add(numbers.get(0));

                for (int j = 0; j < numbers.size(); j++) {
                    if (keyNumIndex >= numbers.get(j)) {
                        numbers.set(j, numbers.get(j) + keyNumIndex);
                    } else {
                        numbers.set(j, numbers.get(j) - keyNumIndex);
                    }
                }

            }
            if (index >= 0 && index < numbers.size()) {
                int keyNumIndex = numbers.get(index);
                sum += keyNumIndex;

                for (int j = 0; j < numbers.size(); j++) {
                    if (keyNumIndex >= numbers.get(j)) {
                        numbers.set(j, numbers.get(j) + keyNumIndex);
                    } else if (keyNumIndex < numbers.get(j)) {
                        numbers.set(j, numbers.get(j) - keyNumIndex);
                    }
                }
                numbers.remove(index);
            }
        }
        System.out.println(sum);
    }
}