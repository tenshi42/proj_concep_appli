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
<h1>Détails de l'équipes</h1>
<table id="classement">
    <tr><td>Nom : </td><td>${team.name}</td></tr>
    <tr><td>Ville : </td><td>${team.city}</td></tr>
    <tr><td>Entraineur : </td><td>${team.trainingOfficer}</td></tr>
    <tr><td>Stade : </td><td>${stadiumName}</td></tr>
</table>
</body>
</html>
