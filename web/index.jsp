<%-- 
    Document   : index
    Created on : Sep 11, 2013, 8:34:44 PM
    Author     : Owner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="Styles/maincss.css" rel="stylesheet" type="text/css">
        <link href='http://fonts.googleapis.com/css?family=Miltonian' rel='stylesheet' type='text/css'>
        <title>Home Page</title>
    </head>
    <body>

        <h1 class="box">Clever Restaurant Name</h1>
        <form name="form" id="form" method="POST" action="FrontController">
            <input type="submit" name="action" id="action" value="Order" />
            <input type="submit" name="action" id="action" value="Manage" />
        </form>
        <img class="box" src="Images/burger.png" alt="Resuaurant" height="500" width="750"> 

    </body>
</html>
