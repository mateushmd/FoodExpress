<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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
        <link rel="stylesheet" type="text/css" href="styles/main/modal.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>
    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <c:set var="sacola" value="${sessionScope.sacola}"/>
        <c:set var="acessibilidade" value="${sessionScope.acessibilidade}"/>
        <c:set var="loja" value="${requestScope.loja}"/>
        <c:set var="categorias" value="${requestScope.categorias}"/>
        <c:set var="destaques" value="${requestScope.destaques}"/>
        <c:set var="avaliacoes" value="${requestScope.avaliacoes}"/>
        <c:set var="avaliacaoUsuario" value="${requestScope.avaliacaoUsuario}"/>
        <c:set var="favorito" value="${requestScope.favorito}"/>
        <c:set var="agenda" value="${requestScope.agenda}"/>
        <c:set var="telefone" value="${requestScope.telefone}"/>
        <c:set var="pontos" value="${requestScope.pontos}"/>
        <c:set var="diaDaSemanaAutal" value="${requestScope.diaDaSemanaAtual}"/>

        <c:set var="ratingClass" value="${not empty avaliacaoUsuario ? 'process-rating disabled' : ''}"/>
        <c:set var="ratingValue" value="${not empty avaliacaoUsuario ? avaliacaoUsuario.nota : 0}"/>

        <input type="hidden" id="emailFirebase" value="${loja.idUser}">
        <input type="hidden" id="avaliacao" value="<fmt:formatNumber value="${loja.avaliacao}" type="number" pattern="#,##0.0" />">
        <input type="hidden" id="id-usuario" value="${usuario.email}">

        <header id="navbar">
            <img id="navbar-logo" src="imgs/logo3.png" alt="Logo">
            <div id="navbar-menu">
                <a class="navbar-link" href="inicio.jsp">Início</a>
                <a class="navbar-link" href="meus-favoritos">Favoritos</a>
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
                </div>
                <div id="orders">
                    <img id="orders-pic" src="imgs/header/sacola.svg" class="slider-trigger" data-slider-index="0" alt="Pedidos">
                    <div id="orders-info">
                        <p>R$ <span id="orders-preco"><fmt:formatNumber value="${sacola.total}" type="number" pattern="0.00" /></span></p>
                        <p><span id="orders-quantidade">${sacola.quantidade}</span> ${sacola.quantidade eq 1 ? 'item' : 'itens'}</p>
                    </div>
                </div>
            </div>
        </header>

        <div id="modal-perfil" class="modal hidden" data-modal-index="0">
            <button class="close-modal styled">
                <img src="imgs/x-symbol.svg" alt="">
            </button>
            <div>
                <h2>Olá ${usuario.nome}</h2>
                <ul>
                    <li><a href="dados.jsp"><img src="imgs/header/engrenagem.svg" alt="">Dados</a></li>
                    <li><a href="meus-pedidos"><img src="imgs/header/pedido.svg" alt="">Pedidos</a></li>
                    <li><a href="meus-favoritos"><img src="imgs/header/coracao.svg" alt="">Favoritos</a></li>
                    <li><a href="acessibilidade.jsp"><img src="imgs/header/acessibilidade.svg" alt="">Acessibilidade</a>
                    </li>
                    <li><a href="logout"><img src="imgs/header/sair.svg" alt="">Sair</a></li>
                </ul>
            </div>
        </div>

        <header id="navbar-responsive" class="hidden">
            <div>
                <img src="imgs/header/house.svg" alt="">
                <p>Início</p>
            </div>
            <div>
                <img src="imgs/lupa-azul.svg" alt="">
                <p>Buscar</p>
            </div>
            <div class="slider-trigger" data-slider-index="0">
                <img src="imgs/header/sacola.svg" alt="">
                <p>Sacola</p>
            </div>
            <div class="modal-trigger" data-modal-index="0">
                <img src="imgs/header/icone-perfil.png" alt="">
                <p>Perfil</p>
            </div>
        </header>

        <div id="overlay" class="hidden"></div>

        <div id="modal-produto" class="modal generic hidden" data-modal-index="1" data-lock-screen="true">
            <input type="hidden" id="modal-produto-id" value="">
            <button class="modal-produto-botao close-modal styled">
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
                                <p id="modal-produto-nome-loja">${loja.nome}</p>
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
                    <img src="imgs/teste/teste.png" alt="">
                </div>
            </div>
        </div>

        <main>
            <section id="banner">
                <img src="imgs/teste/teste.png" alt="" id="bannerLojaF">
            </section>
            <section id="info">
                <div>
                    <img src="imgs/teste/teste.png" alt="" id="imgLojaF">
                    <h1>${loja.nome}</h1>
                    <div class="info-rating slider-trigger" data-slider-index="1">
                        <img src="imgs/star.svg" alt="">
                        <p><fmt:formatNumber value="${loja.avaliacao}" type="number" pattern="#,##0.0" /> (${loja.qtdAvaliacoes})</p>
                    </div>
                    <div class="favorite">
                        <button type="submit" class="${favorito eq true ? 'active' : ''}">♥</button>
                        <input type="hidden" name="id" value="${loja.id}">
                    </div>
                    <div class="disponibilidade ${loja.aberto ? 'aberto' : 'fechado'}">
                        <svg viewBox="0 0 100 100" fill="${loja.aberto ? 'green' : 'red'}" xmlns="http://www.w3.org/2000/svg">
                            <circle cx="50" cy="50" r="50"></circle>
                        </svg>
                        <p>${loja.aberto ? 'Aberto' : 'Fechado'}</p>
                    </div>
                </div>
                <div>
                    <p class="slider-trigger" data-slider-index="2">Ver mais</p>
                    <p>|</p>
                    <div id="conversar" class="whatsapp" data-numero="${telefone}">
                        <p>Conversar</p>
                        <i class="fa fa-whatsapp"></i>
                    </div>
                    <p>|</p>
                    <img src="imgs/denunciar.svg" alt="" class="denunciar denunciar-btn modal-trigger" data-modal-index="10">
                </div>
            </section>

            <c:choose>
                <c:when test="${not empty categorias}">
                    <section id="pesquisa">
                        <div id="container-input">
                            <img src="imgs/lupa-azul.svg" alt="">
                            <input type="text" placeholder="Buscar no cardápio">
                        </div>
                        <div id="container-select">
                            <select name="ponto-encontro" id="ponto-encontro">
                                <c:choose>
                                    <c:when test="${pontos eq null}">
                                        <option value="-2">Loja fechada</option>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${empty pontos}">
                                                <option value="-1">Sem ponto de encontro</option>
                                            </c:when>
                                            <c:otherwise>
                                                <c:forEach items="${pontos}" var="ponto" varStatus="loop">
                                                    <option value="${ponto.id}" ${loop.index eq 0 ? 'selected' : ''}>${ponto.nome}</option>
                                                </c:forEach>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>
                    </section>
                    <c:if test="${destaques ne null}">
                        <section id="destaques" class="content">
                            <h1>DESTAQUES</h1>
                            <div class="carousel-container fit-product" data-items="3" data-index="0">
                                <div class="arrow arrow-rounded left-arrow"><img src="imgs/carrossel/seta.svg" alt=""></div>
                                <div class="carousel" data-index="0">
                                    <c:forEach items="${destaques}" var="produto">
                                        <div class="item fit-product modal-trigger" data-modal-index="1">
                                            <input type="hidden" class="id-produto" value="${produto.id}">
                                            <div class="img-container">
                                                <img src="imgs/teste/teste.png" alt="${produto.nome}">
                                            </div>
                                            <div class="info-container">
                                                <div class="info-container-header">
                                                    <h2 class="font-707 nome">${produto.nome}</h2>
                                                </div>
                                                <div class="info-container-body">
                                                    <p class="descricao">${produto.descricao}</p>
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
                    </c:if>
                    <section id="produtos">
                        <c:forEach items="${categorias}" var="categoria">
                            <h1>${categoria.nome}</h1>
                            <div class="categoria">
                                <c:forEach items="${categoria.produtos}" var="produto">
                                    <div class="produto modal-trigger" data-modal-index="1">
                                        <input type="hidden" class="id-produto" value="${produto.id}">
                                        <div class="info-produto">
                                            <h2 class="font-707 nome">${produto.nome}</h2>
                                            <p class="descricao">${produto.descricao}</p>
                                            <p class="preco">R$<fmt:formatNumber value='${produto.preco}' pattern='0.00' /></p>
                                        </div>
                                        <div class="img-container">
                                            <img src="imgs/teste/teste.png" alt="${produto.nome}">
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </c:forEach>
                    </section>
                </c:when>
                <c:otherwise>
                    <section id="vazio">
                        <img src="imgs/loja/em-construcao.svg" alt="">
                        <h2>Opa!</h2>
                        <p>Parece que esta loja ainda está em construção! Não esqueça de usar um capacete!</p>
                    </section>
                </c:otherwise>
            </c:choose>
        </main>
        <footer>
            <div class="container-footer">
                <div class="row-footer">
                    <div class="footer-col">
                        <h4>Menu</h4>
                        <ul>
                            <li><a href="inicio.jsp"> Inicio</a></li>
                            <li><a href="dados.jsp">Perfil</a></li>
                            <li><a href="sobre.jsp">Sobre</a></li>
                        </ul>
                    </div>
                    <div class="footer-col">
                        <h4>Obter ajuda</h4>
                        <ul>
                            <li><a href="faq.jsp">FAQ</a></li>
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

                            <a href="https://www.instagram.com/cfoodexpress/"> <i class="fa fa-instagram"></i> </a>
                            <a href="https://twitter.com/CFoodExpress_"> <i class="fa fa-twitter"></i> </a>
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

            <div id="slider-content">
                <div class="slider-container hidden">
                    <div id="bag">
                        <!--Template para clonagem em scripts-->
                        <div class="bag-produto clone hidden">
                            <div class="bag-produto-header">
                                <p><span class="bag-produto-quantidade">0</span>x <span class="bag-produto-nome"></span></p>
                                <p class="preco">R$ <span class="bag-produto-preco"></span></p>
                            </div>
                            <div class="bag-produto-body">
                                <p class="bag-produto-descricao"></p>
                            </div>
                            <div class="bag-produto-footer">
                                <input type="submit" value="Remover" class="bag-remover-produto">
                            </div>
                        </div>

                        <div id="empty-bag" class="${empty sacola.itens ? '' : 'hidden'}">
                            <div id="empty-bag-img-container">
                                <img src="imgs/header/sacola.svg" alt="">
                                <img src="imgs/x-symbol.svg" alt="">
                            </div>
                            <h2>Sua sacola está vazia</h2>
                            <p>Adicione itens para comprar</p>
                        </div>
                        <div id="bag-container" class="${empty sacola.itens ? 'hidden' : ''}">
                            <div id="bag-header">
                                <p>Seu pedido</p>
                                <div>
                                    <h2 id="bag-nome">${sacola.nomeLoja}</h2>
                                    <a id="bag-anchor" href="loja?id=${sacola.idLoja}">Ir para a loja</a>
                                </div>
                            </div>
                            <div id="bag-body">
                                <div class="bag-produtos">
                                    <p>Produtos</p>
                                    <c:forEach items="${sacola.itens}" var="item">
                                        <div class="bag-produto" data-id-produto="${item.produtoId}" data-id-item="${item.itemSacolaId}">
                                            <div class="bag-produto-header">
                                                <p><span class="bag-produto-quantidade">${item.quantidade}</span>x <span class="bag-produto-nome">${item.produtoNome}</span></p>
                                                <p class="preco">R$ <span class="bag-produto-preco"><fmt:formatNumber value='${item.precoTotal}' pattern='0.00' /></span></p>
                                            </div>
                                            <div class="bag-produto-body">
                                                <p class="bag-produto-descricao">${item.produtoDescricao}</p>
                                            </div>
                                            <div class="bag-produto-footer">
                                                <input type="submit" value="Remover" class="bag-remover-produto">
                                            </div>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                            <div id="bag-footer">
                                <div>
                                    <p>Total</p>
                                    <p class="preco">R$ <span id="bag-preco"><fmt:formatNumber value='${sacola.total}' pattern='0.00'/></span></p>
                                </div>
                                <div id="opcoes-pedido">
                                    <button id="fazer-pedido">
                                        <p>Pedir</p>
                                    </button>
                                    <div id="select">
                                        <select name="" id="pontos-pedido">
                                            <c:choose>
                                                <c:when test="${sacola.pontos eq null}">
                                                    <option value="-2" selected>Loja fechada</option>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:choose>
                                                        <c:when test="${empty sacola.pontos}">
                                                            <option value="-1">Sem ponto de encontro</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:forEach items="${sacola.pontos}" var="ponto" varStatus="loop">
                                                                <option value="${ponto.id}" ${loop.index eq 0 ? 'selected' : ''}>${ponto.nome}</option>
                                                            </c:forEach>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:otherwise>
                                            </c:choose>
                                        </select>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="slider-container hidden">
                    <div id="slider-ratings">
                        <div id="slider-ratings-header">
                            <h2 class="font-707">Avaliações</h2>
                            <span>${loja.nome}</span>
                            <h1><fmt:formatNumber value="${loja.avaliacao}" type="number" pattern="#,##0.0" /></h1>
                            <div class="rating process-rating" data-rating="<fmt:formatNumber value="${loja.avaliacao}" type="number" maxFractionDigits="0"/>">
                                <input class="star-input" type="radio" name="rating" value="1">
                                <label class="star-label" data-star="1"><img src="imgs/gray-star.svg"
                                                                             alt=""></label>

                                <input class="star-input" type="radio" name="rating" value="2">
                                <label class="star-label" data-star="2"><img src="imgs/gray-star.svg"
                                                                             alt=""></label>

                                <input class="star-input" type="radio" name="rating" value="3">
                                <label class="star-label" data-star="3"><img src="imgs/gray-star.svg"
                                                                             alt=""></label>

                                <input class="star-input" type="radio" name="rating" value="4">
                                <label class="star-label" data-star="4"><img src="imgs/gray-star.svg"
                                                                             alt=""></label>

                                <input class="star-input" type="radio" name="rating" value="5">
                                <label class="star-label" data-star="5"><img src="imgs/gray-star.svg"
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
                                            <label class="star-label" data-star="1"><img src="imgs/gray-star.svg"
                                                                                         alt=""></label>

                                            <input class="star-input" type="radio" name="rating" value="2">
                                            <label class="star-label" data-star="2"><img src="imgs/gray-star.svg"
                                                                                         alt=""></label>

                                            <input class="star-input" type="radio" name="rating" value="3">
                                            <label class="star-label" data-star="3"><img src="imgs/gray-star.svg"
                                                                                         alt=""></label>

                                            <input class="star-input" type="radio" name="rating" value="4">
                                            <label class="star-label" data-star="4"><img src="imgs/gray-star.svg"
                                                                                         alt=""></label>

                                            <input class="star-input" type="radio" name="rating" value="5">
                                            <label class="star-label" data-star="5"><img src="imgs/gray-star.svg"
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
                                        <img class="denunciar-avaliacao denunciar-btn modal-trigger" src="imgs/denunciar.svg" alt="" data-modal-index="10">
                                        <h2>${avaliacao.idCliente}</h2>
                                        <p>${avaliacao.comentario}</p>
                                        <div class="slider-ratings-comment-footer">
                                            <div>
                                                <span>${avaliacao.nota}</span>
                                                <div class="rating process-rating small" data-rating="${avaliacao.nota}">
                                                    <input class="star-input" type="radio" name="rating" value="1">
                                                    <label class="star-label" data-star="1"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>

                                                    <input class="star-input" type="radio" name="rating" value="2">
                                                    <label class="star-label" data-star="2"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>

                                                    <input class="star-input" type="radio" name="rating" value="3">
                                                    <label class="star-label" data-star="3"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>

                                                    <input class="star-input" type="radio" name="rating" value="4">
                                                    <label class="star-label" data-star="4"><img src="imgs/gray-star.svg"
                                                                                                 alt=""></label>

                                                    <input class="star-input" type="radio" name="rating" value="5">
                                                    <label class="star-label" data-star="5"><img src="imgs/gray-star.svg"
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
                <div class="slider-container hidden">
                    <div id="slider-informacoes">
                        <div id="descricao">
                            <h2>Descrição</h2>
                            <c:choose>
                                <c:when test="${loja.descricao ne null and loja.descricao.blank eq false}">
                                    <p class="descricao reduzido">${loja.descricao}</p>
                                    <p class="see-more" data-target="descricao">Ver mais</p>
                                </c:when>
                                <c:otherwise>
                                    <p>Sem descrição.</p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div>
                            <h2>Horários</h2>
                            <div id="horarios">
                                <c:choose>
                                    <c:when test="${not empty agenda}">
                                        <c:forEach items="${agenda}" var="horario">
                                            <div class="horario">
                                                <c:if test="${diaDaSemanaAutal eq horario.diaSemana}">
                                                    <svg width="14" height="14" viewBox="0 0 14 14" fill="none"
                                                         xmlns="http://www.w3.org/2000/svg">
                                                        <path
                                                                d="M6.99325 0.333008C3.31992 0.333008 0.333252 3.31967 0.333252 6.99301C0.333252 10.6663 3.31992 13.653 6.99325 13.653C10.6666 13.653 13.6532 10.6663 13.6532 6.99301C13.6532 3.31967 10.6599 0.333008 6.99325 0.333008ZM9.65992 8.15301H6.32658C6.05325 8.15301 5.82658 7.92634 5.82658 7.65301V4.19967C5.82658 3.92634 6.05325 3.69967 6.32658 3.69967C6.59992 3.69967 6.82658 3.91967 6.82658 4.19967V7.15301H9.65992C9.93325 7.15301 10.1599 7.37967 10.1599 7.65301C10.1599 7.92634 9.93325 8.15301 9.65992 8.15301Z"
                                                                fill="#cc575f"></path>
                                                    </svg>
                                                </c:if>
                                                <p>${horario.diaSemanaString}</p>
                                                <p>${fn:substring(horario.abertura.toString(), 0, 5) } às ${fn:substring(horario.fechamento.toString(), 0, 5)}</p>
                                                <p>${horario.campus1 ? 'Campus 1' : 'Campus 2'}</p>
                                            </div>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <p>Esta loja ainda não disponibilizou os horários de funcionamento.</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal hidden" id="alerta" data-modal-index="3" data-lock-screen="true">
            <h1>Atenção</h1>
            <p id="msg"></p>
            <div>
                <button class="botao close-modal" id="alerta-sim">OK</button>
            </div>
        </div>

        <div class="modal hidden" id="denuncia" data-modal-index="10" data-lock-screen="true">
            <h1>Denúncia</h1>
            <p>Sentimos muito pela inconveniência. Envie um e-mail para equipefoodexpress@gmail.com contendo a sua denúncia.
            Para facilitar, adicione imagens que comprovam a infração. Obrigado por nos ajudar!</p>
            <div>
                <button class="botao close-modal">FECHAR</button>
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
                const storageRef = ref(storage, 'lojaBanner/' + e.value);//Alteração
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

                if (imageUrl !== null) {
                    imgElement.src = imageUrl;
                }
            });
        </script>

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
                const storageRef = ref(storage, 'lojaPerfil/' + e.value);//Alteração
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
                const imgElement2 = document.getElementById('imgLojaF');

                if (imageUrl !== null) {
                    imgElement2.src = imageUrl;
                }
            });
        </script>

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
                let e = document.getElementById("imgLojaF");
                const imgElements = document.querySelectorAll('.img-container img');
                imgElements.forEach(async imgElement => {
                    const altText = imgElement.getAttribute('alt');
                    console.log(altText);
                    let email = document.getElementById("emailFirebase");
                    const storageRef = ref(storage, 'ProdutoFoto/'+ email.value + "/" + altText);

                    try {
                        const imageUrl = await getDownloadURL(storageRef);
                        if (imageUrl) {
                            imgElement.src = imageUrl;
                        } else {
                            console.log("Erro ao carregar a imagem para o email:", altText);
                        }
                    } catch (error) {
                        console.error('Erro ao obter URL de download:', error);
                    }
                });
            }

            document.addEventListener("DOMContentLoaded", async function () {
                getImageUrlByName();
            });
        </script>

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
                let e = document.getElementById("imgLojaF");
                const imgElements = document.querySelectorAll('.img-produto');
                imgElements.forEach(async imgElement => {
                    const altText = imgElement.getAttribute('alt');
                    console.log(altText);
                    let email = document.getElementById("emailFirebase");
                    const storageRef = ref(storage, 'ProdutoFoto/'+ email.value + "/" + altText);

                    try {
                        const imageUrl = await getDownloadURL(storageRef);
                        if (imageUrl) {
                            imgElement.src = imageUrl;
                        } else {
                            console.log("Erro ao carregar a imagem para o email:", altText);
                        }
                    } catch (error) {
                        console.error('Erro ao obter URL de download:', error);
                    }
                });
            }

            document.addEventListener("DOMContentLoaded", async function () {
                getImageUrlByName();
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

        <script src="scripts/jquery/jquery.js"></script>
        <script src="scripts/rating.js"></script>
        <script type="module" src="scripts/sacola/adicionarSacola.js"></script>
        <script type="module" src="scripts/sacola/removerSacola.js"></script>
        <script type="module" src="scripts/sacola/fazerPedido.js"></script>
        <script src="scripts/loja/favoritar.js"></script>
        <script src="scripts/loja/userRating.js"></script>
        <script src="scripts/carrossel.js"></script>
        <script src="scripts/janelas-modais/slider.js"></script>
        <script type="module" src="scripts/janelas-modais/modal.js"></script>
        <script src="scripts/usuario/acessibilidade/acessibilidade.js"></script>
        <script src="scripts/busca.js"></script>
        <script src="scripts/responsiveNavBar.js"></script>
        <script type="module" src="scripts/whatsAppLinker.js"></script>
    </body>
</html>
