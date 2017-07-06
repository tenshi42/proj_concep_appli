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
<h1><c:if test="${matchId != null}">Modifier</c:if><c:if test="${matchId == null}">Ajouter</c:if> un match</h1>
<form action="/Admin/Match/<c:if test="${matchId != null}">Modify</c:if><c:if test="${matchId == null}">Add</c:if>" method="POST">
    <input type="hidden" name="matchId" value="${matchId}"/>
    <table id="classement">
        <tr>
            <td>équipe domicile</td>
            <td>
                <select name="teamDomId" >
                    <c:forEach var="c" items="${teams}">
                        <option value='<c:out value="${c.id}"/>' <c:if test="${teamDomId == c.id}">required</c:if><c:out value="${c.name}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>équipe exterieur</td>
            <td>
                <select name="teamExtId" >
                    <c:forEach var="c" items="${teams}">
                        <option value='<c:out value="${c.id}"/>' <c:if test="${teamExtId == c.id}">required</c:if><c:out value="${c.name}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr><td>Score domicile</td><td><input type="number" name="scoreDom" value="${match.scoreDom}"/></td></tr>
        <tr><td>Score exterieur</td><td><input type="number" name="scoreExt" value="${match.scoreExt}"/></td></tr>
        <tr><td></td><td><input type="number" name="scoreExt" value="${match.scoreExt}"/></td></tr>
        <tr><td>Score exterieur</td><td><input type="number" name="scoreExt" value="${match.scoreExt}"/></td></tr>
        <tr><td><input type="submit" name="submit" id="submit" value="<c:if test="${matchId != null}">Modifier</c:if><c:if test="${matchId == null}">Ajouter</c:if>"></td></tr>
    </table>
</form>
</body>
</html>
