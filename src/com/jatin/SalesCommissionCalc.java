package com.jatin;

import javax.swing.*;
import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class SalesCommissionCalc {
    private double sales;
    private int rate;
    private double commission;
    private double advance;
    private double pay;

    //Default contructor
    public SalesCommissionCalc() {
        this.sales = 0.0;
        this.rate = 0;
        this.commission = 0.0;
        this.advance = 1500.0;
        this.pay = 0.0;
    }

    //Parameterized Constructor
    public SalesCommissionCalc(double sales, double advance) {
        this.sales = sales;
        this.advance = advance;
        getCommissionRateFromSales();
        this.commission = 0.0;
        this.pay = 0.0;
    }

    public double getSales() {
        return sales;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    //Calculate commission from sales
    public void calculateSalesCommission() {
        double comm = getSales() * getRate()/ 100;
        setCommission(comm);
        double pay = comm - getAdvance();
        setPay(pay);
    }

    //Display gross pay to the user
    public void displayPay() {
        Locale dollar = new Locale("en", "US");
        DecimalFormat decformat = new DecimalFormat("#.##");
        NumberFormat df = NumberFormat.getCurrencyInstance(dollar);
        double decVal = Double.parseDouble(decformat.format(Math.abs(getPay())));
        String num = df.format(decVal);

        if(getPay() < 0) {
            JOptionPane.showMessageDialog(null, "The calculated gross pay"
                    + " is less than advance paid.\n" + "Employee has to reimburse "
                    + num + " to the company.");
        }
        else {
            JOptionPane.showMessageDialog(null, "The calculate gross pay"
                    + " is more than the advance paid.\n" + "Company has to pay "
                    + num + " more to the employee.");
        }
    }

    //Get Commission percentage value from user based on sales
    private void getCommissionRateFromSales() {
        int rate = 0;
        double sale = getSales();
        if(sale < 10000) {
            rate = 5;
        }
        else if(sale >= 10000 && sale <= 14999) {
            rate = 10;
        }
        else if(sale >= 15000 && sale <= 17999) {
            rate = 12;
        }
        else if(sale >= 18000 && sale <= 21999) {
            rate = 15;
        }
        else {
            rate = 16;
        }
        this.setRate(rate);
    }
}
