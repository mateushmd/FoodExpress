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
        <c:if test="${empty sessionScope.verificado}">
            <c:redirect url="login.jsp" />
        </c:if>

        <main>
            <h1>Quase lá!</h1>
            <p>Estamos finalizando o processo para redefinir sua senha, insira uma nova senha no campo abaixo.</p>

            <div class="input-container">
                <label for="password">Senha</label>
                <input type="password" name="password" id="password">
            </div>

            <button>
                <input type="submit" name="submit" value="REDEFINIR">
            </button>

            <input type="hidden" name="email" value="${usuario.getEmail()}">
        </main>
        <script src="scripts/autenticacao/verificacao/codigoVerificacao.js"></script>
    </body>

</html>

