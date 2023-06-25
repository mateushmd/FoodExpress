<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

    String email = (String) request.getAttribute("email");
    String msg = (String) request.getAttribute("msg");
    System.out.println("verificacaoemail.jsp " + email);

%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="verificacaoemail.css">
        <title>Verificação de email</title>
    </head>
    <body>
        <main>
            <img src="imgs/logo.png" alt="">
            <div id="containerVerificacao">
                <form action="validarEmail" method="post">
                    <h1>Quase lá!</h1>
                    <p>Para concluir o seu cadastro, digite o código de 6 dígitos enviado para <c:out value = "${email}"/>.</p>
                    <fieldset class='number-code'>
                        <legend>Código de verificação</legend>
                        <div>
                            <input type="number" name='code' class='code-input' required />
                            <input type="number" name='code' class='code-input' required />
                            <input type="number" name='code' class='code-input' required />
                            <input type="number" name='code' class='code-input' required />
                            <input type="number" name='code' class='code-input' required />
                            <input type="number" name='code' class='code-input' required />
                        </div>
                    </fieldset>
                    <input type="hidden" name="email" value="${email}" />
                    <div class="botao">
                        <input type="submit" value="REENVIAR CÓDIGO" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="login">
                    </div>
                    <div class="botao">
                        <input type="submit" value="VERIFICAR" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="login">
                    </div>
                </form>
            </div>
        </main>
        <script src="codigoverificacao.js"></script>
    </body>
</html>
