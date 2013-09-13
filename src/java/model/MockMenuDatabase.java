package model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author Mark Van Weelden
 */
public class MockMenuDatabase {

    private Map<String, MenuItem> menuItemMap =
            new LinkedHashMap<String, MenuItem>();
    private MenuItem[] menu = {
        new MenuItem("CheeseBurger", 5.50),
        new MenuItem("Club Sandwich", 6.50),
        new MenuItem("Chicken Sandwich", 7.75),
        new MenuItem("French Fries", 1.50),
        new MenuItem("Onion Rings", 2.50),
        new MenuItem("Soft Drink", 1.20),
        new MenuItem("Ice Cream Sundae", 2.00)
    };

    public MockMenuDatabase() {
        for (MenuItem m : menu) {
            menuItemMap.put(m.getItemName(), m);
        }
    }

    public Map<String, MenuItem> getMenuItemMap() {
        return menuItemMap;
    }

    public void setMenuItemMap(Map<String, MenuItem> menuItemMap) {
        this.menuItemMap = menuItemMap;
    }

    public MenuItem[] getMenu() {
        return menu;
    }

    public void setMenu(MenuItem[] menu) {
        this.menu = menu;
    }
    
    public MenuItem getMenuItem(String key){
        
        return menuItemMap.get(key);
    }

    public String getMenuItemName(String key) {
        MenuItem item = menuItemMap.get(key);

        return item.getItemName();
    }

    public double getMenuItemPrice(String key) {
        MenuItem item = menuItemMap.get(key);
        return item.getItemPrice();

    }
}
