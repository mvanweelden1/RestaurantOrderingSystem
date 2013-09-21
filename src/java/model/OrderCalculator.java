package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark Van Weelden
 */
public class OrderCalculator {

    private static final double TAX_RATE = .05;
    List<MenuItem> items = new ArrayList<>();

    public OrderCalculator(List<MenuItem> items) {
        
        this.items = items;
       
    }
    
    public double getSubTotal() {
        double subTotal = 0;
        for (MenuItem menuItem : items) {
            subTotal += menuItem.getItemPrice();
        }
        return subTotal;
    }

    public double getTotal() {
        double subTotal = getSubTotal();
        double tax = subTotal * TAX_RATE;
        return subTotal + tax;

    }
    
    
}
