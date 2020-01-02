<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add User</title>
</head>
<body>
<div align="center">
    <form action="<c:url value="/addUser"/>" method="post">
        <table border="1" cellpadding="5">
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="firstName" size="45" required
                           value="<c:out value='${user.firstName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>LastName: </th>
                <td>
                    <input type="text" name="lastName" size="45" required
                           value="<c:out value='${user.lastName}' />"
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
