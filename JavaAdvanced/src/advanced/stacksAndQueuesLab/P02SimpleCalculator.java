package advanced.stacksAndQueuesLab;

import java.util.*;

public class P02SimpleCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> calculation = new ArrayDeque<>();
        Collections.addAll(calculation, input);
        while (calculation.size()>1){
            sum(calculation.pop(), calculation.pop(), calculation.pop(), calculation);
        }
        System.out.println(calculation.peek());
    }

    private static void sum(String pop, String pop1, String pop2, ArrayDeque<String> calculation) {
        if("+".equals(pop1)) calculation.push(String.valueOf(Integer.parseInt(pop)+Integer.parseInt(pop2)));
        else calculation.push(String.valueOf(Integer.parseInt(pop)-Integer.parseInt(pop2)));
    }
}