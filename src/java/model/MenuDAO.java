package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mark Van Weelden
 */
public class MenuDAO implements IMenuDAO {

    private DBAccessor db;
    private static final String FIND_ALL_MENU_ITEMS =
            "SELECT * FROM menu_item;";
    private static final String TABLE = "menu_item";
    private static final String PRIMARY_KEY_FIELD = "item_id";
    private static final String ITEM_ID = "item_id";
    private static final String NAME = "name";
    private static final String PRICE = "price";

    public MenuDAO(DBAccessor db) {
        this.db = db;
    }

    private void openLocalDbConnection() throws DataAccessException {
        try {
            // Each time you perform a new query you must re-open the connection
            db.openConnection(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost:3306/restaurant",
                    "root", "admin");
        } catch (IllegalArgumentException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        } catch (ClassNotFoundException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        } catch (SQLException ex) {
            throw new DataAccessException(ex.getMessage(), ex);
        }
    }

    @Override
    public List getAllMenuItems() throws DataAccessException {

        List<Map> rawData = new ArrayList<Map>();
        List<MenuItem> records = new ArrayList<MenuItem>();
        try {
            this.openLocalDbConnection();
            rawData = db.findRecords(FIND_ALL_MENU_ITEMS, true);

        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);
        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }

        MenuItem menuItem = null;

        for (Map m : rawData) {

            menuItem = new MenuItem();

            String id = m.get(ITEM_ID).toString();
            menuItem.setItemId(new Integer(id));

            String name = m.get(NAME).toString();
            menuItem.setItemName(name);

            String price = m.get(PRICE).toString();
            menuItem.setItemPrice(new Double(price));

            records.add(menuItem);

        }
        return records;
    }

    @Override
    public MenuItem getMenuItemById(String ID) throws DataAccessException {
        Map rawdata = new HashMap();

        try {
            this.openLocalDbConnection();
            rawdata = db.getRecordByID(TABLE, PRIMARY_KEY_FIELD, ID, true);
        } catch (SQLException e1) {
            throw new DataAccessException(e1.getMessage(), e1);
        } catch (Exception e2) {
            throw new DataAccessException(e2.getMessage(), e2);
        }

        MenuItem menuItem = new MenuItem();

        String id = rawdata.get(ITEM_ID).toString();
        menuItem.setItemId(new Integer(id));

        String name = rawdata.get(NAME).toString();
        menuItem.setItemName(name);

        String price = rawdata.get(PRICE).toString();
        menuItem.setItemPrice(new Double(price));

        return menuItem;

    }

    public DBAccessor getDb() {
        return db;
    }

    public void setDb(DBAccessor db) {
        this.db = db;
    }

    public static void main(String[] args) throws Exception {
        MenuDAO dao = new MenuDAO(new DB_Generic());

//        List<MenuItem> records = dao.getAllMenuItems();
//
//        for (MenuItem menuItem : records) {
//            System.out.println(menuItem);
//        }
        
        String[] menuChoices = {"1","2","3"};
        
        List<MenuItem> records = new ArrayList<>();
        
        for (String s : menuChoices) {
           MenuItem m = dao.getMenuItemById(s);
           records.add(m);
        }
        
        System.out.println(records);






    }
}
