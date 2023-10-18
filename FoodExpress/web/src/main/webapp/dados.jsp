<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="stylesheet" type="text/css" href="styles/gerenciarconta.css">
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>

    <body>
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
                            <li><a href="dados.jsp"><img src="imgs/header/engrenagem.svg" alt="">Dados</a></li>
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
                <form action="">
                    <h1>Dados pessoais</h1>
                    <ul>
                        <li>
                            <p>Nome</p>
                            <div class="opcao-body">
                                <input type="text" class="editavel">
                            </div>
                        </li>
                        <li>
                            <p>E-mail</p>
                            <div class="opcao-body">
                                <input type="text" value="chenri48155@gmail.com" disabled>
                            </div>
                        </li>
                        <li>
                            <p>Telefone</p>
                            <div class="opcao-body">
                                <input type="text" class="editavel">
                            </div>
                        </li>
                    </ul>
                    <div id="botao-container">
                        <div class="botao">
                            <input type="submit" value="ALTERAR SENHA" id="senha">
                        </div>
                        <div class="botao">
                            <input type="submit" value="SALVAR" id="save" class="hidden" name="SUBMIT">
                        </div>
                    </div>

                    <input type="hidden" value="Mateus Henrique" id="default-nome" class="default">
                    <input type="hidden" value="31 99389-5154" id="default-telefone" class="default">
                </form>
            </section>
        </main>

        <script>
            const configuracoesAcessibilidade = [
                false,
                false,
                false,
                1
            ];
        </script>
        <script src="scripts/modal.js"></script>
        <script src="scripts/acessibilidade.js"></script>
        <script src="scripts/alterarDados.js"></script>

    </body>

</html>