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
        <title>Conformation Page</title>
    </head>
    <body>
        <table>
            <%
                NumberFormat nf = NumberFormat.getCurrencyInstance();
                Object itemsSelected = request.getAttribute("itemsOrdered");
                Object subTotal = request.getAttribute("subTotal");
                Object total = request.getAttribute("total");
                ArrayList<MenuItem> itemsOrdered = (ArrayList<MenuItem>) itemsSelected;
            %>
            <%for (MenuItem m : itemsOrdered) {%>


            <tr>
                <td><%= m.getItemName()%></td>
                <td><%= nf.format(m.getItemPrice())%></td>
            </tr>

            <%}%> 
            
            <tr>
                <td>Subtotal:</td>
                <td><%= nf.format(subTotal)%></td>   
            </tr>
            <tr>
                <td>Total w/Tax:</td>
                <td><%= nf.format(total)%></td>   
            </tr>

        </table>


    </body>
</html>
