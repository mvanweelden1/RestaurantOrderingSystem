<%-- 
    Document   : conformationPage
    Created on : Sep 13, 2013, 12:41:48 PM
    Author     : Owner
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Styles/maincss.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Miltonian' rel='stylesheet' type='text/css'>
        <title>Conformation Page</title>
    </head>
    <body>
        <h1 class="box">Conformation Page</h1>

        <table name="conformation" id="conformation">
            <%
                final String ITEMS_ORDERED = "itemsOrdered";
                final String SUB_TOTAL = "subTotal";
                final String TOTAL = "total";

                ArrayList<MenuItem> itemsOrdered = null;
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                Object subTotal = request.getAttribute(SUB_TOTAL);
                Object total = request.getAttribute(TOTAL);
                Object itemsSelected = request.getAttribute(ITEMS_ORDERED);
                if (itemsSelected != null) {
                    itemsOrdered = (ArrayList<MenuItem>) itemsSelected;
                }
            %>
            <%for (MenuItem m : itemsOrdered) {%>


            <tr>
                <td><%= m.getItemName()%></td>
                <td><%= nf.format(m.getItemPrice())%></td>
            </tr>

            <%}%> 

            <tr>
                <td class="alignRight">Subtotal:</td>
                <td><%= nf.format(subTotal)%></td>   
            </tr>
            <tr>
                <td class="alignRight">Total w/Tax:</td>
                <td><%= nf.format(total)%></td>   
            </tr>

        </table>


    </body>
</html>
