package setsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests = new TreeSet<>();


        String reservationNumber = scanner.nextLine();


        while (!reservationNumber.equals("PARTY")) {

            guests.add(reservationNumber);

            reservationNumber = scanner.nextLine();
        }

        String guestArriving = scanner.nextLine();

        while (!guestArriving.equals("END")) {
            guests.remove(guestArriving);

            guestArriving = scanner.nextLine();
        }
        System.out.println(guests.size());

        System.out.println(String.join(System.lineSeparator(), guests));
    }
}