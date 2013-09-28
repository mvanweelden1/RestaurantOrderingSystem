<%-- 
    Document   : orderForm
    Created on : Sep 11, 2013, 9:13:25 PM
    Author     : Mark Van Weelden
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Styles/maincss.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Miltonian' rel='stylesheet' type='text/css'>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
        <title>Order Form</title>
    </head>
    <body>
        <h1 class="box">Clever Restaurant Name</h1>
        <div id="menu" name="menu" class="box">
            <h2>Menu</h2>
            <form name="form1" id="form1" method="POST" action="Conformation">

                <c:forEach var="menuItem" items="${menuitems}" varStatus="i">
                    <input type='checkbox' name='menuChoices[]'value='${menuItem.itemId}'/><span class="checkboxtext">${menuItem.itemName}</span><br>
                </c:forEach>

                <p><input type="submit" name="submit" id="submit" value="Place Order"/></p>
            </form>
        </div>
    </body>

    <!-- jQuery -->
    <script src="Scripts/jquery-1.10.2.min.js"></script>
    <script src="Scripts/restaurantjs.js"></script>

</html>
