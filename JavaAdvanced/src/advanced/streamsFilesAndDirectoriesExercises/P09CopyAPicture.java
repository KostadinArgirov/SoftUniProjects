package advanced.streamsFilesAndDirectoriesExercises;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class P09CopyAPicture {
    public static void main(String[] args) {

        byte[] buffer = new byte[1024];
        try(FileInputStream fis = new FileInputStream("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/image.png");
            FileOutputStream fos = new FileOutputStream("src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/copyImage.png")) {

            while (fis.read(buffer) != -1) {

                fos.write(buffer);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}