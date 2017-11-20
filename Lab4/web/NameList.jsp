<%-- 
    Document   : NameList
    Created on : Nov 19, 2017, 5:45:28 PM
    Author     : Hong Ha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        
        <div>
            <form method="get" action="AddServlet">
                key=<input type="number" name="key" />
                First Name=<input type="text" name="firstName" />
                Last Name=<input type="text" name="lastName" />
                <input type="submit" value="Add" />
            </form>
        </div>
        <div>
            <form method="get" action="RemoveServlet">
                key=<input type="number" name="key" />
                <input type="submit" value="Remove" />
            </form>
        </div>
        
        <c:if test="${listPerson!=null}">
            <p>List of Names</p>
            <c:forEach var="key" items="${listPerson}">
                <div>
                ${key.key}
                ${key.value.firstName}
                ${key.value.lastName}    
                </div>
                  
            </c:forEach>        
        </c:if>
    </body>
</html>

