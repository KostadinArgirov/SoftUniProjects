import java.util.Scanner;

public class P06Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int floorsN = Integer.parseInt(scanner.nextLine());
        int roomsN = Integer.parseInt(scanner.nextLine());

        for (int floor = floorsN; floor > 0; floor--) {
            String floorString = "";
            for (int room = 0; room < roomsN; room++) {
                if (floor == floorsN) {
                    floorString += "L" + floor + room + " ";
                } else if (floor % 2 == 0) {
                    floorString += "O" + floor + room + " ";
                } else {
                    floorString += "A" + floor + room + " ";
                }
            }
            System.out.println(floorString);
        }
    }
}