<%-- 
    Document   : MainPage
    Created on : 14-Mar-2022, 5:51:58 pm
    Author     : fahee
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Landing Page</title>
    </head>
    <body>
        <h1>Welcome To Student's Login</h1><br>
        <form action="fetchAll" method="GET">
        <input type="submit" value="Submit All"/><br>
        </form>
        <form action="SubmitAll" method="POST">
            <input type="text" name="filter"/>
        <input type="submit" value="Submit All"/><br>
        </form>
    </body>
</html>
