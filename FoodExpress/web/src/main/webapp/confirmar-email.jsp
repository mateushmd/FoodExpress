<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Title</title>
        <link rel="stylesheet" href="styles/main/main.css">
        <link rel="stylesheet" href="styles/style.css">
        <link rel="stylesheet" href="styles/verificacaoemail.css">
    </head>
    <body>
        <c:choose>
            <c:when test="${empty sessionScope.email}">
                <c:redirect url="login.jsp" />
            </c:when>
            <c:otherwise>
                <c:set var="email" value="${sessionScope.email}"/>
            </c:otherwise>
        </c:choose>

        <main>
            <div id="containerRedefinir">
                <div class="form">
                    <h1>Quase lá!</h1>
                    <p>Digite o código de 6 dígitos enviado para <c:out value="${email}" /> para confirmar o seu
                        e-mail. Após esta etapa você poderá inserir uma nova senha.
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

    </body>
</html>
