package arraysMoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] listLengths = new int[numbers.length];
        int[] lisPrev = new int[numbers.length];

        for (int i = 0; i < listLengths.length; i++) {
            listLengths[i] = 1;
            lisPrev[i] = -1;
        }
        for (int currentIndex = 1; currentIndex < numbers.length; currentIndex++) {
            for (int prevIndex = 0; prevIndex < currentIndex; prevIndex++) {
                if (numbers[prevIndex] < numbers[currentIndex]) {
                    int candidateLength = listLengths[prevIndex] + 1;
                    if (candidateLength > listLengths[currentIndex]) {
                        listLengths[currentIndex] = candidateLength;
                        lisPrev[currentIndex] = prevIndex;
                    }
                }
            }
        }
        for (int listLength : listLengths) {
            System.out.print(listLength + " ");
        }
        System.out.println();

        int maxLength = 0;
        int maxLengthIndex = -1;

        for (int i = 0; i < listLengths.length; i++) {
            if (listLengths[i] > maxLength) {
                maxLength = listLengths[i];
                maxLengthIndex = i;
            }
        }
        int index = maxLengthIndex;
        int[] lis = new int[maxLength];
        int pos = 0;
        while (index != -1) {
            lis[pos] = numbers[index];
            pos++;
            System.out.print(numbers[index] + " ");
            index = lisPrev[index];
        }
    }
}