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
<h1>Liste des équipes</h1>
<c:if test="${admin == 1}"><a href="/Admin/Team/Add">Ajouter une équipe</a></c:if>
<table id="classement">
    <tr><td>Nom</td><c:if test="${admin == 1}"><td>Ville</td><td>Entraineur</td><td>Stade</td><td></td><td></td></c:if></tr>
    <c:forEach var="t" items="${teams}">
        <tr>
            <td><a href="/Team/${t.id}"><c:out value='${t.name}'/></a></td>
            <c:if test="${admin == 1}">
                <td><c:out value='${t.city}'/></td>
                <td><c:out value='${t.trainingOfficer}'/></td>
                <td><c:out value='${stadiums[t.stadiumId].name}'/></td>
                <td><a href="/Admin/Team/Modify/${t.id}">Modifier</a></td>
                <td><a href="/Admin/Team/Delete/${t.id}">Suprimer</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
