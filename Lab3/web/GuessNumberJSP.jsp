<%-- 
    Document   : GuessNumberJSP
    Created on : Nov 12, 2017, 6:19:45 PM
    Author     : Hong Ha
--%>

<%@page import="java.util.Random"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GuessNumberJSP</title>
    </head>
    <body>      
       
        <%
           Random rd = new Random();
           Integer rdNum= rd.nextInt(9) +1;           
           String inputNum = request.getParameter("inputNum");
           if(inputNum == null){%>
                <form  action='GuessNumberJSP.jsp' method='get'>
                    Please guess a number between 0 and 10 <input type=number name=inputNum size=20><br>
                    <input type=submit value='Submit' />
                </form>

         <%}else{
                try{
                    Integer guessNum = Integer.parseInt(inputNum);
                    if(guessNum == rdNum){%>
                    <h3>Correct, congratulation!</h3></br>
                    <%
                    }else if(guessNum < rdNum){ %>
                        <h3>Too low, try again!</h3></br>
                    <% }else{ %>    
                        <h3>Too high, try again!</h3> </br>
                    <% } 
                }
                catch (NumberFormatException e){ %>
                    <h3> Please enter a valid number </h3></br>
                <%} %>
                <form  method='get'>
                    Please guess a number between 0 and 10 <input type=number name=inputNum size=20><br>
                    <input type=submit value='Submit' />
                </form>
           <%}
        %>

    </body>
</html>
