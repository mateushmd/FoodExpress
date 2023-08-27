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
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="icon" type="image/png" href="styles/imgs/icon.png"/>
    </head>
    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <c:set var="lojas" value="${sessionScope.lojas}"/>
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
            <section class="content">
                <h1>DESTAQUES</h1>
                <div class="carousel-container">
                    <div class="arrow left-arrow"><img src="imgs/arrow-left.png" alt=""></div>
                    <div class="carousel" data-index="0">
                        <c:forEach items="${lojas}" var="loja">
                            <div class="item">
                                <div class="img-container">
                                    <img src="imgs/teste/teste.jpg" alt="Sandubao">
                                </div>
                                <div class="info-container">
                                    <h2>${loja.nome}</h2>
                                    <div class="rate" aria-label="4">
                                        <span class="star filled">★</span>
                                        <span class="star filled">★</span>
                                        <span class="star filled">★</span>
                                        <span class="star filled">★</span>
                                        <span class="star">★</span>
                                    </div>
                                    <form class="favorite" action="">
                                        <button type="submit">♥</button>
                                        <input type="hidden" name="id" value="${loja.id}">
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="arrow right-arrow"><img src="imgs/arrow-right.png" alt=""></div>
                </div>
            </section>
        </main>

        <script src="scripts/carrossel.js"></script>
        <script src="scripts/menu.js"></script>
    </body>
</html>

