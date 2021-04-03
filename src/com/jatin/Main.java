package com.jatin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        double sales = checkVariable("Please enter salesperson's monthly sales", "Monthly Sales");
        double advance = checkVariable("Please enter the amount of advance pay", "Advance amount");
        SalesCommissionCalc calc = new SalesCommissionCalc(sales, advance);
        calc.calculateSalesCommission();
        calc.displayCommission();
    }

    public static double checkVariable(String selectMessage, String variable) {
        boolean isNum = false;
        double val = 0.0;
        while(!isNum) {
            try {
                String input = JOptionPane.showInputDialog(selectMessage);
                val = Double.parseDouble(input);
                if(val <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid input. " + variable
                            + " value must be greater than 0");
                    continue;
                }
                isNum = true;
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. " + variable
                        + " must be number");
            }
        }
        return val;
    }

}
