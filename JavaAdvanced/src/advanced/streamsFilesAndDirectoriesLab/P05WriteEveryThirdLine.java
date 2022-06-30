package advanced.streamsFilesAndDirectoriesLab;

import java.io.*;

public class P05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Argirov\\SoftUni\\Java Advanced May 2022\\Resources\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));

        BufferedWriter writer = new BufferedWriter(new FileWriter("05WriteEveryThirdLineOutput.txt"));

        String line = reader.readLine();

        int counter = 0;

        while (line != null) {

            counter++;

            if (counter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }

            line = reader.readLine();
        }
        reader.close();
        writer.close();
    }
}