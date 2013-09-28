<%-- 
    Document   : updateMenuItem
    Created on : Sep 27, 2013, 3:22:51 PM
    Author     : Mark Van Weelden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Update Form</title>
    </head>
    <body>
        <form name="form1" id="form1" method="POST" action="Update">
            <input type="hidden" name="id" value="${item.itemId}" />
            <label for="itemName">Item Name</label>
            <input type="text" name="itemName" value="${item.itemName}"/>  
            <label for="itemPrice">Item Price</label>
            <input type="text" name="itemPrice" value="${item.itemPrice}"/>
            <input type="submit" name="action" value="Finalize"/>
        </form>

    </body>
</html>
