<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="styles/main/main.css">
        <link rel="stylesheet" href="styles/style.css">
        <link rel="stylesheet" href="styles/verificacaoemail.css">
        <title>Verificar E-mail</title>
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
    </head>
    <body>


        <main>
            <div id="containerRedefinir">
                <div class="form">
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
                    <div class="botoes1" style="margin-top: 15px;">
                        <div class="botao1" id="reenviar">
                            <input type="submit" value="REENVIAR CÓDIGO"
                                   style="cursor: pointer; font-family: 'Oswald', sans-serif;" class="login">
                        </div>
                        <div class="botao1" id="verificar">
                            <input type="submit" value="VERIFICAR"
                                   style="cursor: pointer; font-family: 'Oswald', sans-serif;" class="login">
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <script src="scripts/jquery/jquery.js"></script>

        <script src="scripts/autenticacao/verificacao/codigoVerificacao.js"></script>
        <script src="scripts/autenticacao/verificacao/verificacao.js"></script>
    </body>
</html>
