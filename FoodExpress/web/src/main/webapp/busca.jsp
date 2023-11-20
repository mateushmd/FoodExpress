<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/main/main.css">
        <link rel="stylesheet" type="text/css" href="styles/busca.css">
        <link rel="stylesheet" type="text/css" href="styles/main/header.css">
        <link rel="stylesheet" type="text/css" href="styles/main/footer.css">
        <link rel="stylesheet" type="text/css" href="styles/slider.css">
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>

    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <c:set var="sacola" value="${sessionScope.sacola}"/>
        <c:set var="acessibilidade" value="${sessionScope.acessibilidade}"/>
        <c:set var="busca" value="${requestScope.busca}"/>
        <c:set var="resultado" value="${requestScope.resultado}"/>

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


                            <li><a  id="conversasBtn"><img src="imgs/header/chat.svg" alt="">Conversas</a></li>
                            <input style="display: none" id="meuInput" value="${usuario.email}">
                            <script>
                                document.getElementById('conversasBtn').onclick = function () {
                                    var valor = document.getElementById('meuInput').value;
                                    window.location.href = 'conversas.jsp?valor=' + encodeURIComponent(valor);
                                };
                            </script>
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

        <header id="navbar-responsive" class="hidden">
            <div>
                <img src="imgs/header/house.svg" alt="">
                <p>Início</p>
            </div>
            <div>
                <img src="imgs/lupa-azul.svg" alt="">
                <p>Buscar</p>
            </div>
            <div>
                <img src="imgs/header/icone-perfil.png" alt="">
                <p>Perfil</p>
            </div>
        </header>

        <main>
            <h1>Buscando por <span>${busca}</span></h1>

            <c:choose>
                <c:when test="${empty resultado}">
                    <section class="mensagem">
                        <img src="imgs/sad.svg" alt="">
                        <h2>Oh não!</h2>
                        <p>Não encontramos nenhum resultado para a sua busca.</p>
                    </section>
                </c:when>
                <c:otherwise>
                    <section class="busca">
                        <c:forEach items="${resultado}" var="loja">
                            <div class="loja" data-id="${loja.id}">
                                <img src="imgs/teste/teste.jpg" class="img-loja" alt="">
                                <div class="loja-body">
                                    <h2>${loja.nome}</h2>
                                    <div class="avaliacao">
                                        <img src="imgs/star.svg" alt="">
                                        <p>${loja.avaliacao}</p>
                                    </div>
                                    <div class="disponibilidade ${loja.aberto ? 'aberto' : 'fechado'}">
                                        <svg viewBox="0 0 100 100" fill="${loja.aberto ? 'green' : 'red'}" xmlns="http://www.w3.org/2000/svg">
                                            <circle cx="50" cy="50" r="50"></circle>
                                        </svg>
                                        <p>${loja.aberto ? 'Aberto' : 'Fechado'}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </section>
                </c:otherwise>
            </c:choose>
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
        </script>

        <script src="scripts/jquery/jquery.js"></script>
        <script type="module" src="scripts/sacola/removerSacola.js"></script>
        <script src="scripts/usuario/acessibilidade/acessibilidade.js"></script>
        <script src="scripts/janelas-modais/slider.js"></script>
        <script type="module" src="scripts/janelas-modais/modal.js"></script>
        <script src="scripts/busca.js"></script>
        <script type="module" src="scripts/loja/acessar.js"></script>
        <script src="scripts/responsiveNavBar.js"></script>
    </body>
</html>
