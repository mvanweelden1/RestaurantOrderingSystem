package model;

import java.util.List;

/**
 *
 * @author Mark Van Weelden
 */
public abstract interface IMenuDAO{
    
        public abstract List getAllMenuItems() throws DataAccessException;
        
        public abstract MenuItem getMenuItemById(String key) throws DataAccessException;
        
        public abstract void save(MenuItem m) throws DataAccessException;
        
        public abstract void deleteMenuItem(MenuItem m) throws DataAccessException;
        
        
        

    
}
