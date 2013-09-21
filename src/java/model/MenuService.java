package model;

import java.util.List;

/**
 *
 * @author Mark Van Weelden
 */
public class MenuService {
    
    private IMenuDAO  menuDao; 

    public MenuService() {
        menuDao = new MenuDAO(new DB_Generic());
    }
    
    public List getAllMenuItems() throws DataAccessException {
        
        return menuDao.getAllMenuItems();
        
    }
    
}
