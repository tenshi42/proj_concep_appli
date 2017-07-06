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
<tabl>
<jsp:include page="/WEB-INF/menu.jsp" />
<h1>Liste des championat</h1>
<c:if test="${admin == 1}"><a href="/Admin/Championship/Add">Ajouter un championat</a></c:if>
<table id="classement">
    <tr><td>Nom</td><c:if test="${admin == 1}"><td>Pays</td><td>Pts. Victoire</td><td>Pts. Nul</td><td>Pts. Défaite</td><td></td><td></td></c:if></tr>
    <c:forEach var="c" items="${championships}">
        <tr>
            <td><a href="/Admin/Championship/ViewOne/${c.id}"><c:out value='${c.name}'/></a></td>
            <c:if test="${admin == 1}">
                <td><c:out value='${countries[c.countryId].name}'/></td>
                <td><c:out value='${c.pointsOnWin}'/></td>
                <td><c:out value='${c.pointsOnNul}'/></td>
                <td><c:out value='${c.pointsOnLose}'/></td>
                <td><a href="/Admin/Championship/Modify/${c.id}">Modifier</a></td>
                <td><a href="/Admin/Championship/Delete/${c.id}">Suprimer</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
