package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mark Van Weelden
 */
public class OrderCalculator {
    //private ArrayList<MenuItem> itemsOrdered = null;
    private String[] items;
    private MockMenuDatabase db = new MockMenuDatabase();
    private double subTotal;
    private double total;
    private static final double TAX_RATE = .05;

    public OrderCalculator(String[] items) {
        this.items = items;
    }
    
    public ArrayList<MenuItem> getItemsOrdered(){
        ArrayList itemsOrdered = new ArrayList<MenuItem>();
        for (String s : items) {
            itemsOrdered.add(db.getMenuItem(s));      
        }
        return itemsOrdered;
    }

    public double getSubTotal() {
    
        for (String s : items) {
            subTotal += db.getMenuItemPrice(s);
        }
        return subTotal;
    }

    public double getTotal() {

        double tax = subTotal * TAX_RATE;
        return subTotal + tax;

    }
    
    
}
