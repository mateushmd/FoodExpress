<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.foodexpress.model.dto.UsuarioDTO;"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%

    UsuarioDTO usuario = (UsuarioDTO) request.getAttribute("usuario");

%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/perfil.css">
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
    </head>
    <body>
        <header>
            <div class="logo">
                <img src="imgs/logo2.png" alt="Logo">
            </div>
            <div class="menu-options">
                <ul>
                    <li><a href="perfil.html">PERFIL</a></li>
                    <li><a href="#">PEDIDOS</a></li>
                    <li><a href="#">FAVORITOS</a></li>
                    <li><a href="#">SOBRE</a></li>
                </ul>
            </div>
            <div id="pesquisa-icon">
                <img src="imgs/lupa.png" alt="Lupa">
            </div>
            <div id="barra-pesquisa">
                <input type="text" placeholder="Pesquisar...">
            </div>
        </header>

        <main>
            <section>
                <div id="perfil" class="sessao">
                    <div>
                        <h2>PERFIL</h2>
                        <img src="imgs/foto.jpg" alt="Imagem" id="img-perfil">
                    </div>
                    <form action="editarPerfil" method="post">
                        <ul>
                            <li>
                                <label>NOME:</label>
                                <div>
                                    <input type="text" name="name" value="${usuario.getNome()}" disabled id="name" class="perfil-input">
                                    <button class="editar" data-default="${usuario.getNome()}"><img src="imgs/editar.png" alt=""></button>
                                </div>
                            </li>
                            <li>
                                <label>TELEFONE:</label>
                                <div>
                                    <input type="tel" name="tel" value="${usuario.getTelefone()}" id="phone" maxlength="18" disabled id="tel" class="perfil-input">
                                    <button class="editar" data-default="${usuario.getTelefone()}"><img src="imgs/editar.png" alt=""></button>
                                </div>
                            </li>
                            <li>
                                <label>EMAIL:</label>
                                <div>
                                    <input type="password" name="email" value="${usuario.getEmail()}" disabled id="email" class="perfil-input">
                                    <button class="editar" id="revelar" data-default="${usuario.getEmail()}"><img src="imgs/mostrar.png" alt=""></button>
                                </div>
                            </li>
                            <div class="botao">
                                <input type="submit" name="submit" value="ALTERAR SENHA" style="font-family: 'Oswald', sans-serif;" class="editar-perfil enabled">
                            </div>
        
                            <div class="botao disabled">
                                <input type="submit" name="submit" value="APLICAR ALTERAÇÕES" style="font-family: 'Oswald', sans-serif;" class="editar-perfil" disabled id="aplicar-alteracoes">
                            </div>
        
                            <input type="hidden" name="defName" value="${usuario.getNome()}">
                            <input type="hidden" name="defTel" value="${usuario.getTelefone()}">
                            <input type="hidden" name="defMail" value="${usuario.getEmail()}">
                        </ul>
                    </form>
                </div>
                <div id="loja-cabecalho" class="sessao">
                    <div>
                        <h2>PERSONALIZE SUA LOJA!</h2>
                    </div>
                </div>
            </section>

            <div id="loja" class="sessao">
                <div>
                    <h2>LOJA</h2>
                </div>
                <div id="loja-container" class="fechada">
                    <h2>Você ainda não abriu sua loja! Clique no botão abaixo e comece a vender!</h2>
    
                    <div class="botao">
                        <input type="submit" value="ABRIR MINHA LOJA" style="cursor: pointer; font-family: 'Oswald', sans-serif;" id="abrir-loja">
                    </div>
                </div>
            </div>
        </main>

        <script src="scripts/barrapesquisa.js"></script>
        <script src="scripts/mascaras.js"></script>
        <script src="scripts/editarperfil.js"></script>
    </body>
</html>

