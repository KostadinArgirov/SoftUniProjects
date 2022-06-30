package advanced.streamsFilesAndDirectoriesLab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayDeque;

public class P08NestedFolders {
    public static void main(String[] args) throws FileNotFoundException {

        File root = new File("D:\\Argirov\\SoftUni\\Java Advanced May 2022\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        PrintStream out = new PrintStream("nestedFiles.txt");

        ArrayDeque<File> stack = new ArrayDeque<>();
        int counter = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            File current = stack.poll();
            if (current.isDirectory()) {
                out.println(current.getName());
                counter++;
                for (File file1 : current.listFiles()) {
                    stack.offer(file1);
                }
            }
        }
        out.printf("%d folders", counter);
    }
}