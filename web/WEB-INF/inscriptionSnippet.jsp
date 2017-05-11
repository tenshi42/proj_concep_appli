<%--
  Created by IntelliJ IDEA.
  User: mercier
  Date: 13/04/2017
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="blackBackground temps" onclick="hideTemps()">
    <div class="snippet" id="inscriptionSnippet" onclick="(function(e) { e.stopPropagation(); })(event)">
        <form method="post" action="Inscription">
            <table class="snippetTable">
                <tr><td class="formLine"><div>Créer un compte</div></td></tr>
                <tr><td class="formSeparator"><div></div></td></tr>
                <tr><td class="formLine"><input  type="text" id="username" name="username" placeholder="Nom d'utilisateur" /></td></tr>
                <tr><td class="formLine"><input type="email" id="email" name="email" placeholder="E-mail"/></td></tr>
                <tr><td class="formLine"><input type="password" id="mdp" name="mdp" placeholder="Mot de passe"/></td></tr>
                <tr><td class="formLine"><input type="password" id="mdp2" name="mdp2" placeholder="Répétition du mot de passe"/></td></tr>
                <tr><td class="formLine"><input type="submit" value="ENVOYER" class="snippetSubmit" name="submit" /></td></tr>
            </table>
        </form>
    </div>
</div>