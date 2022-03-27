package midExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LastStop {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        List<Integer> paintingsList = new ArrayList<>();

        for (int i = 0; i < input.length ; i++) {
            paintingsList.add(Integer.parseInt(input[i]));
        }
        String instruction = scanner.next();

        while (!instruction.equals("END")){
            switch (instruction){
                case "Change": {
                    int paintingNum = scanner.nextInt();
                    int changedNum = scanner.nextInt();
                    change(paintingsList, paintingNum, changedNum);
                    break;
                }
                case "Hide": {
                    int paintingNum = scanner.nextInt();
                    hide(paintingsList, paintingNum);
                    break;
                }
                case "Switch": {
                    int paintingNum = scanner.nextInt();
                    int paintingNum2 = scanner.nextInt();
                    switchPaintings(paintingsList, paintingNum, paintingNum2);
                    break;
                }
                case "Insert": {
                    int indexToPlace = scanner.nextInt();
                    int paintingNum = scanner.nextInt();
                    insert(paintingsList, indexToPlace, paintingNum);
                    break;
                }
                case "Reverse": {
                    reverse(paintingsList);
                    break;
                }
            }
            instruction = scanner.next();
        }
        for (int i = 0; i < paintingsList.size(); i++) {
            System.out.print(paintingsList.get(i)+ " ");
        }
    }

    private static void reverse(List<Integer> paintingsList){
        Collections.reverse(paintingsList);
    }

    private static void insert(List<Integer> paintingsList, int indexToPlace, int paintingNum) {

        if (indexToPlace + 1 < paintingsList.size()){
            int indexOfPaintingNumber = paintingsList.indexOf(paintingNum);
            paintingsList.add(indexToPlace + 1, paintingNum);
        }
    }

    private static void switchPaintings(List<Integer> paintingsList, int paintingNum, int paintingNum2) {
        if (paintingsList.contains(paintingNum) && paintingsList.contains(paintingNum2)){
            int indexNum1 = paintingsList.indexOf(paintingNum);
            int indexNum2 = paintingsList.indexOf(paintingNum2);
            int num1Value = paintingsList.get(indexNum1);
            int num2Value = paintingsList.get(indexNum2);

            paintingsList.set(indexNum1, num2Value);
            paintingsList.set(indexNum2, num1Value);

        }
    }

    private static void hide(List<Integer> paintingsList, int paintingNum) {
        while (paintingsList.contains(paintingNum)){
            int index = paintingsList.indexOf(paintingNum);
            paintingsList.remove(index);

        }
    }

    private static void change(List<Integer> paintingsList, int paintingNum, int changedNum) {
        while (paintingsList.contains(paintingNum)){
            int index = paintingsList.indexOf(paintingNum);
            paintingsList.set(index, changedNum);
        }
    }
}