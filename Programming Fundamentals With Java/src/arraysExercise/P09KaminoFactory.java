package arraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P09KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int dnaLength = Integer.parseInt(scanner.nextLine());
//
//        String input = scanner.nextLine();
//
//        int lineCount = 0;
//        int bestStartIndex = Integer.MAX_VALUE;
//        int[] bestLine = new int[dnaLength];
//        int bestLineNum = 0;
//        int bestOnes = 0;
//        int bestSum = 0;
//        int sum = 0;
//
//        while (!input.equals("Clone them!")) {
//            int[] currentLine = Arrays
//                    .stream(input.split("!+"))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
//
//            lineCount++; //ъпдейтваме номера на текущия ред
//            int longestOnesInARow = 0; //поредица 1-ци на текущия ред
//            int startIndex = Integer.MAX_VALUE;
//
//            for (int i = 0; i < currentLine.length; i++) {
//                int onesInARow = 0;
//                for (int j = i; j < currentLine.length; j++) {
//                    if (currentLine[i] == currentLine[j] && currentLine[i] == 1) {
//                        onesInARow++;
//                        if (onesInARow > longestOnesInARow) {
//                            longestOnesInARow = onesInARow;
//                            startIndex = i; //индекса на 1-ците на текщия ред
//                        }
//                    } else {
//                        break;
//                    }
//                }
//            }
//            if (longestOnesInARow > bestOnes) {
//                bestOnes = longestOnesInARow; //ъпдейтваме най-добрата последователност от 1-ци от всички редове до момента
//                bestLine = currentLine;
//                bestLineNum = lineCount;
//                bestStartIndex = startIndex; //най-добрия индекс 1-ци
//            } else if (longestOnesInARow == bestOnes) {
//                if (startIndex < bestStartIndex) {
//                    bestLine = currentLine;
//                    bestLineNum = lineCount;
//                    bestStartIndex = startIndex;
//                } else if (startIndex == bestStartIndex) { //при равни посл. 1-ци и индекси проверяваме сумите на текущия и най-добрия до момента ред
//                    for (int i = 0; i < bestLine.length; i++) {
//                        bestSum += bestLine[i];
//                    }
//                    for (int i = 0; i < currentLine.length; i++) {
//                        sum += currentLine[i];
//                    }
//                    if (sum > bestSum) {
//                        bestLine = currentLine;
//                        bestLineNum = lineCount;
//                        bestSum = sum;
//                    }
//                }
//            }
//            input = scanner.nextLine();
//        }
//        bestSum = 0; // да се избегне евентуален ред с по-голяма сума, но по-лоша последователност
//        for (int i = 0; i < bestLine.length; i++) {
//            bestSum += bestLine[i];
//        }
//        // проверка за само нулеви редове
//        if (bestSum == 0) {
//            bestLineNum = 1;
//        }
//        System.out.println(String.format("Best DNA sample %d with sum: %d.", bestLineNum, bestSum));
//        for (int i = 0; i < bestLine.length; i++) {
//            System.out.print(bestLine[i] + " ");
//        }
//    }
//}


        int size = Integer.parseInt(scanner.nextLine());

        String input = "";
        int bestSequenceIndex = Integer.MAX_VALUE;
        int bestSequenceSum = 0;
        int bestIndexInARow = 0;
        int bestIndexInARowOutput = 0;
        String sequenceOutput = "";

        while (!"Clone them!".equals(input = scanner.nextLine())) {
            ++bestIndexInARow;

            String[] data = input.split("!+");

            int[] sequenceDNA = new int[size];

            for (int i = 0; i < data.length; i++) {
                sequenceDNA[i] = Integer.parseInt(data[i]);
            }
            int maxCount = 0;
            int sequenceIndex = 0;
            for (int i = 0; i < sequenceDNA.length; i++) {
                int currentCount = 0;
                for (int j = i; j < sequenceDNA.length; j++) {
                    if (sequenceDNA[i] == sequenceDNA[j]) {
                        currentCount++;
                        if (currentCount > maxCount) {
                            maxCount = currentCount;
                            sequenceIndex = i;
                        }
                    } else {
                        break;
                    }
                }
            }
            int sequenceSum = 0;
            for (int i = 0; i < sequenceDNA.length; i++) {

                if (sequenceDNA[i] == 1) {
                    sequenceSum += sequenceDNA[i];
                }
            }
            if (sequenceIndex < bestSequenceIndex || sequenceSum > bestSequenceSum) {
                sequenceOutput = "";
                bestSequenceIndex = sequenceIndex;
                bestSequenceSum = sequenceSum;
                bestIndexInARowOutput = bestIndexInARow;

                for (int i = 0; i < sequenceDNA.length; i++) {
                    sequenceOutput += sequenceDNA[i] + " ";
                }
            }
        }
        System.out.println(String.format("Best DNA sample %d with sum: %d.", bestIndexInARowOutput, bestSequenceSum));
        System.out.println(sequenceOutput.trim());
    }
}