<%--
  Created by IntelliJ IDEA.
  User: mercier
  Date: 05/07/2017
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/head.jsp" />
<body>
<jsp:include page="/WEB-INF/menu.jsp" />
<h1>Détails du stade</h1>
<table id="classement">
    <tr><td>Nom : </td><td>${stadium.name}</td></tr>
    <tr><td>Capacité : </td><td>${stadium.capacity}</td></tr>
</table>
</body>
</html>
