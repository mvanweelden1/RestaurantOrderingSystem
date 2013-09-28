<%-- 
    Document   : updateMenuItem
    Created on : Sep 27, 2013, 3:22:51 PM
    Author     : Mark Van Weelden
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="Styles/management.css" rel="stylesheet" type="text/css">

<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Update Form</title>
    </head>
    <body>
        <div id="form" name="form">
            <form name="form2" id="form2" method="POST" action="Update">
                <fieldset>
                    <legend>Add/Update Form</legend>
                    <div>
                        <input class="title" type="hidden" name="id" value="${item.itemId}" />
                    </div>
                    <div>
                        <label class="title" for="itemName">Item Name:</label>
                        <input type="text" name="itemName" value="${item.itemName}"/>
                    </div>
                    <div>
                        <label class="title" for="itemPrice">Item Price:</label>
                        <input type="text" name="itemPrice" value="${item.itemPrice}"/>
                    </div>
                    <div><input type="submit" name="action" id="action" value="Finalize"/></div>
                </fieldset>
            </form>
        </div>
    </body>
</html>
