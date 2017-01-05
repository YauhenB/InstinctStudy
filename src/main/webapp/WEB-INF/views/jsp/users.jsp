<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
    <title>Users list</title>
</head>
<body>
Users list:<br>
<ul>
    <c:forEach var="listValue" items="${list}">
        <li>${listValue}</li>
    </c:forEach>
</ul>

</body>
</html>
