<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<div align="center">
    <div>
        <a href="/logout">Logout</a>
    </div>
    <form action="<c:url value="/admin/editUser"/>" method="post">
        <table border="1" cellpadding="5">
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
            </c:if>
            <caption><h2>Edit User</h2></caption>
            <tr>
                <th>Username: </th>
                <td>
                    <input type="text" name="username" size="45"
                           value="<c:out value='${user.username}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45"
                           value="<c:out value='${user.password}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Roles: </th>
                <td>
                    <input type="checkbox" name="role" value="ROLE_USER"
                            <c:if test="${role_user != null}"> checked="checked"</c:if>/>USER<br>
                    <input type="checkbox" name="role" value="ROLE_ADMIN"
                            <c:if test="${role_admin != null}"> checked="checked"</c:if>/>ADMIN
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>
