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
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
    </head>
    <body>
        <header>
            <nav class="nav-bar">
                <div class="logo"><a href="menuprincipal.html"><img src="imgs/logo2.png" alt="Logo" id="logoimg"></a></div>

                <div class="menu-options">
                    <ul>
                        <li class="menu-item"><a href="menuprincipal.html" class="menu-link">INÍCIO</a></li>
                        <li class="menu-item"><a href="perfil.html" class="menu-link">PERFIL</a></li>
                        <li class="menu-item"><a href="#" class="menu-link">PEDIDOS</a></li>
                        <li class="menu-item"><a href="#" class="menu-link">FAVORITOS</a></li>
                        <li class="menu-item"><a href="#" class="menu-link">SOBRE</a></li>
                    </ul>

                    <div class="pesquisa-icon">
                        <input type="text" class="barra-pesquisa" placeholder="Pesquisar...">
                        <a class="pesquisaBtn">
                            <img class="lupa-icon-B" src="imgs/loupe-white.svg" alt="Lupa">
                            <img class="lupa-icon-A" src="imgs/loupe-blue.svg" alt="Lupa">

                        </a>
                    </div>
                </div>

                <div class="botao-menu"><button onclick="menuShow()"><img class="menuBtn" src="imgs/menu_white_36dp.svg"></button></div>
            </nav>

            <div class="menu-options-mobile">
                <ul>
                    <li class="menu-item"><a href="menuprincipal.html" class="menu-link">INÍCIO</a></li>
                    <li class="menu-item"><a href="perfil.html" class="menu-link">PERFIL</a></li>
                    <li class="menu-item"><a href="#" class="menu-link">PEDIDOS</a></li>
                    <li class="menu-item"><a href="#" class="menu-link">FAVORITOS</a></li>
                    <li class="menu-item"><a href="#" class="menu-link">SOBRE</a></li>
                </ul>
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

        <script src="scripts/barraPesquisa.js"></script>
        <script src="scripts/mascaras.js"></script>
        <script src="scripts/editarPerfil.js"></script>
        <script src="scripts/menu.js"></script>
    </body>
</html>

