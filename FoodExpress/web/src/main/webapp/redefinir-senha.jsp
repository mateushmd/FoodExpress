<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main/main.css">
        <link rel="stylesheet" href="styles/paginasDados.css">
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
        <title>Redefinir Senha</title>
    </head>

    <body>
        <main>
            <h1>Quase lá!</h1>
            <p>Insira uma nova senha no campo abaixo.</p>

            <div class="input-container">
                <label for="password">Senha</label>
                <input type="password" name="password" id="password">
            </div>

            <div class="input-container">
                <label for="password">Confirmar senha</label>
                <input type="password" name="password" id="confirm-password">
            </div>

            <button>
                <input type="submit" name="submit" value="REDEFINIR" id="redefinir">
            </button>
        </main>
    </body>

    <script src="scripts/jquery/jquery.js"></script>

    <script src="scripts/usuario/dados/redefinirSenha.js"></script>
</html>

