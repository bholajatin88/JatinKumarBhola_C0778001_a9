package com.jatin;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Check variable method to get valid values recursively from user
        double sales = checkVariable("Please enter salesperson's monthly sales", "Monthly Sales");
        double advance = checkVariable("Please enter the amount of advance pay", "Advance amount");
        //Sales Commission Calculator class object with values
        SalesCommissionCalc calc = new SalesCommissionCalc(sales, advance);
        //calculate sales commission value
        calc.calculateSalesCommission();
        //display actual pay to the user
        calc.displayPay();
    }

    public static double checkVariable(String selectMessage, String variable) {
        boolean isNum = false;
        double val = 0.0;
        while(!isNum) {
            try {
                //get input from the user
                String input = JOptionPane.showInputDialog(selectMessage);
                //validate value entered by user
                val = Double.parseDouble(input);
                if(val <= 0) {
                    JOptionPane.showMessageDialog(null, "Invalid input. " + variable
                            + " value must be greater than 0");
                    continue;
                }
                isNum = true;
            } catch (NumberFormatException ex) {
                //Display message and continue the loop recursively
                JOptionPane.showMessageDialog(null, "Invalid input. " + variable
                        + " must be number");
            }
        }
        return val;
    }

}
