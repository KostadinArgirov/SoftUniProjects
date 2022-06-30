package advanced.streamsFilesAndDirectoriesExercises;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class P12CreateZipArchive {
    public static void main(String[] args) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(
                new FileOutputStream("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/files.zip"));
        FileInputStream fis = new FileInputStream(
                new File("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt"));
        int byteContainter;
        zos.putNextEntry(new ZipEntry("inputOne.txt"));

        while ((byteContainter = fis.read()) != -1) {
            zos.write(byteContainter);
        }
        zos.closeEntry();
        zos.putNextEntry(new ZipEntry("inputTwo.txt"));
        fis = new FileInputStream(
                new File("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt"));
        while ((byteContainter = fis.read()) != -1) {
            zos.write(byteContainter);
        }
        zos.closeEntry();
        zos.putNextEntry(new ZipEntry("results.txt"));
        fis = new FileInputStream(
                new File("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/results.txt"));
        while ((byteContainter = fis.read()) != -1) {
            zos.write(byteContainter);
        }
        zos.closeEntry();
        zos.finish();
        zos.close();
    }
}