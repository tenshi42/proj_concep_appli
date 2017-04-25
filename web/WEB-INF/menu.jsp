<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mercier
  Date: 30/03/2017
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="menu">
    <ul>
        <li>
            <a href=<c:url value="Competitions"/> >Compétitions</a>
        </li>
        <li>
            <a href=<c:url value="blogs"/> >Blogs</a>
        </li>
        <c:if test="${sessionScope.User == null}">
            <li>
                <a onclick="showInscription()" >Inscription</a>
            </li>
            <li>
                <a onclick="showConnection()" >Connexion</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.User != null}">
            <li>
                <a href=<c:url value="user"/> ><c:out value="${sessionScope.User.username}"/></a>
            </li>
            <li>
                <a href=<c:url value="Connection"/> ><c:out value="Deconnection"/></a>
            </li>
        </c:if>
    </ul>
</div>