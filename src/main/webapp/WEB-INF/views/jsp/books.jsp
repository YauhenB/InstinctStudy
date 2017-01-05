<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <body>
        Books list:<br>
        <ul>
            <c:forEach var="listValue" items="${list}">
                <li>${listValue}</li>
            </c:forEach>
        </ul>
    </body>
</html>
