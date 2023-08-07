<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/verificacaoemail.css">
    <title>Document</title>
</head>

<body>
    <c:set var="usuario" value="${sessionScope.usuario}"/>
    <main>
        <img src="imgs/logo.png" alt="">
        <div class="container" id="containerRedefinir">
            <form action="confirmarSenha" method="post">
                <h1>Quase lá!</h1>
                <p>Antes de mudar sua senha (<c:out value = "${usuario.getEmail()}"/>), insira a senha atual para confirmarmos se é realmente você.</p>
                <fieldset class='number-code'>
                    <legend>Senha</legend>
                    <input type="password" name="password" id="password">
                </fieldset>
                <div class="botao">
                    <input type="submit" name="submit" value="ENVIAR" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="login">
                </div>
                <div class="botao">
                    <input type="submit" name="submit" value="CANCELAR" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="login">
                </div>
                
                <c:if test = "${msg != null}">
                    <p id="aviso"><c:out value = "${msg}"/></p> 
                </c:if>
                
                <input type="hidden" name="email" value="${usuario.getEmail()}">
            </form>
        </div>
    </main>
</body>

</html>
