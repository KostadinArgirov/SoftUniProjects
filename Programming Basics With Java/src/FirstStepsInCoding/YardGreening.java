import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Цената на един кв. м. е 7.61 лв със ДДС. Фирмата изпълнител предлага 18% отстъпка от крайната цена.
        // От конзолата се въвежда само 1 ред: колко кв. м. в реално число
        // На конзолата се отпечатват два реда:
        //
        //"The final price is: {крайна цена на услугата} lv."
        //
        //"The discount is: {отстъпка} lv."

        double priceForSqM = 7.61;
        double numberSqM = Double.parseDouble(scanner.nextLine());
        double finalSum = priceForSqM * numberSqM;
        double discount = finalSum * 0.18;
        double finalSumWithDiscount = finalSum - discount;

        System.out.println("The final price is: " + finalSumWithDiscount + " lv.");
        System.out.println("The discount is: " + discount + " lv.");

    }
}
