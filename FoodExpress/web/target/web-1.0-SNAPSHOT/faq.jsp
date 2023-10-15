<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/main.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="stylesheet" type="text/css" href="styles/footer.css">
        <link rel="stylesheet" type="text/css" href="styles/paginasinformacionais.css">
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
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
            <h1>Dúvidas frequentes:</h1>
            <section>

                <details>
                    <summary>Como faço para usar o site?</summary>
                    <p>É simples! Basta acessar o site, criar uma conta ou fazer login, navegar pelas categorias de produtos
                        e lojas e escolher o que deseja comprar.
                        Depois, siga as instruções para finalizar o pedido!</p>
                </details>

                <details>
                    <summary>Quais métodos de pagamento são aceitos?</summary>
                    <p>Infelizmente não cuidamos da parte do pagamento, isso fica totalmente na responsabilidade do
                        vendedor. Na descrição do perfil do mesmo está informando as formas de pagamento aceitas,
                        caso não esteja, basta entrar em contato com ele e tirar suas duvidas em relação a isso.
                    </p>
                </details>

                <details>
                    <summary>Como faço para entrar em contato com o suporte ao usuario?</summary>
                    <p>Você pode encontrar informações de contato do suporte ao cliente na seção "Ajuda"
                        do site. Assim que acessar essa seção, basta inserir seus dados e sua mensagem e não demoraremos
                        para retornar e te ajudar no que for possivel.
                    </p>
                </details>
                <details>
                    <summary>Como posso deixar uma avaliação sobre um produto?</summary>
                    <p>Após receber seu pedido, você pode acessar a pagina do vendedor e deixar a sua avaliação, tanto da
                        loja quanto do produto.
                        Além disso, em cada página de produto, há a opção de deixar uma avaliação. Suas opiniões são
                        valiosas para nós e outros clientes.</p>
                </details>
                <details>
                    <summary>Qual é a política de privacidade da empresa em relação aos meus dados pessoais?</summary>
                    <p>A segurança dos seus dados é uma prioridade. Nossa política de privacidade detalha como coletamos,
                        usamos e protegemos suas informações pessoais. Você pode encontrá-la na seção "Política de
                        Privacidade"
                        do nosso site.</p>
                </details>
                <details>
                    <summary>Como denunciar alguem?</summary>
                    <p> Se você tiver uma preocupação ou suspeita de comportamento inadequado, assédio, fraude ou violação
                        de
                        termos de uso em nosso site,
                        entre em contato com nossa equipe de suporte imediatamente.
                        Você pode usar o formulário de contato ou enviar um e-mail para equipefoodexpress@gmail.com.
                    </p>
                </details>

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
    </body>
</html>
