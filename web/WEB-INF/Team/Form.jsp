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
<form action="/Admin/Team/Modify" method="post">
    <input type="hidden" name="championshipId" value="${championshipId}"/>
    <table id="classement">
        <tr><td>Nom</td><td><input type="text" name="name" value="${team.name}"/></td></tr>
        <tr><td>Ville</td><td><input type="text" name="city" value="${team.city}"/></td></tr>
        <tr><td>Entraineur</td><td><input type="text" name="trainingOfficer" value="${team.trainingOfficer}"/></td></tr>
        <tr>
            <td>Stade</td>
            <td>
                <select name="stadium" >
                    <c:forEach var="s" items="${stadiums}">
                        <option value="${s.id}">${s.name}</option>
                    </c:forEach>
                </select>
            </td></tr>
        <tr><td><input type="submit" name="submit" value="<c:if test="${championshipId != null}">Modifier</c:if><c:if test="${championshipId == null}">Ajouter</c:if>"></td></tr>
    </table>
</form>
</body>
</html>
