import java.util.Scanner;

public class P03EnergyBooster {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String setSize = scanner.nextLine();
        int setOrderAmount = Integer.parseInt(scanner.nextLine());
        double price = 0.0;
        String output = "";

        switch (fruit) {
            case "Watermelon":
                if (setSize.equals("big")) {
                    price = setOrderAmount * 143.50;
                    output = String.format("%.2f lv.", price);
                } else if (setSize.equals("small")) {
                    price = setOrderAmount * 112;
                    output = String.format("%.2f lv.", price);
                }
                break;
            case "Mango":
                if (setSize.equals("big")) {
                    price = setOrderAmount * 98;
                    output = String.format("%.2f lv.", price);
                } else if (setSize.equals("small")) {
                    price = setOrderAmount * 73.32;
                    output = String.format("%.2f lv.", price);
                }
                break;
            case "Pineapple":
                if (setSize.equals("big")) {
                    price = setOrderAmount * 124;
                    output = String.format("%.2f lv.", price);
                } else if (setSize.equals("small")) {
                    price = setOrderAmount * 84.2;
                    output = String.format("%.2f lv.", price);
                }
                break;
            case "Raspberry":
                if (setSize.equals("big")) {
                    price = setOrderAmount * 76;
                    output = String.format("%.2f lv.", price);
                } else if (setSize.equals("small")) {
                    price = setOrderAmount * 40;
                    output = String.format("%.2f lv.", price);
                }
            break;
        }
        if (price >=400 && price <= 1000) {
            price *= 0.85;
            output = String.format("%.2f lv.", price);
        } else if (price > 1000) {
            price *= 0.5;
            output = String.format("%.2f lv.", price);
        }
        System.out.println(output);
    }
}
