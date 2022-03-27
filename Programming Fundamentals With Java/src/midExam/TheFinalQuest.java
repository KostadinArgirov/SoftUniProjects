package midExam;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TheFinalQuest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> myList = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());

        while (true) {
            String input = scan.nextLine();
            if (input.equals("Stop"))
                break;

            String[] tokens = input.split("\\s+");

            switch (tokens[0]) {
                case "Delete":
                    int index = Integer.parseInt(tokens[1] ) + 1;
                    if (index >= 0 && index <= myList.size())
                        myList.remove(index);
                    break;
                case "Swap":
                    String w1 = tokens[1];
                    String w2 = tokens[2];
                    int index1= myList.indexOf(w1);
                    int index2 = myList.indexOf(w2);
                    if (index1 >= 0 && index2 >= 0){
                        String temp = myList.get(index1);
                        myList.set(index1, w2);
                        myList.set(index2, temp);
                    }
                    break;
                case "Put":
                    String toAdd = tokens[1];
                    index = Integer.parseInt(tokens[2]) - 1;
                    if (index >= 0 && index <= myList.size()){
                        myList.add(index, toAdd);
                    }
                    break;
                case "Sort":
                    Collections.sort(myList);
                    Collections.reverse(myList);
                    break;
                case "Replace":
                    String word1 = tokens[1];
                    String word2 = tokens[2];
                    int myIndex = myList.indexOf(word2);
                    if (myIndex > -1)
                        myList.set(myIndex, word1);
                    break;
            }
        }
        for ( String a : myList) {
            System.out.print(a + " ");
        }
    }
}