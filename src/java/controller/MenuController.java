/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DataAccessException;
import model.MenuItem;
import model.MenuService;

/**
 *
 * @author Owner
 */
@WebServlet(name = "MenuController", urlPatterns = {"/MenuController"})
public class MenuController extends HttpServlet {

    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
    private static final String DESTINATION_URL = "/orderForm.jsp";
    private static final String MENU_ITEMS = "menuitems";

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DataAccessException {
        response.setContentType(CONTENT_TYPE);

        //MockMenuDatabase db = new MockMenuDatabase();
        //MenuItem[] items = db.getMenu();
        //Map<String, MenuItem> items = db.getMenuItemMap();

        MenuService rs = new MenuService();

        String name =
                this.getServletContext().getInitParameter("restaurant-name");

        List<MenuItem> items = rs.getAllMenuItems();

        request.setAttribute("name", name);
        request.setAttribute(MENU_ITEMS, items);

        RequestDispatcher view =
                request.getRequestDispatcher(DESTINATION_URL);
        view.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DataAccessException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (DataAccessException ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
