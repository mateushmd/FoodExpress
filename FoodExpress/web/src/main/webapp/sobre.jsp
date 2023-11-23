<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>FoodExpress</title>
    <link rel="stylesheet" type="text/css" href="styles/main/main.css">
    <link rel="stylesheet" href="styles/main/header.css">
    <link rel="stylesheet" href="styles/main/footer.css">
    <link rel="stylesheet" type="text/css" href="styles/paginasinformacionais.css">
    <link rel="stylesheet" type="text/css" href="styles/slider.css">
    <link rel="icon" type="image/png" href="imgs/icon.png" />
</head>

<body>
<c:set var="usuario" value="${sessionScope.usuario}"/>
<c:set var="sacola" value="${sessionScope.sacola}"/>
<c:set var="acessibilidade" value="${sessionScope.acessibilidade}"/>

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

<main>
    <h2>Sobre o FoodExpress</h2>
    <section>
        <p>O FoodExpress é uma aplicação desenvolvida por estudantes do 3º ano do curso de Informática,
        no Centro Federal de Educação Tecnológica de Minas Gerais. Ele foi criado com o intuito de promover um melhor ambiente para
        vendas independentes, majoritariamente em escolas e universidades. Além disso, ele também tem como objetivo servir como incentivo
        para aqueles que pretendem fazer algo do tipo. Essencialmente, o FoodExpress é benéfico para tanto quem deseja comprar algo, quanto
        para quem deseja vender.</p>
    </section>
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
                    <a href="#"> <i class="fa fa-instagram"></i> </a>
                    <a href="#"> <i class="fa fa-twitter"></i> </a>
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
        <div class="slider-container hidden">
            <div id="bag">
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
                            <h2>${sacola.nomeLoja}</h2>
                            <a href="loja?id=${sacola.idLoja}">Ir para a loja</a>
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
                                            <option value="-2">Loja fechada</option>
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
    </div>
</div>

<script>
    const configuracoesAcessibilidade = [
        '${acessibilidade.temaEscuro}' !== 'false',
        '${acessibilidade.contraste}' !== 'false',
        '${acessibilidade.visibilidadeTexto}' !== 'false',
        (parseInt('${acessibilidade.tamanhoTexto}') / 100)
    ];
</script>

<script src="scripts/jquery/jquery.js"></script>
<script type="module" src="scripts/sacola/removerSacola.js"></script>
<script type="module" src="scripts/sacola/fazerPedido.js"></script>
<script type="module" src="scripts/janelas-modais/modal.js"></script>
<script src="scripts/usuario/acessibilidade/acessibilidade.js"></script>
<script src="scripts/janelas-modais/slider.js"></script>
<script src="scripts/busca.js"></script>
<script src="scripts/responsiveNavBar.js"></script>
</body>

</html>
