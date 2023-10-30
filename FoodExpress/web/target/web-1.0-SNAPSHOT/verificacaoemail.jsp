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
        <link rel="stylesheet" href="styles/style.css">
        <link rel="stylesheet" href="styles/verificacaoemail.css">
        <link rel="stylesheet" type="text/css" href="fonts/style.css"/>
        <title>Verificar E-mail</title>
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
    </head>
    <body>
        <main>
            <div id="containerRedefinir">
                <form action="validarEmail" method="post">
                    <h1>Quase lá!</h1>
                    <p>Para concluir o seu cadastro, digite o código de 6 dígitos enviado para
                        <c:out value="${email}" />.
                    </p>
                    <fieldset class='number-code'>
                        <legend>Código de verificação</legend>
                        <div id="codigo">
                            <input type="number" name='code' class='code-input' maxlength="1" required />
                            <input type="number" name='code' class='code-input' maxlength="1" required />
                            <input type="number" name='code' class='code-input' maxlength="1" required />
                            <input type="number" name='code' class='code-input' maxlength="1" required />
                            <input type="number" name='code' class='code-input' maxlength="1" required />
                            <input type="number" name='code' class='code-input' maxlength="1" required />
                        </div>
                    </fieldset>
                    <input type="hidden" name="email" value="${email}" />
                    <div class="botoes1" style="margin-bottom: 11px;margin-top: 8px;">
                        <div class="botao1" style="margin-right: 25px">
                            <input type="submit" value="REENVIAR CÓDIGO"
                                   style="cursor: pointer; font-family: 'Oswald', sans-serif;" class="login">
                        </div>
                        <div class="botao1">
                            <input type="submit" value="VERIFICAR"
                                   style="cursor: pointer; font-family: 'Oswald', sans-serif;" class="login">
                        </div>
                    </div>
                </form>
            </div>
        </main>
        <script src="scripts/codigoverificacao.js"></script>
    </body>
</html>
