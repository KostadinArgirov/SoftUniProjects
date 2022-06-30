package advanced.streamsFilesAndDirectoriesLab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class P03CopyBytes {
    public static void main(String[] args) {
        String path = "D:\\Argirov\\SoftUni\\Java Advanced May 2022\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("03CopyBytesOutput.txt");

            int read = fileInputStream.read();

            PrintWriter writer = new PrintWriter(fileOutputStream);

            while (read != -1) {

                if (read == ' ') {
                    writer.print(' ');
                } else if(read == 10) {
                    writer.println();
                } else {
                    writer.print(read);
                }

                read = fileInputStream.read();
            }
            writer.close();
        } catch (IOException ignored) {
        }
    }
}