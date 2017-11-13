<%-- 
    Document   : HelloWorldJSP
    Created on : Nov 12, 2017, 5:29:25 PM
    Author     : Hong Ha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HelloWorldJSP</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            for (int i = 1; i <= 10; i++) {                
        %>
                <h3><%= i%></h3>
        <%} %>
    </body>
</html>
