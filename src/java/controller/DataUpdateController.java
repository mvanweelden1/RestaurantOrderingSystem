package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
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
 * @author Mark Van Weelden
 */
@WebServlet(name = "DataUpdateController", urlPatterns = {"/Update"})
public class DataUpdateController extends HttpServlet {

    private static final String ACTION = "action";
    private static final String DESTINATION_URL = "/dataManagement.jsp";

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
            throws ServletException, IOException {


        String action = request.getParameter(ACTION);
        List<MenuItem> updatedItems = null;


        MenuService ms = new MenuService();

        if (action.equals("Delete")) {

            try {

                ms.deleteMenuItem(request.getParameterValues("item"));
                updatedItems = ms.getAllMenuItems();

            } catch (DataAccessException ex) {
            }

            request.setAttribute("menuitems", updatedItems);


            RequestDispatcher view =
                    request.getRequestDispatcher(DESTINATION_URL);
            view.forward(request, response);
        } else if (action.equals("Add/Change")) {

            String[] ids = request.getParameterValues("item");

            if (ids == null) {
                MenuItem item = new MenuItem();
                request.setAttribute("item", item);
            } else {
                try {

                    MenuItem item = ms.getMenuItem(ids[0]);
                    request.setAttribute("item", item);
                } catch (DataAccessException ex) {

                    Logger.getLogger(DataUpdateController.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

            RequestDispatcher view =
                    request.getRequestDispatcher("/updateMenuForm.jsp");
            view.forward(request, response);

        } else if (action.equals("Finalize")) {

            String id = request.getParameter("id");
            Long objId = (id.equals("null") || id.length() == 0) ? null : new Long(id);
            String name = request.getParameter("itemName");
            double price = Double.valueOf(request.getParameter("itemPrice"));

            MenuItem mi = new MenuItem(name, price, objId);
            try {

                ms.updateMenuItem(mi);
                updatedItems = ms.getAllMenuItems();

            } catch (DataAccessException ex) {
                Logger.getLogger(DataUpdateController.class.getName()).log(Level.SEVERE, null, ex);
            }

            request.setAttribute("menuitems", updatedItems);

            RequestDispatcher view =
                    request.getRequestDispatcher(DESTINATION_URL);
            view.forward(request, response);
        }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
