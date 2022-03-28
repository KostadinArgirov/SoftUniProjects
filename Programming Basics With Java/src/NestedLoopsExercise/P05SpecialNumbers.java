import java.util.Scanner;

public class P05SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

//        for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {
//            if (N % firstDigit != 0) {
//                continue;
//            }
//            for (int secondDigit = 1; secondDigit <= 9; secondDigit++) {
//                if (N % secondDigit != 0) {
//                    continue;
//                }
//                for (int thirdDigit = 1; thirdDigit <= 9; thirdDigit++) {
//                    if (N % thirdDigit != 0) {
//                        continue;
//                    }
//                    for (int fourthDigit = 1; fourthDigit <= 9; fourthDigit++) {
//                        if (N % fourthDigit != 0) {
//                            continue;
//                        }
//                        System.out.printf("%d%d%d%d ", firstDigit, secondDigit, thirdDigit, fourthDigit);
//
//                    }
//                }
//            }
//        }
//    }
//}


        for (int firstDigit = 1; firstDigit <= 9; firstDigit++) {
            for (int secondDigit = 1; secondDigit <= 9; secondDigit++) {
                for (int thirdDigit = 1; thirdDigit <= 9; thirdDigit++) {
                    for (int fourthDigit = 1; fourthDigit <= 9; fourthDigit++) {
                        if (N % firstDigit == 0 && N % secondDigit == 0 && N % thirdDigit == 0 && N % fourthDigit == 0) {
                            System.out.printf("%d%d%d%d ", firstDigit, secondDigit, thirdDigit, fourthDigit);
                        }
                    }
                }
            }
        }
    }
}