<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 24. 4. 19.
  Time: 오전 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>modify todo</h1>
    <form action="/todo/modify" method="post">
        <%--        <input type="number" name="tno" value="${dto.tno}">--%>
        <input type="hidden" name="tno" value="${todoDTO.tno}" readonly> <br>
            <label for="title">Title:</label>
        <input type="text" name="title" value="${todoDTO.title}"><br>
            <label for="dueDate">dueDate:</label>
        <input type="date" name="dueDate" value="${todoDTO.dueDate}"><br>
            <label for="done">done:</label>
        <input type="checkbox" name="done" value="${todoDTO.finished}"><br>
        <button type="submit">변경</button>
    </form>
</body>
</html>
