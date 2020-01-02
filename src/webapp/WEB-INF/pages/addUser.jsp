<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<div align="center">
    <form action="<c:url value="/addUser"/>" method="post">
        <table border="1" cellpadding="5">
            <caption><h2>Add User</h2></caption>
            <tr>
                <th>Login: </th>
                <td>
                    <input type="text" name="login" size="45" required
                           value="<c:out value='${user.login}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password: </th>
                <td>
                    <input type="text" name="password" size="45" required
                           value="<c:out value='${user.password}' />"
                    />
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