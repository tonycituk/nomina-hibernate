/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lemur.nomina.MVC.View.Util;

import java.util.regex.Pattern;

/**
 *
 * @author tonyc
 */
public class InputValidator {

    public InputValidator() {
    }

    public boolean isValidInt(String i) {
        try {
            Integer.parseInt(i);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Integer.");
        }
        return false;
    }

    public boolean isValidNumeric(String d) {
        try {
            Double.parseDouble(d);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Input String cannot be parsed to Double.");
        }
        return false;
    }

    public boolean isValidNoSQL(String NoSQL) {
        System.out.println(Pattern.matches("[a-zA-Z\\s]{1,50}", NoSQL));
        return Pattern.matches("[a-zA-Z\\s]{1,50}", NoSQL);
    }

    public static void main(String[] args) {
        InputValidator iv = new InputValidator();
        iv.isValidNoSQL("x");
    }
}
