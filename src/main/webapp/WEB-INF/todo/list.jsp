<%--
  Created by IntelliJ IDEA.
  User: YJ
  Date: 24. 4. 17.
  Time: 오전 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--java 사용을 위해 glassfish-jstl와 jakarta.servlet.jsp.jstl-api추가 --%>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/logout" method="post">
    <button type="submit">로그아웃</button>
</form>

    <h1>리스트 페이지</h1>
    <h2>${appName}</h2>
    <h2>${loginInfo}</h2>
    <h3>${loginInfo.mname}</h3>
    <ul>
        <c:forEach var="dto" items="${list}">
            <li>
                    <%--${dto}--%>
                <a href="/todo/read?tno=${dto.tno}">tno:${dto.title}</a>
                <span>${dto.dueDate}</span>
                <span>${dto.finished? "Done":"Not yet"}</span>
            </li>
        </c:forEach>
    </ul>
    <a href="/todo/register">입력 페이지로</a>
</body>
</html>
