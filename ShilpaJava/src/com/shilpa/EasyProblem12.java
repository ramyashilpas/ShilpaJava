package com.shilpa;

import javax.print.DocFlavor;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.*;
import java.util.spi.CurrencyNameProvider;
import java.util.spi.LocaleNameProvider;

public class EasyProblem12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        Locale indiaLocale=new Locale("en","IN");
        /* Better way of solving the given problem
         List<Locale> countries = Arrays.asList(Locale.US,indiaLocale,Locale.CHINA, Locale.FRANCE);

        countries.forEach(country -> {
            System.out.println(Currency.getInstance(country).getSymbol()+""+payment);
        });*/
        NumberFormat us     = NumberFormat.getCurrencyInstance(Locale.US);
        NumberFormat india  = NumberFormat.getCurrencyInstance(indiaLocale);
        NumberFormat china  = NumberFormat.getCurrencyInstance(Locale.CHINA);
        NumberFormat france = NumberFormat.getCurrencyInstance(Locale.FRANCE);
       // payment=Double.parseDouble(String.format("%.2f", payment));
        System.out.println("US: " + us.format(payment));
        System.out.println("India: " + india.format(payment));
        System.out.println("China: " + china.format(payment));
        System.out.println( "France: " +france.format(payment));

    }
}
