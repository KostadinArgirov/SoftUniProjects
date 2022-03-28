import java.util.Scanner;

public class P05EasterEggs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int paintedEggs = Integer.parseInt(scanner.nextLine());

        int redCounter = 0;
        int orangeCounter = 0;
        int blueCounter = 0;
        int greenCounter = 0;
        String maxColour = "";
        int maxEggs = 0;

        for (int i = 0; i < paintedEggs; i++) {
            String colour = scanner.nextLine();

            switch (colour) {
                case "red":
                    redCounter++;
                    break;
                case "orange":
                    orangeCounter++;
                    break;
                case "blue":
                    blueCounter++;
                    break;
                case "green":
                    greenCounter++;
                    break;
            }
        }
        if (redCounter > orangeCounter && redCounter > blueCounter && redCounter > greenCounter) {
            maxColour = "red";
            maxEggs = redCounter;
        } else if (orangeCounter > redCounter && orangeCounter > blueCounter && orangeCounter > greenCounter) {
            maxColour = "orange";
            maxEggs = orangeCounter;
        } else if (blueCounter > redCounter && blueCounter > orangeCounter && blueCounter > greenCounter) {
            maxColour = "blue";
            maxEggs = blueCounter;
        } else {
            maxColour = "green";
            maxEggs = greenCounter;
        }
        System.out.printf("Red eggs: %d\n" +
                "Orange eggs: %d\n" +
                "Blue eggs: %d\n" +
                "Green eggs: %d\n" +
                "Max eggs: %d -> %s", redCounter, orangeCounter, blueCounter, greenCounter, maxEggs, maxColour);
    }
}