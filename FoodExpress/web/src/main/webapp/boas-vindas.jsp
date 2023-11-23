<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main/main.css">
        <link rel="stylesheet" href="styles/paginasDados.css">
        <title>FoodExpress</title>
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>
    <body>
        <c:choose>
            <c:when test="${empty sessionScope.usuario}">
                <c:redirect url="login.jsp" />
            </c:when>
            <c:otherwise>
                <c:set var="usuario" value="${sessionScope.usuario}" />
            </c:otherwise>
        </c:choose>

        <c:if test="${usuario.tipo ne 2}">
            <c:redirect url="login.jsp" />
        </c:if>

        <main>
            <h1>Olá, ${usuario.nome}!</h1>
            <p>
                Agora você possui a sua própria loja no FoodExpress! Antes de começar,
                escolha um nome para o seu negócio.
            </p>

            <p>
                Encorajamos todos os nossos vendedores a definirem todos os aspectos essenciais da loja,
                como foto de perfil, banner e horário de funcionamento. Além disso, certifique-se
                que o número de celular informado seja de fácil acesso, pois você receberá pedidos e
                mensagens dos clientes pelo WhatsApp. Você pode alterar todos esses dados a qualquer momento.
            </p>

            <div id="input-container">
                <label for="nome-loja">Nome da loja</label>
                <input type="text" name="nome-loja" id="nome-loja">
            </div>

            <button id="enviar">
                <input type="submit" value="ENVIAR">
            </button>
        </main>

        <script src="scripts/jquery/jquery.js"></script>

        <script src="scripts/minha-loja/configuracaoInicial.js"></script>
    </body>
</html>