<%-- 
    Document   : DataManagement
    Created on : Sep 23, 2013, 8:58:29 PM
    Author     : Owner
--%>

<%@page import="model.MenuItem"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Styles/management.css" rel="stylesheet" type="text/css">
        <title>Management</title>
    </head>
    <body>
        <div>
            <h1>Manage Menu Items</h1>
            <form name="form1" id="form1" method="POST" action="Update">

                <table>
                    <tr>
                        <th>Select</th>
                        <th>&nbsp;Item Name</th>
                        <th>Item Price</th>
                    </tr>
                    <c:forEach var="menuItem" items="${menuitems}" varStatus="i">
                        <c:choose>
                            <c:when test="${i.count % 2 == 0}">
                                <tr class="even">
                                    <td><input type='checkbox' name='item'value='${menuItem.itemId}'/></td>
                                    <td>${menuItem.itemName}</td>
                                    <td>${menuItem.itemPrice}</td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td><input type='checkbox' name='item'value='${menuItem.itemId}'/></td>
                                    <td>${menuItem.itemName}</td>
                                    <td>${menuItem.itemPrice}</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>

                    </c:forEach>


                </table>

                <p><input class="submitbutton" type="submit" name="action" value="Delete"/></p>
                <p><input type="submit" name="action" value="Add/Change"/></p>


            </form>
        </div>
    </body>
    <script src="Scripts/jquery-1.10.2.min.js"></script>
    <script src="Scripts/managementjs.js"></script>
</html>
