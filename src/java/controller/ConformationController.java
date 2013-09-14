/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuItem;
import model.MockMenuDatabase;
import model.OrderCalculator;

/**
 *
 * @author Owner
 */
@WebServlet(name = "ConformationController", urlPatterns = {"/Conformation"})
public class ConformationController extends HttpServlet {
    
    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
    private static final String MENU_CHOICES =  "menuChoices[]";
    private static final String ITEMS_ORDERED = "itemsOrdered";
    private static final String SUB_TOTAL = "subTotal";
    private static final String TOTAL = "total";
    private static final String DESTINATION_URL = "/conformationPage.jsp";

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
        response.setContentType(CONTENT_TYPE);
        String[] menuChoices = request.getParameterValues(MENU_CHOICES);
        OrderCalculator o = new OrderCalculator(menuChoices);
        ArrayList<MenuItem> itemsOrdered = o.getItemsOrdered();
        double subTotal = o.getSubTotal();
        double total = o.getTotal();
        request.setAttribute(ITEMS_ORDERED, itemsOrdered);
        request.setAttribute(SUB_TOTAL, subTotal);
        request.setAttribute(TOTAL, total);

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
