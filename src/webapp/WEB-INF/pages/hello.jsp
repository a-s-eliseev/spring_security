<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<div align="center">
    <div>
        <a href="/logout">Logout</a>
    </div>
    <table border="1" cellpadding="5">
        <caption><h2>User Information</h2></caption>
        <tr>
            <th>Username: </th>
            <td><c:out value='${user.username}' /></td>
        </tr>
        <tr>
            <th>Role: </th>
            <td>
                <c:forEach var="role" items="${user.roles}">
                    ${role.name};
                </c:forEach>
            </td>
        </tr>
        <tr>
            <th>Password: </th>
            <td>Hidden</td>
        </tr>
    </table>
</div>

</body>
</html>