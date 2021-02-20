<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>age</td>
        </tr>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.userId}</td>
                <td>${u.userName}</td>
                <td>${u.userPwd}</td>
            </tr>
        </c:forEach>
        <%--<tr th:each="u : ${list}">
            <td th:text="${u.userId}"></td>
            <td th:text="${u.userName}"></td>
            <td th:text="${u.userPwd}"></td>
        </tr>--%>
    </table>
</div>
</body>
</html>