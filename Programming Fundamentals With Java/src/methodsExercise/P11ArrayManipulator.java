package methodsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int[] arr = Arrays
//                .stream(scanner.nextLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//        String line = scanner.nextLine();
//
//        while (!"end".equals(line)) {
//            String[] data = line.split(" ");
//            String command = data[0];
//
//            switch (command) {
//                case "exchange":
//                    int index = Integer.parseInt(data[1]);
//                    if (isValidIndex(index, arr.length)) {
//                        exchange(arr, index);
//                    } else {
//                        System.out.println("Invalid index");
//                    }
//                    break;
//                case "max":
//                    if (data[1].equals("even")) {
//                        printEvenMax(arr);
//                    } else {
//                        printOddMax(arr);
//                    }
//                    break;
//                case "min":
//                    if (data[1].equals("even")) {
//                        printEvenMin(arr);
//                    } else {
//                        printOddMin(arr);
//                    }
//                    break;
//                case "first":
//                    int count = Integer.parseInt(data[1]);
//                    if (count > arr.length) {
//                        System.out.println("Invalid count");
//                    } else {
//                        if (data[2].equals("even")) {
//                            printFirstEven(arr, count);
//                        } else {
//                            printFirstOdd(arr, count);
//                        }
//                    }
//                    break;
//                case "last":
//                    count = Integer.parseInt(data[1]);
//                    if (count > arr.length) {
//                        System.out.println("Invalid count");
//                    } else {
//                        if (data[2].equals("even")) {
//                            printLastEven(arr, count);
//                        } else {
//                            printLastOdd(arr, count);
//                        }
//                    }
//                    break;
//
//            }
//
//
//            line = scanner.nextLine();
//        }
//        System.out.println(Arrays.toString(arr));
//    }
//
//    private static void printLastOdd(int[] array, int count) {
//        int[] bufferArr = new int[array.length];
//        for (int i = array.length - 1; i >= 0; i--) {
//            if (array[i] % 2 != 0 && count > 0) {
//                bufferArr[i] = array[i];
//                count--;
//            } else {
//                bufferArr[i] = -1;
//            }
//        }
//        printArr(bufferArr);
//    }
//
//    private static void printLastEven(int[] array, int count) {
//        int[] bufferArr = new int[array.length];
//        for (int i = array.length - 1; i >= 0; i--) {
//            if (array[i] % 2 == 0 && count > 0) {
//                bufferArr[i] = array[i];
//                count--;
//            } else {
//                bufferArr[i] = -1;
//            }
//        }
//        printArr(bufferArr);
//    }
//
//    private static void printFirstOdd(int[] array, int count) {
//        int[] bufferArr = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 != 0 && count > 0) {
//                bufferArr[i] = array[i];
//                count--;
//            } else {
//                bufferArr[i] = -1;
//            }
//        }
//        printArr(bufferArr);
//    }
//
//    private static void printFirstEven(int[] array, int count) {
//        int[] bufferArr = new int[array.length];
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] % 2 == 0 && count > 0) {
//                bufferArr[i] = array[i];
//                count--;
//            } else {
//                bufferArr[i] = -1;
//            }
//        }
//        printArr(bufferArr);
//    }
//
//    private static void printOddMax(int[] array) {
//        int maxNumber = Integer.MIN_VALUE;
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (maxNumber <= array[i] && array[i] % 2 == 0) {
//                maxNumber = array[i];
//                index = i;
//            }
//        }
//        if (index == -1) {
//            System.out.println("No matches");
//        } else {
//            System.out.println(index);
//        }
//    }
//
//    private static void printEvenMin(int[] array) {
//        int minNumber = Integer.MAX_VALUE;
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (minNumber >= array[i] && array[i] % 2 == 0) {
//                minNumber = array[i];
//                index = i;
//            }
//        }
//        if (index == -1) {
//            System.out.println("No matches");
//        } else {
//            System.out.println(index);
//        }
//    }
//
//    private static void printOddMin(int[] array) {
//        int minNumber = Integer.MAX_VALUE;
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (minNumber >= array[i] && array[i] % 2 != 0) {
//                minNumber = array[i];
//                index = i;
//            }
//        }
//        if (index == -1) {
//            System.out.println("No matches");
//        } else {
//            System.out.println(index);
//        }
//    }
//
//    private static void printEvenMax(int[] array) {
//        int maxNumber = Integer.MIN_VALUE;
//        int index = -1;
//        for (int i = 0; i < array.length; i++) {
//            if (maxNumber <= array[i] && array[i] % 2 == 0) {
//                maxNumber = array[i];
//                index = i;
//            }
//        }
//        if (index == -1) {
//            System.out.println("No matches");
//        } else {
//            System.out.println(index);
//        }
//    }
//
//    public static boolean isValidIndex(int index, int length) {
//        return index >= 0 && index < length;
//    }
//
//    public static void exchange(int[] array, int index) {
//        int[] first = new int[index + 1];
//        int[] second = new int[array.length - index - 1];
//        for (int i = 0; i <= index; i++) {
//            first[i] = array[i];
//        }
//        for (int i = 0; i < second.length; i++) {
//            second[i] = array[index + 1 + i];
//        }
//        for (int i = 0; i < array.length; i++) {
//            // start filling from second array
//            if (i < second.length) {
//                array[i] = second[i];
//            } else {
//                // continue with first array
//                array[i] = first[i - second.length];
//            }
//        }
//    }
//
//    public static void printArr(int[] array) {
//        System.out.print("[");
//        boolean printFirst = true;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != -1) {
//                if (printFirst) {
//                    System.out.print(array[i]);
//                    printFirst = false;
//                } else {
//                    System.out.print(", " + array[i]);
//                }
//            }
//        }
//        System.out.println("]");
//    }
//}

        String[] inputAsArray = scanner.nextLine().split("\\s+");
        String command = scanner.nextLine();

        while (!"end".equals(command)) {
            String[] tokens = command.split("\\s+");

            if (tokens[0].equals("exchange")) {
                inputAsArray = getNewArray(inputAsArray, tokens[1]);
            } else if (tokens[0].equals("max")) {
                if (tokens[1].equals("even")) {
                    getMaxEven(inputAsArray);
                } else {
                    getMaxOdd(inputAsArray);
                }
            } else if (tokens[0].equals("min")) {
                if (tokens[1].equals("even")) {
                    getMinEven(inputAsArray);
                } else {
                    getMinOdd(inputAsArray);
                }
            } else if (tokens[0].equals("first")) {
                if (tokens[2].equals("even")) {
                    findFirstEven(inputAsArray, tokens[1]);
                } else {
                    findFirstOdd(inputAsArray, tokens[1]);
                }
            } else if (tokens[0].equals("last")) {
                if (tokens[2].equals("even")) {
                    findLastEven(inputAsArray, tokens[1]);
                } else {
                    findLastOdd(inputAsArray, tokens[1]);
                }
            }
            command = scanner.nextLine();
        }
        System.out.print("[");
        for (int i = 0; i <= inputAsArray.length - 1; i++) {
            if (i == inputAsArray.length - 1) {
                System.out.print(inputAsArray[i]);
            } else {
                System.out.print(inputAsArray[i] + ", ");
            }
        }
        System.out.println("]");
    }


    private static void findLastOdd(String[] inputAsArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount > inputAsArray.length) {
            System.out.println("Invalid count");
        } else {
            int countEven = 0;
            for (int i = 0; i <= inputAsArray.length - 1; i++) {
                if (Integer.parseInt(inputAsArray[i]) % 2 != 0) {
                    countEven++;
                }
            }
            int[] array = new int[Math.min(countEven, neededCount)];
            if (array.length > 0) {
                int index = 0;
                for (int i = inputAsArray.length - 1; i >= 0; i--) {
                    if (Integer.parseInt(inputAsArray[i]) % 2 != 0) {
                        array[index] = Integer.parseInt(inputAsArray[i]);
                        index++;
                        if (index > array.length - 1) {
                            break;
                        }
                    }
                }
                int[] reversedArray = new int[array.length];
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    reversedArray[i] = array[array.length - (i + 1)];
                }

                System.out.print("[");
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    if (i == reversedArray.length - 1) {
                        System.out.print(reversedArray[i]);
                    } else {
                        System.out.print(reversedArray[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }


    private static void findLastEven(String[] inputAsArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount > inputAsArray.length) {
            System.out.println("Invalid count");
        } else {
            int countEven = 0;
            for (int i = 0; i <= inputAsArray.length - 1; i++) {
                if (Integer.parseInt(inputAsArray[i]) % 2 == 0) {
                    countEven++;
                }
            }
            int[] array = new int[Math.min(countEven, neededCount)];
            if (array.length > 0) {
                int index = 0;
                for (int i = inputAsArray.length - 1; i >= 0; i--) {
                    if (Integer.parseInt(inputAsArray[i]) % 2 == 0) {
                        array[index] = Integer.parseInt(inputAsArray[i]);
                        index++;
                        if (index > array.length - 1) {
                            break;
                        }
                    }
                }
                int[] reversedArray = new int[array.length];
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    reversedArray[i] = array[array.length - (i + 1)];
                }

                System.out.print("[");
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    if (i == reversedArray.length - 1) {
                        System.out.print(reversedArray[i]);
                    } else {
                        System.out.print(reversedArray[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }


    private static void findFirstOdd(String[] inputAsArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount > inputAsArray.length) {
            System.out.println("Invalid count");
        } else {
            int countOdd = 0;
            for (int i = 0; i <= inputAsArray.length - 1; i++) {
                if (Integer.parseInt(inputAsArray[i]) % 2 != 0) {
                    countOdd++;
                }
            }
            int[] array = new int[Math.min(countOdd, neededCount)];
            if (array.length > 0) {
                int index = 0;
                for (int i = 0; i <= inputAsArray.length - 1; i++) {
                    if (Integer.parseInt(inputAsArray[i]) % 2 != 0) {
                        array[index] = Integer.parseInt(inputAsArray[i]);
                        index++;
                        if (index > array.length - 1) {
                            break;
                        }
                    }
                }
                System.out.print("[");
                for (int i = 0; i <= array.length - 1; i++) {
                    if (i == array.length - 1) {
                        System.out.print(array[i]);
                    } else {
                        System.out.print(array[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }


    private static void findFirstEven(String[] inputAsArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount > inputAsArray.length) {
            System.out.println("Invalid count");
        } else {
            int countEven = 0;
            for (int i = 0; i <= inputAsArray.length - 1; i++) {
                if (Integer.parseInt(inputAsArray[i]) % 2 == 0) {
                    countEven++;
                }
            }
            int[] array = new int[Math.min(countEven, neededCount)];
            if (array.length > 0) {
                int index = 0;
                for (int i = 0; i <= inputAsArray.length - 1; i++) {
                    if (Integer.parseInt(inputAsArray[i]) % 2 == 0) {
                        array[index] = Integer.parseInt(inputAsArray[i]);
                        index++;
                        if (index > array.length - 1) {
                            break;
                        }
                    }
                }
                System.out.print("[");
                for (int i = 0; i <= array.length - 1; i++) {
                    if (i == array.length - 1) {
                        System.out.print(array[i]);
                    } else {
                        System.out.print(array[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }

    private static void getMinOdd(String[] inputAsArray) {
        int minElement = Integer.MAX_VALUE;
        int indexOfMinElement = -1;
        for (int i = 0; i <= inputAsArray.length - 1; i++) {
            if (Integer.parseInt(inputAsArray[i]) % 2 != 0) {
                if (Integer.parseInt(inputAsArray[i]) <= minElement) {
                    minElement = Integer.parseInt(inputAsArray[i]);
                    indexOfMinElement = i;
                }
            }
        }
        if (indexOfMinElement > -1) {
            System.out.println(indexOfMinElement);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getMinEven(String[] inputAsArray) {
        int minElement = Integer.MAX_VALUE;
        int indexOfMinElement = -1;
        for (int i = 0; i <= inputAsArray.length - 1; i++) {
            if (Integer.parseInt(inputAsArray[i]) % 2 == 0) {
                if (Integer.parseInt(inputAsArray[i]) <= minElement) {
                    minElement = Integer.parseInt(inputAsArray[i]);
                    indexOfMinElement = i;
                }
            }
        }
        if (indexOfMinElement > -1) {
            System.out.println(indexOfMinElement);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getMaxEven(String[] inputAsArray) {
        int maxElement = Integer.MIN_VALUE;
        int indexOfMaxElement = -1;
        for (int i = 0; i <= inputAsArray.length - 1; i++) {
            if (Integer.parseInt(inputAsArray[i]) % 2 == 0) {
                if (Integer.parseInt(inputAsArray[i]) >= maxElement) {
                    maxElement = Integer.parseInt(inputAsArray[i]);
                    indexOfMaxElement = i;
                }
            }
        }
        if (indexOfMaxElement > -1) {
            System.out.println(indexOfMaxElement);
        } else {
            System.out.println("No matches");
        }
    }

    private static void getMaxOdd(String[] inputAsArray) {
        int maxElement = Integer.MIN_VALUE;
        int indexOfMaxElement = -1;
        for (int i = 0; i <= inputAsArray.length - 1; i++) {
            if (Integer.parseInt(inputAsArray[i]) % 2 != 0) {
                if (Integer.parseInt(inputAsArray[i]) >= maxElement) {
                    maxElement = Integer.parseInt(inputAsArray[i]);
                    indexOfMaxElement = i;
                }
            }
        }
        if (indexOfMaxElement > -1) {
            System.out.println(indexOfMaxElement);
        } else {
            System.out.println("No matches");
        }
    }


    private static String[] getNewArray(String[] inputAsArray, String token) {
        int index = Integer.parseInt(token);
        String[] newArray = new String[inputAsArray.length];
        if (index < 0 || index >= inputAsArray.length) {
            System.out.println("Invalid index");
            return inputAsArray;
        } else {
            int x = 0;
            for (int newStart = index + 1; newStart < inputAsArray.length; newStart++) {
                newArray[x] = inputAsArray[newStart];
                x++;
            }
            for (int newEnd = 0; newEnd <= index; newEnd++) {
                newArray[x] = inputAsArray[newEnd];
                x++;
            }

        }
        return newArray;
    }
}