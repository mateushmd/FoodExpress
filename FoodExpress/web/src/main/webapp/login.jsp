<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

    String msg = (String) request.getAttribute("msg");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="styles/style.css">
        <link rel="stylesheet" type="text/css" href="fonts/style.css"/>
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
    </head>
    <body>
        <div id="mainLogin">
            <div class="fundo"></div>
            <div class="containerLogin">
                <img src="imgs/logo_semfundo.png" class="logoLog" alt="">
                <form action="login" method="post">
                    <section class="campo">
                        <label for="email" class="label">E-MAIL:</label>
                        <input type="email" id="email" name="email">
                    </section>

                    <section class="campo">
                        <label for="password" class="label">SENHA:</label>
                        <input type="password" id="password" name="password">
                        <a href="#" id="senhaBtn">  Esqueci minha senha</a>
                    </section>

                    <div class="botao">
                        <input type="submit" value="LOGAR" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="login">
                        <p class="parag">Não tem cadastro? <a href="index.html" id="cadastroBtn">Cadastrar</a></p>
                    </div>

                    <c:if test = "${msg != null}">
                        <p id="aviso"><c:out value = "${msg}"/></p> 
                    </c:if>
                </form> 
            </div>
        </div>
    </body>
</html>

