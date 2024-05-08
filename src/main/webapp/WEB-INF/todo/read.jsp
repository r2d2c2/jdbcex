<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 24. 4. 18.
  Time: 오전 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


    <div>${dto.tno}</div>
    <div>${dto.title}</div>
    <div>${dto.dueDate}</div>
    <div>${dto.finished}</div>
    <form action="/todo/modify" method="get">
        <input type="hidden" name="tno" value="${dto.tno}">
        <button type="submit">tno 전달</button>
    </form>
    <br>
    <form action="/todo/delete" method="post">
        <input type="hidden" name="tno" value="${dto.tno}">
        <button type="submit">삭제</button>
    </form>


<%--<c:forEach var="d" items="${dto}">
    <li>${d.tno}</li>
</c:forEach>

<c:if test="${dto.size()%2==0}">
    짝수
</c:if>

<c:choose>
    <c:when test="${dto.size()%2==0}">
        2의 배수
    </c:when>
    <c:when test="${dto.size()%3==0}">
        3의 배수
    </c:when>
    <c:otherwise>
        아무일도 없었다.
    </c:otherwise>
</c:choose>

<c:set var="t" value="5">

</c:set>--%>



<%--    <form action="/todo/read" method="post">
&lt;%&ndash;        <input type="number" name="tno" value="${dto.tno}">&ndash;%&gt;
        <input type="number" name="tno" value="${dto.tno}" readonly>
        <input type="text" name="title" value="${dto.title}">
        <input type="date" name="dueDate" value="${dto.dueDate}">
        <input type="checkbox" name="done" value="${dto.finished}">
        <button type="submit">변경</button>
    </form>--%>

</body>
</html>
