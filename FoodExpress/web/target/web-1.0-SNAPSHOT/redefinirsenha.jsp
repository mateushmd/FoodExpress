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
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
        <title>Redefinir Senha</title>
    </head>

    <body>
        <main>
            <div class="container" id="containerRedefinir">
                <form action="redefinirSenha" method="post">
                    <h1>Quase lá!</h1>
                    <p>Estamos finalizando o processo para redefinir sua senha, insira uma nova senha no campo abaixo.</p>

                    <fieldset class="number-code">
                        <legend>Senha</legend>
                        <input type="password" name="password" id="password">
                    </fieldset>

                    <div class="botao1">
                        <input type="submit" name="submit" value="REDEFINIR" style="cursor: pointer; font-family: 'Oswald', sans-serif;" class="login">
                    </div>

                    <input type="hidden" name="email" value="${usuario.getEmail()}">
                </form>
            </div>
        </main>
        <script src="scripts/autenticacao/verificacao/codigoVerificacao.js"></script>
    </body>

</html>

