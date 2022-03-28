import java.util.Scanner;

public class P08PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);


        double x1 = Double.parseDouble(console.nextLine());
        double y1 = Double.parseDouble(console.nextLine());
        double x2 = Double.parseDouble(console.nextLine());
        double y2 = Double.parseDouble(console.nextLine());
        double x = Double.parseDouble(console.nextLine());
        double y = Double.parseDouble(console.nextLine());

        boolean firstCondition = ((x == x1 || x == x2) && (y >= y1 && y <= y2));
        boolean secondCondition = ((y == y1 || y == y2) && (x >= x1 && x <= x2));

        if (firstCondition == true || secondCondition == true) {
            System.out.println("Border");
        } else {
            System.out.println("Inside / Outside");
        }


    }
}
