<%--
  Created by IntelliJ IDEA.
  User: mercier
  Date: 06/07/2017
  Time: 15:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/head.jsp" />
<body>
<jsp:include page="/WEB-INF/menu.jsp" />
<h1><c:if test="${stadiumId != null}">Modifier</c:if><c:if test="${stadiumId == null}">Ajouter</c:if> un stade</h1>
<form action="/Admin/Stadium/<c:if test="${stadiumId != null}">Modify</c:if><c:if test="${stadiumId == null}">Add</c:if>" method="POST">
    <input type="hidden" name="stadiumId" value="${stadiumId}"/>
    <table id="classement">
        <tr><td>Nom</td><td><input type="text" name="name" value="${stadium.name}"/></td></tr>
        <tr><td>Capacité</td><td><input type="text" name="capacity" value="${stadium.capacity}"/></td></tr>
        <tr><td><input type="submit" name="submit" id="submit" value="<c:if test="${stadiumId != null}">Modifier</c:if><c:if test="${stadiumId == null}">Ajouter</c:if>"></td></tr>
    </table>
</form>
</body>
</html>
