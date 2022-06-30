package advanced.streamsFilesAndDirectoriesExercises;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class P10SerializeArrayList {
    public static void main(String[] args) {

        String path = "src/streamsFilesAndDirectoriesExercises/04. Java-Advanced-Files-and-Streams-Exercises-Resources/list.ser";

        List<String> bikes = new ArrayList<>();

        bikes.add("GSXR1000");
        bikes.add("R1");
        bikes.add("CBR1000R");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            oos.writeObject(bikes);
            Object listFromFile = ois.readObject();
            System.out.println(listFromFile);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}