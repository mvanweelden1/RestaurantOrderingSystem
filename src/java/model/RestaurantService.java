package model;

import java.util.Map;

/**
 *
 * @author Mark Van Weelden
 */
public class RestaurantService {
    
    private IMenuDAO  menuDao; 

    public RestaurantService() {
        menuDao = new MockMenuDAO();
    }
    
    
    
    public Map<String, MenuItem> getAllMenuItems(){
        
        return menuDao.getAllMenuItems();
    }
    
}
