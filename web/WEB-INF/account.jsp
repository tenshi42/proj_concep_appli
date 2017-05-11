<%--
  Created by IntelliJ IDEA.
  User: mercier
  Date: 25/04/2017
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Compte</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/Account" method="post">
        <table>
            <tr><td>Nom d'utilisateur *</td><td>Email *</td></tr>
            <tr><td><input type="text" id="username" name="username" value="${sessionScope.User.username}" required/></td><td><input type="text" id="email" name="email" value="${sessionScope.User.email}" required/></td></tr>
            <tr><td>Nom *</td><td>Prénom *</td></tr>
            <tr><td><input type="text" id="lastName" name="lastName" value="${sessionScope.User.lastName}"/></td><td><input type="text" id="firstName" name="firstName" value="${sessionScope.User.firstName}"/></td></tr>
            <tr><td>Addresse *</td><td>Addresse (suite) *</td></tr>
            <tr><td><input type="text" id="addr" name="addr" value="${sessionScope.User.addr}"/></td><td><input type="text" id="addr2" name="addr2" value="${sessionScope.User.addr2}"/></td></tr>
            <tr><td>Code Postal *</td><td>Ville *</td></tr>
            <tr><td><input type="text" id="zipCode" name="zipCode" value="${sessionScope.User.zipCode}"/></td><td><input type="text" id="city" name="city" value="${sessionScope.User.city}"/></td></tr>
            <tr><td>Téléphone *</td><td>Date de Naissance *</td></tr>
            <tr><td><input type="text" id="phone" name="phone" value="${sessionScope.User.phone}"/></td><td></td></tr>
            <tr><td>Pays *</td><td>Etat</td></tr>
            <tr><td><select id="contry" name="contry"><option value="france">France</option><option value="etranger">Etranger</option></select></td><td><input type="text" id="state" name="state" value="${sessionScope.User.state}"/></td></tr>
            <tr><td colspan="2"><button type="submit" value="Update">Valider</button></td></tr>
        </table>
    </form>
</body>
</html>
