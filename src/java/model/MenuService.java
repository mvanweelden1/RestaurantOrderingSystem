package model;

import java.util.List;

/**
 *
 * @author Mark Van Weelden
 */
public class MenuService {
    
    private IMenuDAO menuDao;
    
    public MenuService() {
        menuDao = new MenuDAO();
    }
    
    public List getAllMenuItems() throws DataAccessException {
        
        return menuDao.getAllMenuItems();
        
    }
    
    public MenuItem getMenuItem(String id)throws DataAccessException{
        
        return menuDao.getMenuItemById(id);
    }
    
    public void updateMenuItem(MenuItem m) throws DataAccessException {
         
            menuDao.save(m);
             
    }
    
    public void deleteMenuItem(String[] ids) throws DataAccessException {
        
        for (String s : ids) {
            MenuItem m = menuDao.getMenuItemById(s);
            menuDao.deleteMenuItem(m);
            
        }
        
    }
}
