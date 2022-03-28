import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Пакет химикали - 5.80 лв.
        //Пакет маркери - 7.20 лв.
        //Препарат - 1.20 лв (за литър)

        int penPackage = Integer.parseInt(scanner.nextLine());
        int markerPackage = Integer.parseInt(scanner.nextLine());
        int boardCleaner = Integer.parseInt(scanner.nextLine());
        int discount = Integer.parseInt(scanner.nextLine());
        double totalWithoutDiscount = penPackage * 5.8 + markerPackage * 7.2 + boardCleaner * 1.2;
        double total = totalWithoutDiscount - (discount * 1.0 / 100) * totalWithoutDiscount;
        System.out.println(total);

    }
}
