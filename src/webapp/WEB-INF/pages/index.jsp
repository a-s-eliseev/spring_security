<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
</head>
<body>
<div align="center">
    <a href="/logout">Logout</a>
    <a href="/admin/addUser">Add New User</a>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Password</th>
            <th>Roles</th>
            <th>Action</th>
        </tr>
        <c:forEach var="users" items="${users}">
            <tr>
                <td><c:out value="${users.id}" /></td>
                <td><c:out value="${users.username}" /></td>
                <td><c:out value="${users.password}" /></td>
                <td>
                    <c:forEach var="role" items="${users.roles}">
                        ${role.role};
                    </c:forEach>
                </td>
                <td>
                    <a href="/admin/editUser?id=<c:out value='${users.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/admin/deleteUser?id=<c:out value='${users.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
