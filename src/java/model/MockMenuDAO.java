package model;

import java.util.Map;

/**
 *
 * @author Mark Van Weelden
 */
public class MockMenuDAO implements IMenuDAO{
    
    

    @Override
    public Map<String, MenuItem> getAllMenuItems() {
        
        MockMenuDatabase db = new MockMenuDatabase();
        
        return db.getAllMenuItems();
        
        
    }
    
    
}
