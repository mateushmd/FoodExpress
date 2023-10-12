<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress - Privacidade</title>
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="stylesheet" type="text/css" href="styles/footer.css">
        <link rel="stylesheet" type="text/css" href="styles/paginasinformacionais.css">
        <link rel="icon" type="image/png" href="styles/imgs/icon.png"/>

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
            <h2>A segurança e privacidade dos seus dados são de extrema importância para nós. Esta Política de Segurança e Privacidade dos Dados visa explicar como coletamos, 
                utilizamos, protegemos e compartilhamos as suas informações no site, assegurando a confidencialidade e a integridade dos dados.</h2>
            <section>

                <details>
                    <summary>Coleta de dados</summary>
                    <p> Coletamos dados pessoais necessários para o funcionamento do site e a realização de pedidos. 
                        Isso pode incluir informações como nome, cpf, email e senha</p>
                </details>

                <details>
                    <summary>Uso dos dados</summary>
                    <p>Utilizamos os dados coletados para processar pedidos, 
                        gerenciar contas de usuário, fornecer suporte ao cliente e melhorar nossos serviços.
                    </p>
                </details>

                <details>
                    <summary>Proteção de dados</summary>
                    <p>Implementamos medidas de segurança técnicas e organizacionais para proteger suas informações 
                        contra acesso não autorizado, alteração, divulgação ou destruição. Utilizamos métodos de criptografia para proteger dados sensíveis, como senhas.
                    </p>
                </details>
                <details>
                    <summary>Contato</summary>
                    <p> Se você tiver alguma dúvida ou preocupação sobre a segurança e privacidade dos seus dados, entre em contato com nossa equipe de suporte.

                        Ao utilizar o FoodExpress, você concorda com os termos desta Política de Segurança e Privacidade dos Dados. Seus dados são fundamentais para fornecer 
                        uma experiência segura e eficiente no site, seguindo as melhores práticas de segurança e privacidade.
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
        
        <script src="scripts/modal.js"></script>
    </body>
</html>
