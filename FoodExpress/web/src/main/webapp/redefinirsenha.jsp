<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

    String email = (String) request.getAttribute("email");

%>


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
    <main>
        <img src="imgs/logo.png" alt="">
        <div class="containerRedefinir">
            <form action="redefinirSenha" method="post">
                <h1>Quase lá!</h1>
                <p>Estamos finalizando o processo para redefinir sua senha! Insira uma nova senha no campo abaixo.</p>
                <fieldset class='number-code'>
                    <legend>Senha</legend>
                    <input type="password" name="password" id="password">
                </fieldset>
                <div class="botao">
                    <input type="submit" name="submit" value="REDEFINIR" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="login">
                </div>
                
                <input type="hidden" name="email" value="${email}">
            </form>
        </div>
    </main>
    <script src="codigoverificacao.js"></script>
</body>

</html>
