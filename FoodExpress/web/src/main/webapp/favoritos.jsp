<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="stylesheet" type="text/css" href="styles/gerenciarconta.css">
        <link rel="stylesheet" type="text/css" href="styles/favoritos.css">
        <link rel="stylesheet" type="text/css" href="styles/slider.css">
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
                            <li><a href=""><img src="imgs/header/engrenagem.svg" alt="">Dados</a></li>
                            <li><a href=""><img src="imgs/header/pedido.svg" alt="">Pedidos</a></li>
                            <li><a href=""><img src="imgs/header/chat.svg" alt="">Conversas</a></li>
                            <li><a href="favoritos.jsp"><img src="imgs/header/coracao.svg" alt="">Favoritos</a></li>
                            <li><a href="acessibilidade.jsp"><img src="imgs/header/acessibilidade.svg"
                                                                  alt="">Acessibilidade</a></li>
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

        <main>
            <section>
                <h1>Favoritos</h1>
                <div class="loja">
                    <img src="imgs/teste/teste.jpg" class="img-loja" alt="">
                    <div class="loja-body">
                        <h2>Lojinha do Mateus</h2>
                        <div class="avaliacao">
                            <img src="imgs/star.svg" alt="">
                            <p>5</p>
                        </div>
                    </div>
                    <img src="imgs/x-symbol.svg" class="remover" alt="">
                </div>
                <div class="loja">
                    <img src="imgs/teste/teste.jpg" class="img-loja" alt="">
                    <div class="loja-body">
                        <h2>Lojinha do Mateus</h2>
                        <div class="avaliacao">
                            <img src="imgs/star.svg" alt="">
                            <p>5</p>
                        </div>
                    </div>
                    <img src="imgs/x-symbol.svg" class="remover" alt="">
                </div>
                <div class="loja">
                    <img src="imgs/teste/teste.jpg" class="img-loja" alt="">
                    <div class="loja-body">
                        <h2>Lojinha do Mateus</h2>
                        <div class="avaliacao">
                            <img src="imgs/star.svg" alt="">
                            <p>5</p>
                        </div>
                    </div>
                    <img src="imgs/x-symbol.svg" class="remover" alt="">
                </div>
                <div class="loja">
                    <img src="imgs/teste/teste.jpg" class="img-loja" alt="">
                    <div class="loja-body">
                        <h2>Lojinha do Mateus</h2>
                        <div class="avaliacao">
                            <img src="imgs/star.svg" alt="">
                            <p>5</p>
                        </div>
                    </div>
                    <img src="imgs/x-symbol.svg" class="remover" alt="">
                </div>

                <div class="loja">
                    <img src="imgs/teste/teste.jpg" class="img-loja" alt="">
                    <div class="loja-body">
                        <h2>Lojinha do Mateus</h2>
                        <div class="avaliacao">
                            <img src="imgs/star.svg" alt="">
                            <p>5</p>
                        </div>
                    </div>
                    <img src="imgs/x-symbol.svg" class="remover" alt="">
                </div>
            </section>
        </main>

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

        <script>
            const configuracoesAcessibilidade = [
                true,
                true,
                true,
                2
            ];
        </script>
        <script src="scripts/modal.js"></script>
        <script src="scripts/acessibilidade.js"></script>
        <script src="scripts/slider.js"></script>
    </body> 

</html>