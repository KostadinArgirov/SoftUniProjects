package advanced.streamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;

public class P07ListFiles {
    public static void main(String[] args) {

        File root = new File("D:\\Argirov\\SoftUni\\Java Advanced May 2022\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Arrays.stream(root.listFiles())
                .filter(File::isFile)
                .forEach(f -> System.out.println(f.getName() + ": " + "[" + f.length() + "]"));
    }
}