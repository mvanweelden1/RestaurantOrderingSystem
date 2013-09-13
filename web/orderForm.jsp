<%-- 
    Document   : orderForm
    Created on : Sep 11, 2013, 9:13:25 PM
    Author     : Mark Van Weelden
--%>

<%@page import="java.util.Map"%>
<%@page import="model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Styles/maincss.css" rel="StyleSeet" type="text/css">
        <title>Order Form</title>
    </head>
    <body>
        <form name="form1" id="form1" method="POST" action="Conformation">
            <fieldset>
                <legend> Menu </legend>
                <%
                    Map<String, MenuItem> menuItems = null;
                    Object menu = request.getAttribute("menuitems");
                    if (menu != null) {
                        menuItems = (Map<String, MenuItem>) menu;
                    }
                %>
                <%
                    for (String key : menuItems.keySet()) {
                %>      
                <input type='checkbox' name='menuChoices'value='<%= key%>'/><%= key%><br>

                <%}%>

                <p><input type="submit" name="submit" id="submit" value="Submit"></p>
            </fieldset> 
        </form>
    </body>
</html>
