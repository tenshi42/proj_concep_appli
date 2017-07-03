<%--
  Created by IntelliJ IDEA.
  User: quent
  Date: 25/04/2017
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/head.jsp" />
<body>
<jsp:include page="/WEB-INF/menu.jsp" />
<div>
    <table id="classement">
        <tr><td>Rang</td><td>Equipe</td><td>Pts.</td><td>J.</td><td>G.</td><td>N.</td><td>P.</td></tr>
        <c:set var="i" value="0"/>
    <c:forEach var="c" items="${sortedClassement}">
        <c:set var="i" value="${i+1}"/>
        <tr><td><c:out value="${i}"/></td><td><c:out value="${teamInfos[c][0]}"/></td>
            <td><c:out value="${classement[c][3]}"/></td>
            <td><c:out value="${classement[c][0] + classement[c][1] + classement[c][2]}"/></td>
            <td><c:out value="${classement[c][0]}"/></td>
            <td><c:out value="${classement[c][1]}"/></td>
            <td><c:out value="${classement[c][2]}"/></td></tr>
    </c:forEach>
        </table>
</div>
</body>
</html>
