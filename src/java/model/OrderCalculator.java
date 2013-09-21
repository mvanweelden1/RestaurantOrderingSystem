package model;

import java.util.ArrayList;

/**
 *
 * @author Mark Van Weelden
 */
public class OrderCalculator {

    private double subTotal = 0;
    private static final double TAX_RATE = .05;

    public OrderCalculator() {
       
    }
    
    public double getSubTotal(ArrayList<MenuItem> items) {
    
        for (MenuItem menuItem : items) {
            subTotal += menuItem.getItemPrice();
        }
        return subTotal;
    }

    public double getTotal() {

        double tax = subTotal * TAX_RATE;
        return subTotal + tax;

    }
    
    
}
