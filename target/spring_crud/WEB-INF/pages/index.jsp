<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>
        <c:forEach var="users" items="${users}">
            <tr>
                <td><c:out value="${users.id}" /></td>
                <td><c:out value="${users.firstName}" /></td>
                <td><c:out value="${users.lastName}" /></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>>
</html>
