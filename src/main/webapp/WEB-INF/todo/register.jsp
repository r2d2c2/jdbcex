<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 24. 4. 17.
  Time: 오후 2:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>todo 등록</h1>
<form action="/todo/register" method="post">
    <label for="tno">tno:</label>
    <input type="number" name="tno"> <br>
    <label for="title">title:</label>
    <input type="text" name="title"> <br>
    <label for="due">due:</label>
    <input type="date" name="due"> <br>
    <label for="done">done:</label>
    <input type="checkbox" name="done"> <br>
    <button type="submit">서밋</button> <br>
</form>
</body>
</html>
