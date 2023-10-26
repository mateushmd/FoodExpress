<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/main/main.css">
        <link rel="stylesheet" type="text/css" href="styles/loja.css">
        <link rel="stylesheet" type="text/css" href="styles/rating.css">
        <link rel="stylesheet" type="text/css" href="styles/main/header.css">
        <link rel="stylesheet" type="text/css" href="styles/carrossel.css">
        <link rel="stylesheet" type="text/css" href="styles/main/footer.css">
        <link rel="stylesheet" type="text/css" href="styles/slider.css">
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>
    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <c:set var="acessibilidade" value="${sessionScope.acessibilidade}"/>
        <c:set var="loja" value="${requestScope.loja}"/>
        <c:set var="produtos" value="${requestScope.produtos}"/>
        <c:set var="avaliacoes" value="${requestScope.avaliacoes}"/>
        <c:set var="avaliacaoUsuario" value="${requestScope.avaliacaoUsuario}"/>
        <c:set var="favorito" value="${requestScope.favorito}"/>

        <c:set var="ratingClass" value="${not empty avaliacaoUsuario ? 'process-rating disabled' : ''}"/>
        <c:set var="ratingValue" value="${not empty avaliacaoUsuario ? avaliacaoUsuario.nota : 0}"/>

        <input type="hidden" id="emailFirebase" value="${loja.idUser}">
        <input type="hidden" id="avaliacao" value="<fmt:formatNumber value="${loja.avaliacao}" type="number" pattern="#,##0.0" />">
        <input type="hidden" id="id-usuario" value="${usuario.email}">

        <header id="navbar">
            <img id="navbar-logo" src="imgs/logo3.png" alt="Logo">
            <div id="navbar-menu">
                <a class="navbar-link" href="menuprincipal.jsp">Início</a>
                <a class="navbar-link" href="meus-favoritos">Favoritos</a>
                <a class="navbar-link" href="gerenciarloja.jsp">Loja</a>
                <a class="navbar-link" href="#">Sobre</a>
            </div>
            <div id="search-bar">
                <img src="imgs/lupa-azul.svg" alt="">
                <input type="text" placeholder="Pesquisar...">
            </div>
            <div id="navbar-icons">
                <div id="profile">
                    <img id="profile-pic" class="modal-trigger" data-modal-index="0" src="imgs/header/icone-perfil.png"
                         alt="Perfil">
                    <div id="modal-perfil" class="modal hidden" data-modal-index="0">
                        <h2>Olá ${usuario.nome}</h2>
                        <ul>
                            <li><a href=""><img src="imgs/header/engrenagem.svg" alt="">Dados</a></li>
                            <li><a href=""><img src="imgs/header/pedido.svg" alt="">Pedidos</a></li>
                            <li><a href=""><img src="imgs/header/chat.svg" alt="">Conversas</a></li>
                            <li><a href="meus-favoritos"><img src="imgs/header/coracao.svg" alt="">Favoritos</a></li>
                            <li><a href="acessibilidade.jsp"><img src="imgs/header/acessibilidade.svg" alt="">Acessibilidade</a></li>
                            <li><a href=""><img src="imgs/header/sair.svg" alt="">Sair</a></li>
                        </ul>
                    </div>
                </div>
                <div id="orders">
                    <img id="orders-pic" src="imgs/header/sacola.svg" class="slider-trigger" alt="Pedidos">
                    <div id="orders-info">
                        <p>R$ 0,00</p>
                        <p>0 itens</p>
                    </div>
                </div>
            </div>
        </header>

        <div id="overlay" class="hidden"></div>

        <div id="modal-produto" class="modal hidden" data-modal-index="1" data-lock-screen="true">
            <button id="close-modal-produto" class="modal-produto-botao">
                <img src="imgs/x-symbol.svg" alt="">
            </button>
            <div id="modal-produto-main">
                <div id="modal-produto-info">
                    <div id="modal-produto-header">
                        <h2 id="modal-produto-nome" class="font-707">NOME DO PRODUTO</h2>
                    </div>
                    <div id="modal-produto-body">
                        <p id="modal-produto-descricao">DESCRIÇÃO DO PRODUTO</p>
                        <h2 class="font-707">Resumo:</h2>
                        <div id="modal-produto-resumo" class="font-707">
                            <div>
                                <p id="modal-produto-nome-loja">NOME DA LOJA</p>
                                <div id="modal-produto-avaliacao">
                                    <img src="imgs/star.svg" alt="">
                                    <p>5</p>
                                </div>
                            </div>
                            <div>
                                <p>PREÇO INDIVIDUAL: R$ <span id="modal-produto-preco">PREÇO INDIVIDUAL</span></p>
                                <p>QUANTIDADE: <span class="modal-produto-quantidade">1</span></p>
                            </div>
                            <div>
                                <p>TOTAL: R$ <span class="modal-produto-preco-total">PREÇO TOTAL</span></p>
                            </div>
                        </div>
                    </div>
                    <div id="modal-produto-footer">
                        <button id="modal-produto-adicionar" class="modal-produto-botao">
                            <p>Adicionar</p>
                            <p>R$ <span class="modal-produto-preco-total">PREÇO TOTAL</span></p>
                        </button>

                        <div id="modal-produto-quantidade">
                            <button class="modal-produto-botao modal-produto-botao-quantidade" data-operacao="-1">
                                <img src="imgs/loja/menos.svg" alt="">
                            </button>
                            <p class="font-707 modal-produto-quantidade">1</p>
                            <button class="modal-produto-botao modal-produto-botao-quantidade" data-operacao="1">
                                <img src="imgs/loja/mais.svg" alt="">
                            </button>
                        </div>
                    </div>
                </div>
                <div id="modal-produto-img-container">
                    <img src="imgs/teste/teste.jpg" alt="">
                </div>
            </div>
        </div>

        <main>
            <section id="banner">
                <img src="imgs/teste/teste.jpg" alt="" id="bannerLojaF">
            </section>
            <section id="info">
                <img src="imgs/teste/teste.jpg" alt="" id="imgLojaF">
                <h1>${loja.nome}</h1>
                <div class="rating process-rating slider-trigger" data-rating="<fmt:formatNumber value="${loja.avaliacao}" type="number" maxFractionDigits="0"/>">
                    <input class="star-input" id="star1" type="radio" name="rating" value="1">
                    <label class="star-label" for="star1" data-star="1"><img src="imgs/gray-star.svg" alt=""></label>

                    <input class="star-input" id="star2" type="radio" name="rating" value="2">
                    <label class="star-label" for="star2" data-star="2"><img src="imgs/gray-star.svg" alt=""></label>

                    <input class="star-input" id="star3" type="radio" name="rating" value="3">
                    <label class="star-label" for="star3" data-star="3"><img src="imgs/gray-star.svg" alt=""></label>

                    <input class="star-input" id="star4" type="radio" name="rating" value="4">
                    <label class="star-label" for="star4" data-star="4"><img src="imgs/gray-star.svg" alt=""></label>

                    <input class="star-input" id="star5" type="radio" name="rating" value="5">
                    <label class="star-label" for="star5" data-star="5"><img src="imgs/gray-star.svg" alt=""></label>
                </div>
                <div class="favorite">
                    <button type="submit" class="${favorito eq true ? 'active' : ''}">♥</button>
                    <input type="hidden" name="id" value="${loja.id}">
                </div>
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
                    <div class="arrow arrow-rounded left-arrow"><img src="imgs/carrossel/seta.svg" alt=""></div>
                    <div class="carousel" data-index="0">
                        <c:forEach items="${produtos}" var="produto">
                            <div class="item fit-product modal-trigger" data-modal-index="1">
                                <div class="img-container">
                                    <img src="imgs/teste/teste.jpg" alt="Sandubao">
                                </div>
                                <div class="info-container">
                                    <div class="info-container-header">
                                        <h2 class="font-707 nome">${produto.nome}</h2>
                                    </div>
                                    <div class="info-container-body">
                                        <p class="descricao">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Recusandae error blanditiis sit
                                            nesciunt, impedit consectetur voluptatibus dolores aut vitae excepturi tenetur, labore
                                            tempore dolor corporis ipsum iure? Beatae, ipsa? Harum?</p>
                                    </div>
                                    <div class="info-container-footer">
                                        <p class="preco">R$<fmt:formatNumber value='${produto.preco}' pattern='0.00' /></p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="arrow arrow-rounded right-arrow"><img src="imgs/carrossel/seta.svg" alt=""></div>
                </div>
            </section>
            <section id="produtos">
                <h1>CATEGORIA 1</h1>
                <div class="categoria">
                    <c:forEach items="${produtos}" var="produto">
                        <div class="produto">
                            <div class="info-produto">
                                <h2 class="font-707 nome">${produto.nome}</h2>
                                <p class="descricao">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Incidunt dolorum quod consequuntur
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
                            <h2 class="font-707 nome">NOME DO PRODUTO</h2>
                            <p class="descricao">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Incidunt dolorum quod consequuntur
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
                            <h2 class="font-707 nome">NOME DO PRODUTO</h2>
                            <p class="descricao">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Incidunt dolorum quod consequuntur
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
                            <h2 class="font-707 nome">NOME DO PRODUTO</h2>
                            <p class="descricao">Lorem ipsum dolor, sit amet consectetur adipisicing elit. Incidunt dolorum quod consequuntur
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

        <div id="slider">
            <button id="close-slider">
                <img src="imgs/x-symbol.svg" alt="">
            </button>

            <div class="slider-content">
                <!-- QUANDO A SACOLA ESTÁ VAZIA!!!!
                <div id="empty-bag">
                    <div id="empty-bag-img-container">
                        <img src="imgs/header/sacola.svg" alt="">
                        <img src="imgs/x-symbol.svg" alt="">
                    </div>
                    <h2>Sua sacola está vazia</h2>
                    <p>Adicione itens para comprar</p>
                </div>
                -->

                <div id="bag">
                    <div id="bag-header">
                        <p>Seu pedido</p>
                        <div>
                            <h2>Lojinha do Mateus Mateus do lojinha</h2>
                            <a href="">Ir para a loja</a>
                        </div>
                    </div>
                    <div id="bag-body">
                        <div class="bag-categoria">
                            <p>Categoria 1</p>
                            <div class="bag-produto">
                                <div class="bag-produto-header">
                                    <p>Nome Produto</p>
                                    <p class="preco">R$ 99,99</p>
                                </div>
                                <div class="bag-produto-body">
                                    <p>Um produto bem produzido de comer bem gostoso to de buchin xei</p>
                                </div>
                                <div class="bag-produto-footer">
                                    <input type="submit" value="Editar">
                                    <input type="submit" value="Remover">
                                </div>
                            </div>
                            <div class="bag-produto">
                                <div class="bag-produto-header">
                                    <p>Nome Produto</p>
                                    <p class="preco">R$ 99,99</p>
                                </div>
                                <div class="bag-produto-body">
                                    <p>Um produto bem produzido de comer bem gostoso to de buchin xei</p>
                                </div>
                                <div class="bag-produto-footer">
                                    <input type="submit" value="Editar">
                                    <input type="submit" value="Remover">
                                </div>
                            </div>
                        </div>
                        <div class="bag-categoria">
                            <p>Categoria 2</p>
                            <div class="bag-produto">
                                <div class="bag-produto-header">
                                    <p>Nome Produto</p>
                                    <p class="preco">R$ 99,99</p>
                                </div>
                                <div class="bag-produto-body">
                                    <p>Um produto bem produzido de comer bem gostoso to de buchin xei</p>
                                </div>
                                <div class="bag-produto-footer">
                                    <input type="submit" value="Editar">
                                    <input type="submit" value="Remover">
                                </div>
                            </div>
                            <div class="bag-produto">
                                <div class="bag-produto-header">
                                    <p>Nome Produto</p>
                                    <p class="preco">R$ 99,99</p>
                                </div>
                                <div class="bag-produto-body">
                                    <p>Um produto bem produzido de comer bem gostoso to de buchin xei</p>
                                </div>
                                <div class="bag-produto-footer">
                                    <input type="submit" value="Editar">
                                    <input type="submit" value="Remover">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div id="bag-footer">
                        <div>
                            <p>Total</p>
                            <p class="preco">R$ 399,96</p>
                        </div>
                        <button>
                            <p>Realizar pedido</p>
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div id="slider">
            <button id="close-slider">
                <img src="imgs/x-symbol.svg" alt="">
            </button>

            <div id="slider-content">
                <div id="slider-ratings">
                    <div id="slider-ratings-header">
                        <h2 class="font-707">Avaliações</h2>
                        <span>NOME DA LOJA</span>
                        <h1><fmt:formatNumber value="${loja.avaliacao}" type="number" pattern="#,##0.0" /></h1>
                        <div class="rating process-rating" data-rating="<fmt:formatNumber value="${loja.avaliacao}" type="number" maxFractionDigits="0"/>">
                            <input class="star-input" type="radio" name="rating" value="1">
                            <label class="star-label" for="star1" data-star="1"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>

                            <input class="star-input" type="radio" name="rating" value="2">
                            <label class="star-label" for="star2" data-star="2"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>

                            <input class="star-input" type="radio" name="rating" value="3">
                            <label class="star-label" for="star3" data-star="3"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>

                            <input class="star-input" type="radio" name="rating" value="4">
                            <label class="star-label" for="star4" data-star="4"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>

                            <input class="star-input" type="radio" name="rating" value="5">
                            <label class="star-label" for="star5" data-star="5"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>
                        </div>
                        <span>${loja.qtdAvaliacoes} avaliações</span>
                    </div>
                    <div id="slider-ratings-content">
                        <div id="user-comment">
                            <form action="avaliacao" method="post" id="user-rating-form">
                                <div id="user-comment-header">
                                    <h2>Sua avaliação</h2>
                                    <c:if test="${not empty avaliacaoUsuario}">
                                        <img src="imgs/lixeira.svg" alt="" id="delete">
                                    </c:if>
                                </div>
                                <textarea name="comentario" cols="30" rows="4" id="comment"
                                          placeholder="Fale sobre sua experiência com a loja" ${not empty avaliacaoUsuario ? "disabled" : ''}>${not empty avaliacaoUsuario ? avaliacaoUsuario.comentario : ''}</textarea>
                                <div id="user-comment-footer">
                                    <div id="user-rating" class="rating small ${ratingClass}" data-rating="${ratingValue}">
                                        <input class="star-input" type="radio" name="rating" value="1">
                                        <label class="star-label" for="star1" data-star="1"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>

                                        <input class="star-input" type="radio" name="rating" value="2">
                                        <label class="star-label" for="star2" data-star="2"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>

                                        <input class="star-input" type="radio" name="rating" value="3">
                                        <label class="star-label" for="star3" data-star="3"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>

                                        <input class="star-input" type="radio" name="rating" value="4">
                                        <label class="star-label" for="star4" data-star="4"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>

                                        <input class="star-input" type="radio" name="rating" value="5">
                                        <label class="star-label" for="star5" data-star="5"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>
                                    </div>

                                    <div class="button-container">
                                        <c:choose>
                                            <c:when test="${not empty avaliacaoUsuario}">
                                                <div class="botao">
                                                    <input type="submit" value="SALVAR" id="save" class="hidden" name="submit">
                                                </div>
                                                <div class="botao">
                                                    <input type="submit" value="EDITAR" id="edit">
                                                </div>
                                            </c:when>
                                            <c:otherwise>
                                                <div class="botao">
                                                    <input type="submit" name="submit" value="ENVIAR" id="rate">
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                    </div>
                                </div>
                                <input type="hidden" id="rating" name="rating" value="${not empty avaliacaoUsuario ? avaliacaoUsuario.nota : ''}">
                                <input type="hidden" id="default-message" value="${not empty avaliacaoUsuario ? avaliacaoUsuario.comentario : ''}">
                                <input type="hidden" id="default-rating" name="default-rating" value="${not empty avaliacaoUsuario ? avaliacaoUsuario.nota : ''}">
                                <input type="hidden" name="idLoja" value="${loja.id}">
                            </form>
                        </div>

                        <c:forEach items="${avaliacoes}" var="avaliacao">
                            <c:if test="${avaliacao.id ne avaliacaoUsuario.id}">
                                <div class="slider-ratings-comment">
                                    <h2>${avaliacao.idCliente}</h2>
                                    <p>${avaliacao.comentario}</p>
                                    <div class="slider-ratings-comment-footer">
                                        <div>
                                            <span>${avaliacao.nota}</span>
                                            <div class="rating process-rating small" data-rating="${avaliacao.nota}">
                                                <input class="star-input" type="radio" name="rating" value="1">
                                                <label class="star-label" for="star1" data-star="1"><img src="imgs/gray-star.svg"
                                                                                                         alt=""></label>

                                                <input class="star-input" type="radio" name="rating" value="2">
                                                <label class="star-label" for="star2" data-star="2"><img src="imgs/gray-star.svg"
                                                                                                         alt=""></label>

                                                <input class="star-input" type="radio" name="rating" value="3">
                                                <label class="star-label" for="star3" data-star="3"><img src="imgs/gray-star.svg"
                                                                                                         alt=""></label>

                                                <input class="star-input" type="radio" name="rating" value="4">
                                                <label class="star-label" for="star4" data-star="4"><img src="imgs/gray-star.svg"
                                                                                                         alt=""></label>

                                                <input class="star-input" type="radio" name="rating" value="5">
                                                <label class="star-label" for="star5" data-star="5"><img src="imgs/gray-star.svg"
                                                                                                         alt=""></label>
                                            </div>
                                        </div>
                                        <span><fmt:formatDate value="${avaliacao.data}" pattern="dd/MM/yyyy"/></span>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <script src="scripts/jquery/jquery.js"></script>

        <script type="module">
            import { initializeApp } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-app.js";
            import { getStorage, ref, getDownloadURL } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-storage.js";
            const firebaseConfig = {
                apiKey: "AIzaSyC6E9U_uW78MMsIf9oQKBTm5LjvRp6OB2A",
                authDomain: "restricted-d6b24.firebaseapp.com",
                databaseURL: "https://restricted-d6b24-default-rtdb.firebaseio.com",
                projectId: "restricted-d6b24",
                storageBucket: "restricted-d6b24.appspot.com",
                messagingSenderId: "351037789777",
                appId: "1:351037789777:web:5a43c6cd09be7a53d70a70",
                measurementId: "G-G0VFKP7XGK"
            };
            const app = initializeApp(firebaseConfig);
            function getImageUrlByName() {
                const storage = getStorage(app); // Corrigido para usar 'app' em vez de 'firebaseApp'
                let e = document.getElementById("emailFirebase");
                const storageRef = ref(storage, 'lojaFoto/' + e.value);//Alteração
                return getDownloadURL(storageRef)
                        .then(downloadURL => {
                            return downloadURL;
                        })
                        .catch(error => {
                            console.error('Error getting download URL:', error);
                            return null;
                        });
            }

            document.addEventListener("DOMContentLoaded", async function () {
                let imageUrl = await getImageUrlByName();
                const imgElement = document.getElementById('bannerLojaF');
                const imgElement2 = document.getElementById('imgLojaF');

                if (imageUrl !== null) {
                    imgElement.src = imageUrl;
                    imgElement2.src = imageUrl;
                }
            });
        </script>

        <script>
            const configuracoesAcessibilidade = [
                '${acessibilidade.temaEscuro}' !== 'false',
                '${acessibilidade.contraste}' !== 'false',
                '${acessibilidade.visibilidadeTexto}' !== 'false',
                (parseInt('${acessibilidade.tamanhoTexto}') / 100)
            ];
        </script>

        <script src="scripts/rating.js"></script>
        <script src="scripts/loja/favoritar.js"></script>
        <script src="scripts/loja/userRating.js"></script>
        <script src="scripts/carrossel.js"></script>
        <script src="scripts/janelas-modais/slider.js"></script>
        <script src="scripts/janelas-modais/modal.js"></script>
        <script src="scripts/acessibilidade/acessibilidade.js"></script>
    </body>
</html>
