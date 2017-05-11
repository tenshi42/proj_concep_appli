<%--
  Created by IntelliJ IDEA.
  User: quent
  Date: 25/04/2017
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Competitions</title>
    <link rel="stylesheet" href="../style.css" />
    <script src="../JS/jquery-3.0.0.js"></script>
    <script src="../JS/functions.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/menu.jsp" />
<jsp:include page="/WEB-INF/inscriptionSnippet.jsp" />
<jsp:include page="/WEB-INF/connectionSnippet.jsp" />

<div>
    <c:forEach var="c" items="${championshit}">
    <a href ="/competitions/<c:out value='${c[1]}'/>"><c:out value='${c[0]}'/></a>
    </c:forEach>
</div>
</body>
</html>
