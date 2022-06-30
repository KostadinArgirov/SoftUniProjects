package advanced.streamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class P02WriteToFile {
    public static void main(String[] args) {

        String path = "D:\\Argirov\\SoftUni\\Java Advanced May 2022\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("02WriteToFileOutput.txt");

            int read = fileInputStream.read();

            Set<Character> punctuations = Set.of(',', '.', '!', '?');

            while (read != -1) {

                if (!punctuations.contains((char) read)) {
                    fileOutputStream.write(read);
                }
                read = fileInputStream.read();
            }
        } catch (IOException ignored) {
        }
    }
}
