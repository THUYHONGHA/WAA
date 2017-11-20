<%-- 
    Document   : NameList
    Created on : Nov 19, 2017, 5:45:28 PM
    Author     : Hong Ha
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


    <body>
    <c:if test="${listPerson!=null}">
        <p>List of Names</p>
        <c:forEach var="key" items="${listPerson}">
            ${key.key}
            ${key.value.firstName}
            ${key.value.lastName}            
        </c:forEach>        
    </c:if>
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
</body>
</html>

