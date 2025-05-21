package day3;
import java.text.*;
import java.util.*;

public class CurrencyFormatter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        String usFormatted = usFormat.format(payment);
        System.out.println("US: " + usFormatted);

        // India
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        String indiaFormatted = indiaFormat.format(payment);
        System.out.println("India: " + indiaFormatted);

        // China
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String chinaFormatted = chinaFormat.format(payment);
        System.out.println("China: " + chinaFormatted);

        // France
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String franceFormatted = franceFormat.format(payment);
        System.out.println("France: " + franceFormatted);
        
    }
}