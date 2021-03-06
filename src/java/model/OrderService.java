package model;

import java.util.ArrayList;

/**
 *
 * @author Mark Van Weelden
 */
public class OrderService {

    private IMenuDAO menuDao = new MenuDAO();
    ArrayList<MenuItem> itemsOrdered = new ArrayList<>();
    OrderCalculator calc = new OrderCalculator(itemsOrdered);

    public OrderService(String[] s) throws DataAccessException {
        populateItemsOrdered(s);
    }

    public double getSubTotal() {
        return calc.getSubTotal();

    }

    public double getTotal() {
        return calc.getTotal();

    }

    private void populateItemsOrdered(String[] s) throws DataAccessException {

        for (String string : s) {

            itemsOrdered.add(menuDao.getMenuItemById(string));

        }
    }

    public IMenuDAO getMenuDao() {
        return menuDao;
    }

    public void setMenuDao(IMenuDAO menuDao) {
        this.menuDao = menuDao;
    }

    public ArrayList<MenuItem> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(ArrayList<MenuItem> itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public static void main(String[] args) throws DataAccessException {

        String[] items = {"1", "2"};

        OrderService o = new OrderService(items);

        System.out.println(o.getSubTotal());
    }
}