package model;

/**
 *
 * @author Mark Van Weelden
 */
public class MenuItem {
    
    private String itemName;
    private double itemPrice;
    private Long itemId;

    public MenuItem() {
    }
    
    public MenuItem(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public MenuItem(String itemName, double itemPrice, Long itemId) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemId = itemId;
    }
    
    

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemId=" + itemId + '}';
    }
    


  
    
    
    
}
