<%--
  Created by IntelliJ IDEA.
  User: mercier
  Date: 06/07/2017
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/head.jsp" />
<body>
<jsp:include page="/WEB-INF/menu.jsp" />
<h1><c:if test="${teamId != null}">Modifier</c:if><c:if test="${teamId == null}">Ajouter</c:if> une équipe</h1>
<form action="/Admin/Team/<c:if test="${teamId != null}">Modify</c:if><c:if test="${teamId == null}">Add</c:if>" method="POST">
    <input type="hidden" name="teamId" value="${teamId}"/>
    <table id="classement">
        <tr><td>Nom</td><td><input type="text" name="name" value="${team.name}"/></td></tr>
        <tr><td>Ville</td><td><input type="text" name="city" value="${team.city}"/></td></tr>
        <tr><td>Entraineur</td><td><input type="text" name="trainingOfficer" value="${team.trainingOfficer}"/></td></tr>
        <tr>
            <td>Stade</td>
            <td>
                <select name="stadiumId" >
                    <c:forEach var="s" items="${stadiums}">
                        <option value='<c:out value="${s.key}"/>'><c:out value="${s.value.name}"/></option>
                    </c:forEach>
                </select>
            </td></tr>
        <tr><td><input type="submit" name="submit" id="submit" value="<c:if test="${teamId != null}">Modifier</c:if><c:if test="${teamId == null}">Ajouter</c:if>"></td></tr>
    </table>
</form>
</body>
</html>
