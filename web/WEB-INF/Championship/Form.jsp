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
<h1><c:if test="${championshipId != null}">Modifier</c:if><c:if test="${championshipId == null}">Ajouter</c:if> un championat</h1>
<form action="/Admin/Championship/<c:if test="${championshipId != null}">Modify</c:if><c:if test="${championshipId == null}">Add</c:if>" method="POST">
    <input type="hidden" name="championshipId" value="${championshipId}"/>
    <table id="classement">
        <tr><td>Nom</td><td><input type="text" name="name" value="${championship.name}"/></td></tr>
        <tr>
            <td>Pays</td>
            <td>
                <select name="countryId" >
                    <c:forEach var="c" items="${countries}">
                        <option value='<c:out value="${c.key}"/>'><c:out value="${c.value.name}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr><td>Points en cas victoire</td><td><input type="number" name="pointsOnWin" value="${championship.pointsOnWin}"/></td></tr>
        <tr><td>Points en cas match nul</td><td><input type="number" name="pointsOnNul" value="${championship.pointsOnNul}"/></td></tr>
        <tr><td>Points en cas défaite</td><td><input type="number" name="pointsOnLose" value="${championship.pointsOnLose}"/></td></tr>
        <tr><td><input type="submit" name="submit" id="submit" value="<c:if test="${championshipId != null}">Modifier</c:if><c:if test="${championshipId == null}">Ajouter</c:if>"></td></tr>
    </table>
</form>
</body>
</html>
