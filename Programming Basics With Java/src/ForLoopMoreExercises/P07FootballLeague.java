import java.util.Scanner;

public class P07FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scanner.nextLine());
        int fensAmount = Integer.parseInt(scanner.nextLine());

        int sectorAFans = 0;
        int sectorBFans = 0;
        int sectorVFans = 0;
        int sectorGFans = 0;

        for (int i = 0; i < fensAmount; i++) {
            String sector = scanner.nextLine();

            switch (sector) {
                case "A":
                    sectorAFans++;
                    break;
                case "B":
                    sectorBFans++;
                    break;
                case "V":
                    sectorVFans++;
                    break;
                case "G":
                    sectorGFans++;
                    break;
            }
        }
        System.out.printf("%.2f%%\n", (1.0 * sectorAFans / fensAmount) * 100);
        System.out.printf("%.2f%%\n", (1.0 * sectorBFans / fensAmount) * 100);
        System.out.printf("%.2f%%\n", (1.0 * sectorVFans / fensAmount) * 100);
        System.out.printf("%.2f%%\n", (1.0 * sectorGFans / fensAmount) * 100);
        System.out.printf("%.2f%%", (1.0 * fensAmount / stadiumCapacity) * 100);
    }
}
