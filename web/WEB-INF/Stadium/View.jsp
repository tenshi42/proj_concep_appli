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
<h1>Liste des stades</h1>
<c:if test="${admin == 1}"><a href="/Admin/Stadium/Add">Ajouter un stade</a></c:if>
<table id="classement">
    <tr><td>Nom</td><c:if test="${admin == 1}"><td>Capacité</td><td></td><td></td></c:if></tr>
    <c:forEach var="s" items="${stadiums}">
        <tr>
            <td><a href="/Stadium/${s.key}"><c:out value='${s.value.name}'/></a></td>
            <c:if test="${admin == 1}">
                <td><c:out value='${s.value.capacity}'/></td>
                <td><a href="/Admin/Stadium/Modify/${s.key}">Modifier</a></td>
                <td><a href="/Admin/Stadium/Delete/${s.key}">Suprimer</a></td>
            </c:if>
        </tr>
    </c:forEach>
</table>
</body>
</html>
