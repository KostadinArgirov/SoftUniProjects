package textProcessingExercise;

import java.util.Scanner;

public class P03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        String fileName = path.substring(path.lastIndexOf("\\") + 1, path.indexOf("."));
        String fileExtension = path.substring(path.indexOf(".") + 1);

                System.out.printf("File name: %s\n" +
                "File extension: %s\n", fileName, fileExtension);

    }
}


//        String[] filePath = scanner.nextLine().split("\\\\");
//
//        String pathEnd = filePath[filePath.length - 1];
//
//        String[] end = pathEnd.split("\\.");
//        String fileName = end[0];
//        String fileExtension = end[1];
//
//        System.out.printf("File name: %s\n" +
//                "File extension: %s\n", fileName, fileExtension);
//    }
//}