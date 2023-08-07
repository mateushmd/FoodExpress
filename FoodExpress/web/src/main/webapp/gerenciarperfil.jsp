<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/gerenciarperfil.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="icon" type="image/png" href="imgs/icon.png">
    </head>

    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <header>
            <nav class="nav-bar">
                <div class="logo"><a href="menuprincipal.jsp"><img src="imgs/logo2.png" alt="Logo" id="logoimg"></a></div>

                <div class="menu-options">
                    <ul>
                        <li class="menu-item"><a href="menuprincipal.jsp" class="menu-link">INÍCIO</a></li>
                        <li class="menu-item"><a href="gerenciarperfil.jsp" class="menu-link">PERFIL</a></li>
                        <li class="menu-item"><a href="#" class="menu-link">PEDIDOS</a></li>
                        <li class="menu-item"><a href="#" class="menu-link">FAVORITOS</a></li>
                        <c:if test="${usuario.getTipo() eq 2}">
                            <li class="menu-item"><a href="gerenciarloja.jsp" class="menu-link">MINHA LOJA</a></li>
                        </c:if>
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
            <div class="container">
                <nav id="menu-perfil">
                    <h2>GERENCIAR PERFIL</h2>

                    <div id="perfil">
                        <img src="imgs/foto.jpg" alt="">
                        <h2>${usuario.getNome()}</h2>
                    </div>

                    <h2 class="item" id="selected">INFORMAÇÕES DA CONTA</h2>

                    <h2 class="item">FAVORITOS</h2>

                    <h2 class="item">CHAT</h2>

                    <h2 class="item">PEDIDOS</h2>

                    <h2 class="item">AJUDA</h2>

                    <h2 class="item">SAIR</h2>       
                </nav>
                <section id="informacoes-conta">
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
                                    <input type="tel" name="tel" value="${usuario.getTelefone()}" id="phone" maxlength="18" disabled class="perfil-input">
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
                            <li>
                                <div class="botao">
                                    <input type="submit" name="submit" value="ALTERAR SENHA" style="font-family: 'Oswald', sans-serif;" class="editar-perfil enabled">
                                </div>

                                <div class="botao disabled">
                                    <input type="submit" name="submit" value="APLICAR ALTERAÇÕES" style="font-family: 'Oswald', sans-serif;" class="editar-perfil" disabled id="aplicar-alteracoes">
                                </div>
                            </li>
                            <li>
                                <c:choose>
                                    <c:when test="${usuario.getTipo() eq 1}">
                                        <div class="botao">
                                            <input type="submit" name="submit" value="ABRIR LOJA" style="font-family: 'Oswald', sans-serif;" class="editar-perfil enabled">
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="botao">
                                            <input type="submit" name="submit" value="FECHAR LOJA" style="font-family: 'Oswald', sans-serif;" class="editar-perfil enabled">
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </li>
                            <input type="hidden" name="defName" value="${usuario.getNome()}">
                            <input type="hidden" name="defTel" value="${usuario.getTelefone()}">
                            <input type="hidden" name="defMail" value="${usuario.getEmail()}">
                        </ul>
                    </form>
                </section>
            </div>
        </main>

        <script src="scripts/barrapesquisa.js"></script>
        <script src="scripts/mascaras.js"></script>
        <script src="scripts/editarperfil.js"></script>
        <script src="scripts/menuinterativo.js"></script>
        <script src="scripts/menu.js"></script>
    </body>

</html>
