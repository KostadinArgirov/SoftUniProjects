package listsLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<String> inputList = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String input = scanner.nextLine();
            inputList.add(i, input);
        }
        Collections.sort(inputList);

        for (int i = 0; i < inputList.size(); i++) {
            System.out.println(i + 1 + "." + inputList.get(i));
        }
    }
}