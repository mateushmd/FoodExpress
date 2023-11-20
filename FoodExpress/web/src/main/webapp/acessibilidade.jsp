<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" href="styles/main/main.css">
        <link rel="stylesheet" type="text/css" href="styles/main/header.css">
        <link rel="stylesheet" type="text/css" href="styles/gerenciarconta.css">
        <link rel="stylesheet" href="styles/main/footer.css">
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
                    <div id="modal-perfil" class="modal hidden" data-modal-index="0">
                        <h2>Olá ${usuario.nome}</h2>
                        <ul>
                            <li><a href="dados.jsp"><img src="imgs/header/engrenagem.svg" alt="">Dados</a></li>
                            <li><a href=""><img src="imgs/header/pedido.svg" alt="">Pedidos</a></li>
                            <li><a href=""><img src="imgs/header/chat.svg" alt="">Conversas</a></li>
                            <li><a href="meus-favoritos"><img src="imgs/header/coracao.svg" alt="">Favoritos</a></li>
                            <li><a href="acessibilidade.jsp"><img src="imgs/header/acessibilidade.svg" alt="">Acessibilidade</a></li>
                            <li><a href="logout"><img src="imgs/header/sair.svg" alt="">Sair</a></li>
                        </ul>
                    </div>
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

        <main>
            <section>
                <form action="acessibilidade" method="post">
                    <h1>Acessibilidade</h1>
                    <ul>
                        <li>
                            <p>Tema escuro</p>
                            <div class="opcao-body">
                                <p>Ativar o tema escuro</p>
                                <input type="checkbox" id="tema" name="tema" class="checkbox acessibilidade" ${acessibilidade.temaEscuro ? "checked" : ""}>
                            </div>
                        </li>
                        <li>
                            <p>Contraste</p>
                            <div class="opcao-body">
                                <p>Aumentar o contraste dos elementos da página</p>
                                <input type="checkbox" id="contraste" name="contraste" class="checkbox acessibilidade" ${acessibilidade.contraste ? "checked" : ""}>
                            </div>
                        </li>
                        <li>
                            <p>Visibilidade do texto</p>
                            <div class="opcao-body">
                                <p>Tornar os textos mais visíveis</p>
                                <input type="checkbox" id="negrito" name="visibilidade" class="checkbox acessibilidade" ${acessibilidade.visibilidadeTexto ? "checked" : ""}>
                            </div>
                        </li>
                        <li>
                            <p>Tamanho do texto</p>
                            <div class="range-container">
                                <input type="range" min="100" max="200" value="${acessibilidade.tamanhoTexto}" name="tamanho" class="range acessibilidade" id="range-escala">
                                <div id="valor-container">
                                    <div id="valor-subcontainer">
                                        <h4>0<span></span></h4>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>

                    <div class="botao">
                        <input type="submit" value="SALVAR" id="save" name="SUBMIT">
                    </div>
                </form>
            </section>
        </main>

        <div id="slider">
            <button id="close-slider">
                <img src="imgs/x-symbol.svg" alt="">
            </button>

            <div class="slider-content">
                <div class="slider-container">
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
                                <button>
                                    <p>Realizar pedido</p>
                                </button>
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

            console.log(configuracoesAcessibilidade);
        </script>

        <script src="scripts/jquery/jquery.js"></script>
        <script type="module" src="scripts/sacola/removerSacola.js"></script>
        <script type="module" src="scripts/janelas-modais/modal.js"></script>
        <script src="scripts/rangeinput.js"></script>
        <script src="scripts/usuario/acessibilidade/acessibilidade.js"></script>
        <script src="scripts/janelas-modais/slider.js"></script>
        <script src="scripts/busca.js"></script>
    </body>

</html>
