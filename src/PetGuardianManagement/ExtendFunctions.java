/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PetGuardianManagement;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author ductt
 */
public class ExtendFunctions {

    public static String CurrencyFormat(long amount) {
        Locale locale = new Locale("vi", "VN"); // Locale for Vietnamese
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount);
    }
}
