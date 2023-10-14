<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" href="styles/main.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="stylesheet" type="text/css" href="styles/gerenciarconta.css">
        <link rel="stylesheet" href="styles/rodape.css">
        <link rel="icon" type="image/png" href="styles/imgs/icon.png" />
    </head>

    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        
        <header id="navbar">
            <img id="navbar-logo" src="imgs/logo3.png" alt="Logo">
            <div id="navbar-menu">
                <a class="navbar-link" href="menuprincipal.jsp">Início</a>
                <a class="navbar-link" href="#">Favoritos</a>
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
                            <li><img src="imgs/header/engrenagem.svg" alt="">Dados</li>
                            <li><img src="imgs/header/pedido.svg" alt="">Pedidos</li>
                            <li><img src="imgs/header/chat.svg" alt="">Conversas</li>
                            <li><img src="imgs/header/coracao.svg" alt="">Favoritos</li>
                            <li><img src="imgs/header/acessibilidade.svg" alt="">Acessibilidade</li>
                            <li><img src="imgs/header/sair.svg" alt="">Sair</li>
                        </ul>
                    </div>
                </div>
                <div id="orders">
                    <img id="orders-pic" src="imgs/header/sacola.png" alt="Pedidos">
                    <div id="orders-info">
                        <p>R$ 0,00</p>
                        <p>0 itens</p>
                    </div>
                </div>
            </div>
        </header>
                        
        <main>
            <section>
                <h1>Acessibilidade</h1>
                <ul>
                    <li>
                        <p>Tema escuro</p>
                        <div class="opcao-body">
                            <p>Ativar o tema escuro</p>
                            <input type="checkbox" id="tema" name="tema" class="checkbox">
                        </div>
                    </li>
                    <li>
                        <p>Contraste</p>
                        <div class="opcao-body">
                            <p>Aumentar o contraste dos elementos da página</p>
                            <input type="checkbox" id="contraste" name="contraste" class="checkbox">
                        </div>
                    </li>
                    <li>
                        <p>Visibilidade do texto</p>
                        <div class="opcao-body">
                            <p>Tornar os textos mais visíveis</p>
                            <input type="checkbox" id="negrito" name="negrito" class="checkbox">
                        </div>
                    </li>
                    <li>
                        <p>Tamanho do texto</p>
                        <div class="range-container">
                            <input type="range" min="100" max="200" value="100" class="range" id="range-escala">
                            <div id="valor-container">
                                <div id="valor-subcontainer">
                                    <h4>0<span></span></h4>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </section>
        </main>

        <script>
            const temaEscuro = false;
            const contraste = false;
            const negrito = false;
            const tamanho = 1;
        </script>
        <script src="scripts/modal.js"></script>
        <script src="scripts/rangeinput.js"></script>
        <script src="scripts/acessibilidade.js"></script>

    </body>

</html>
