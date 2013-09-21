package model;

import java.util.List;

/**
 *
 * @author Mark Van Weelden
 */
public interface IMenuDAO{
    
        public abstract List getAllMenuItems() throws DataAccessException;
        
        public abstract MenuItem getMenuItemById(String key) throws DataAccessException;

    
}
