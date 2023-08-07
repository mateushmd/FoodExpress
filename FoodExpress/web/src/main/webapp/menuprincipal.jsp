<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/menuprincipal.css">
        <link rel="stylesheet" type="text/css" href="styles/carrossel.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="icon" type="image/png" href="styles/imgs/icon.png"/>
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
            <section>
                <p>DESTAQUES</p>
                <div class="container">
                    <button class="handle left-handle">
                        <div class="text">&#8249;</div>
                    </button>
                    <div class="slider">
                        <img src="https://via.placeholder.com/210/00FF00?text=1">
                        <img src="https://via.placeholder.com/220/00FF00?text=2">
                        <img src="https://via.placeholder.com/230/00FF00?text=3">
                        <img src="https://via.placeholder.com/240/00FF00?text=4">
                        <img src="https://via.placeholder.com/250/00FF00?text=5">
                        <img src="https://via.placeholder.com/260/00FF00?text=6">
                        <img src="https://via.placeholder.com/270/00FF00?text=7">
                        <img src="https://via.placeholder.com/280/00FF00?text=8">
                        <img src="https://via.placeholder.com/250/00FF00?text=9">
                        <img src="https://via.placeholder.com/260/00FF00?text=10">
                        <img src="https://via.placeholder.com/270/00FF00?text=11">
                        <img src="https://via.placeholder.com/280/00FF00?text=12">
                    </div>
                    <button class="handle right-handle">
                        <div class="text">&#8250;</div>
                    </button>
                </div>
            </section>

        </main>

        <script src="scripts/barrapesquisa.js"></script>
        <script src="scripts/carrossel.js"></script>
        <script src="scripts/menu.js"></script>
    </body>
</html>

