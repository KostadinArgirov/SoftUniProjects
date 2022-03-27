package listsMoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class P04MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOne = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> listTwo = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> remaingList = new ArrayList<>();

        if (listOne.size() > listTwo.size()) {
            remaingList.add(listOne.get(listOne.size() - 1));
            remaingList.add(listOne.get(listOne.size() - 2));
            listOne.remove(listOne.size() - 1);
            listOne.remove(listOne.size() - 1);
        } else {
            remaingList.add(listTwo.get(0));
            remaingList.add(listTwo.get(1));
            listTwo.remove(0);
            listTwo.remove(0);
        }

        Collections.reverse(listTwo);
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < listOne.size(); i++) {
            output.add(listOne.get(i));
            output.add(listTwo.get(i));
        }

        Collections.reverse(Arrays.asList(remaingList));
        Collections.reverse(Arrays.asList(output));



//        output.removeAll(x = > x <= remaingList.get(0));
//        output.removeAll(x = > x >= remaingList.get(1));

//        Console.WriteLine(string.Join(" ", output));
// не е довършена
    }
}