<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/verificacaoemail.css">
    <link rel="stylesheet" type="text/css" href="fonts/style.css"/>
    <title>Redefinir Senha</title>
    <link rel="icon" type="image/png" href="imgs/icon.png"/>
</head>

<body>
    <div id="mainSenha">
        <div id="containerRedefinir">
            <form action="confirmarSenha" method="post">
                <h1>Quase lá!</h1>
                <p id="texto">Antes de mudar sua senha (<c:out value = "${usuario.getEmail()}"/>), insira a senha atual para confirmarmos se é realmente você.
                </p>
                <fieldset class='number-code'>
                    <legend>Senha</legend>
                    <input type="password" name="password" id="password">
                </fieldset>
                <div class="botoes1">
                    <div class="botao1" style="margin-right: 25px">
                        <input type="submit" name="submit" value="ENVIAR" class="login">
                    </div>
                    <div class="botao1">
                        <input type="submit" name="submit" value="CANCELAR" class="login">
                    </div>
                </div>

                <c:if test="${msg != null}">
                    <p id="aviso">
                        <c:out value="${msg}" />
                    </p>
                </c:if>

                <input type="hidden" name="email" value="${usuario.getEmail()}">
            </form>
        </div>
    </div>
</body>

</html>