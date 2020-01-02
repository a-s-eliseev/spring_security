<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<div align="center">
    <form action="<c:url value="/editUser"/>" method="post">
        <table border="1" cellpadding="5">
            <c:if test="${user != null}">
                <input type="hidden" name="id" value="<c:out value='${user.id}' />" />
            </c:if>
            <caption><h2>Edit User</h2></caption>
            <tr>
                <th>First Name: </th>
                <td>
                    <input type="text" name="firstName" size="45"
                           value="<c:out value='${user.firstName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Last Name: </th>
                <td>
                    <input type="text" name="lastName" size="45"
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
