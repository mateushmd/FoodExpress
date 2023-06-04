<%@ page contentType="text/html" pageEncoding="UTF-8" %>
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
            <img src="../imgs/logo.png" alt="">
            <div class="container">
                <form action="cadastrar" method="post">
                    <section class="campo">
                        <label for="name" class="label">NOME:</label>
                        <input type="text" id="name" name="name">
                    </section>

                    <section class="campo">
                        <label for="email" class="label">E-MAIL:</label>
                        <input type="email" id="email" name="email">
                    </section>

                    <section class="campo">
                        <label for="password" class="label">SENHA:</label>
                        <input type="password" id="password" name="password">
                    </section>

                    <section class="campo">
                        <label for="phone" class="label">TELEFONE:</label>
                        <input type="tel" id="phone" name="tel" tabindex="1" placeholder="(xx) x xxxx-xxxx" value=""
                               maxlength="15">
                    </section>

                    <section class="opcoes">
                        <div id="comprar">
                            <label><input type="radio" name="opcao" value="1">VOU COMPRAR</label>
                        </div>
                        <div id="vender">
                            <label><input type="radio" name="opcao" value="2">VOU VENDER</label>
                        </div>
                    </section>

                    <div class="botao">
                        <input type="submit" value="CADASTRAR" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="cadastro">
                        <p id="tenhoLogin"><a href="login.html" style="font-family: 'Oswald', sans-serif; font-size: 12px;">JÁ TENHO CADASTRO</a></p>
                    </div>
                </form>
            </div>
        </main>
        <script src="../mascaras.js"></script>
    </body>
</html>
