<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="Java" import="com.foodexpress.model.dao.teste" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar</title>
        <link rel="stylesheet" type="text/css" href="../style.css">
        <link rel="icon" type="image/png" href="../imgs/icon.png"/>
    </head>
    <body>
        <main>
            <img src="imgs/logo.png" alt="">
            <div class="containerLogin">
                <form>
                    <section class="campo">
                        <label for="email" class="label">E-MAIL:</label>
                        <input type="email" id="email" name="email">
                    </section>

                    <section class="campo">
                        <label for="password" class="label">SENHA:</label>
                        <input type="password" id="password" name="password">
                    </section>

                    <div class="botao">
                        <input type="submit" value="LOGAR" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="login">
                        <p><a href="cadastro.jsp" id="cadastroBtn">Cadastrar</a>  | <a href="#" id="senhaBtn">  Esqueci minha senha</a></p>
                    </div>
                </form>
            </div>
        </main>
    </body>
</html>
