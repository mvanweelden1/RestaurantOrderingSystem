package model;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Mark Van Weelden
 */
public interface IMenuDAO{
    
        public abstract List getAllMenuItems() throws DataAccessException;
        
        public abstract MenuItem getMenuItemById(String key) throws DataAccessException;

    
}
