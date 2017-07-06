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
<jsp:include page="/WEB-INF/head.jsp" />
<body>
<jsp:include page="/WEB-INF/menu.jsp" />
<h1>Liste des compétitions</h1>
<div>
    <c:forEach var="c" items="${championships}">
        <a href ="/Competitions/<c:out value='${c.id}'/>"><c:out value='${c.name}'/></a>
    </c:forEach>
</div>
</body>
</html>
