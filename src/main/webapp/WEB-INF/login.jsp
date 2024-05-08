<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 24. 4. 30.
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:if test="${param.result=='error'}">
    <h1>로그인 에러</h1>
</c:if>
<%--<form action="/login?" method="get">
    .../login?result=error
</form>--%>

    <form action="/login" method="post">
        <input type="text" name="mid">
        <input type="text" name="mpw">
<%--        <input type="text" name="mname">--%>
        <button type="submit">로그인</button>
    </form>
</body>
</html>
