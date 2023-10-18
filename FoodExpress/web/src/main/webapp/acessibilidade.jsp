<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" href="styles/main.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="stylesheet" type="text/css" href="styles/gerenciarconta.css">
        <link rel="stylesheet" href="styles/footer.css">
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>

    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <c:set var="acessibilidade" value="${sessionScope.acessibilidade}"/>

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
                            <li><a href=""><img src="imgs/header/engrenagem.svg" alt="">Dados</a></li>
                            <li><a href=""><img src="imgs/header/pedido.svg" alt="">Pedidos</a></li>
                            <li><a href=""><img src="imgs/header/chat.svg" alt="">Conversas</a></li>
                            <li><a href="favoritos.jsp"><img src="imgs/header/coracao.svg" alt="">Favoritos</a></li>
                            <li><a href="acessibilidade.jsp"><img src="imgs/header/acessibilidade.svg" alt="">Acessibilidade</a></li>
                            <li><a href=""><img src="imgs/header/sair.svg" alt="">Sair</a></li>
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

        <script>
            const configuracoesAcessibilidade = [
                '${acessibilidade.temaEscuro}' !== 'false',
                '${acessibilidade.contraste}' !== 'false',
                '${acessibilidade.visibilidadeTexto}' !== 'false',
                (parseInt('${acessibilidade.tamanhoTexto}') / 100)
            ];

            console.log(configuracoesAcessibilidade);
        </script>
        <script src="scripts/modal.js"></script>
        <script src="scripts/rangeinput.js"></script>
        <script src="scripts/acessibilidade.js"></script>

    </body>

</html>
