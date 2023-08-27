<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="styles/loja.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="stylesheet" type="text/css" href="styles/carrossel.css">
        <link rel="stylesheet" type="text/css" href="styles/footer.css">
        <link rel="icon" type="image/png" href="styles/imgs/icon.png" />
    </head>
    <body>
        <c:set var="loja" value="${requestScope.loja}"/>
        <c:set var="produtos" value="${requestScope.produtos}"/>
        <header id="navbar">
            <img id="navbar-logo" src="imgs/logo3.png" alt="Logo">
            <div id="navbar-menu">
                <a class="navbar-link" href="menuprincipal.jsp">Início</a>
                <a class="navbar-link" href="gerenciarperfil.jsp">Perfil</a>
                <a class="navbar-link" href="#">Favoritos</a>
                <a class="navbar-link" href="gerenciarloja.jsp">Loja</a>
                <a class="navbar-link" href="#">Sobre</a>
            </div>
            <div id="search-bar">
                <img src="imgs/lupa-azul.svg" alt="">
                <input type="text" placeholder="Pesquisar...">
            </div>
            <div id="navbar-icons">
                <img id="profile-pic" src="imgs/icone-perfil.png" alt="Perfil">
                <div id="orders">
                    <img id="orders-pic" src="imgs/sacola.png" alt="Pedidos">
                    <div id="orders-info">
                        <p>R$0,00</p>
                        <p>0 itens</p>
                    </div>
                </div>
            </div>
        </header>
        <main>
            <section id="banner">
                <img src="imgs/teste/teste.jpg" alt="">
            </section>
            <section id="info">
                <img src="imgs/teste/teste.jpg" alt="">
                <h1>${loja.nome}</h1>
                <div class="rating">
                    <input class="star-input" id="star1" type="radio" name="rating" value="1">
                    <label class="star-label" for="star1" data-star="1">&#9733;</label>

                    <input class="star-input" id="star2" type="radio" name="rating" value="2">
                    <label class="star-label" for="star2" data-star="2">&#9733;</label>

                    <input class="star-input" id="star3" type="radio" name="rating" value="3">
                    <label class="star-label" for="star3" data-star="3">&#9733;</label>

                    <input class="star-input" id="star4" type="radio" name="rating" value="4">
                    <label class="star-label" for="star4" data-star="4">&#9733;</label>

                    <input class="star-input" id="star5" type="radio" name="rating" value="5">
                    <label class="star-label" for="star5" data-star="5">&#9733;</label>
                </div>
                <form class="favorite" action="">
                    <button type="submit">♥</button>
                    <input type="hidden" name="id" value="${loja.id}">
                </form>
            </section>
            <section id="pesquisa">
                <div id="container-input">
                    <img src="imgs/lupa-azul.svg" alt="">
                    <input type="text" placeholder="Buscar no cardápio">
                </div>
                <div id="container-select">
                    <select name="ponto-encontro">
                        <option value="-1" selected>Escolha um ponto de encontro</option>
                        <option value="1">Saída do bandejão</option>
                        <option value="2">Hall P20</option>
                        <option value="3">Grêmio</option>
                    </select>
                </div>
            </section>
            <section id="destaques" class="content">
                <h1>DESTAQUES</h1>
                <div class="carousel-container fit-product" data-items="3" data-index="0">
                    <div class="arrow arrow-rounded left-arrow"><img src="imgs/arrow-left.png" alt=""></div>
                    <div class="carousel" data-index="0">
                        <c:forEach items="${produtos}" var="produto">
                            <div class="item fit-product">
                                <div class="img-container">
                                    <img src="imgs/teste/teste.jpg" alt="Sandubao">
                                </div>
                                <div class="info-container">
                                    <h2 class="font-707">${produto.nome}</h2>
                                    <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Recusandae error blanditiis sit
                                        nesciunt, impedit consectetur voluptatibus dolores aut vitae excepturi tenetur, labore
                                        tempore dolor corporis ipsum iure? Beatae, ipsa? Harum?</p>
                                    <p class="preco">R$<fmt:formatNumber value='${produto.preco}' pattern='0.00' /></p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="arrow arrow-rounded right-arrow"><img src="imgs/arrow-right.png" alt=""></div>
                </div>
            </section>
            <section id="produtos">
                <h1>CATEGORIA 1</h1>
                <div class="categoria">
                    <c:forEach items="${produtos}" var="produto">
                        <div class="produto">
                            <div class="info-produto">
                                <h2 class="font-707">${produto.nome}</h2>
                                <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Incidunt dolorum quod consequuntur
                                    voluptatem mollitia, non nam impedit exercitationem excepturi, eius nesciunt nobis cum quae.
                                    Est alias voluptate facere tempora debitis?</p>
                                <p class="preco">R$<fmt:formatNumber value='${produto.preco}' pattern='0.00' /></p>
                            </div>
                            <div class="img-produto">
                                <img src="imgs/teste/teste.jpg" alt="">
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <h1>CATEGORIA 2</h1>
                <div class="categoria">
                    <div class="produto">
                        <div class="info-produto">
                            <h2 class="font-707">NOME DO PRODUTO</h2>
                            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Incidunt dolorum quod consequuntur
                                voluptatem mollitia, non nam impedit exercitationem excepturi, eius nesciunt nobis cum quae.
                                Est alias voluptate facere tempora debitis?</p>
                            <p class="preco">$10,00</p>
                        </div>
                        <div class="img-produto">
                            <img src="imgs/teste/teste.jpg" alt="">
                        </div>
                    </div>
                    <div class="produto">
                        <div class="info-produto">
                            <h2 class="font-707">NOME DO PRODUTO</h2>
                            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Incidunt dolorum quod consequuntur
                                voluptatem mollitia, non nam impedit exercitationem excepturi, eius nesciunt nobis cum quae.
                                Est alias voluptate facere tempora debitis?</p>
                            <p class="preco">$10,00</p>
                        </div>
                        <div class="img-produto">
                            <img src="imgs/teste/teste.jpg" alt="">
                        </div>
                    </div>
                    <div class="produto">
                        <div class="info-produto">
                            <h2 class="font-707">NOME DO PRODUTO</h2>
                            <p>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Incidunt dolorum quod consequuntur
                                voluptatem mollitia, non nam impedit exercitationem excepturi, eius nesciunt nobis cum quae.
                                Est alias voluptate facere tempora debitis?</p>
                            <p class="preco">$10,00</p>
                        </div>
                        <div class="img-produto">
                            <img src="imgs/teste/teste.jpg" alt="">
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <footer>
            <div class="container-footer">
                <div class="row-footer">
                    <div class="footer-col">
                        <h4>Menu</h4>
                        <ul>
                            <li><a href="menuprincipal.jsp"> Inicio</a></li>
                            <li><a href="gerenciarperfil.jsp"> Perfil</a></li>
                            <li><a href="sobre.jsp">Sobre</a></li>
                        </ul>
                    </div>
                    <div class="footer-col">
                        <h4>Obter ajuda</h4>
                        <ul>
                            <li><a href="faq.jsp">FAQ</a></li>
                            <li><a href="ajuda.jsp">Ajuda</a></li>
                        </ul>
                    </div>
                    <div class="footer-col">
                        <h4>Informações</h4>
                        <ul>
                            <li><a href="privacidade.jsp">Politica de privacidade</a></li>
                            <li><a href="uso.jsp">Politica de uso</a></li>
                        </ul>
                    </div>
                    <div class="footer-col">
                        <h4>Inscreva-se!</h4>

                        <div class="medias-socias">
                            <a href="#"> <i class="fa fa-facebook"></i> </a>
                            <a href="#"> <i class="fa fa-instagram"></i> </a>
                            <a href="#"> <i class="fa fa-twitter"></i> </a>
                            <a href="#"> <i class="fa fa-linkedin"></i> </a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="main_footer_copy">
                <p class="m-b-footer"> FoodExpress - 2023, todos os direitos reservados.</p>
            </div>
        </footer>
    </body>
</html>
