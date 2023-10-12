<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" href="styles/header.css">
        <link rel="stylesheet" href="styles/footer.css">
        <link rel="stylesheet" type="text/css" href="styles/paginasinformacionais.css">
        <link rel="icon" type="image/png" href="styles/imgs/icon.png" />

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
            <h2>Bem-vindo(a) à Política de Uso do FoodExpress, que é projetada para garantir uma experiência segura,
                eficiente e agradável para todos os usuários. Este site foi criado para permitir que os usuarios façam
                pedidos e abram lojas, de forma conveniente e organizada,emelhante à plataforma iFood.</h2>
            <section>

                <details>
                    <summary>Registro</summary>
                    <p>* O registro exigirá informações precisas e atualizadas, incluindo nome, cpf, e-mail e senha. O uso
                        de informações falsas ou de terceiros não é permitido.
                        * A senha deve ser mantida confidencial e não deve ser compartilhada com outros.
                        Nós não nos responsabilizamos por ações realizadas por terceiros que utilizem suas credenciais.!</p>
                </details>

                <details>
                    <summary>Realização de pedidos</summary>
                    <p>* Certifique-se de revisar cuidadosamente os detalhes do pedido antes de confirmar.
                        *O pagamento deve ser realizado de acordo com as opções fornecidas no site.
                    </p>
                </details>

                <details>
                    <summary>Comportamento do usuario</summary>
                    <p> *Osusuários devem tratar os prestadores de serviços e outros usuários com respeito e consideração.
                        *Comentários, avaliações e feedback fornecidos devem ser construtivos e não devem conter linguagem
                        ofensiva, discriminatória ou difamatória.
                        *O uso do site para fins ilegais, fraudulentos ou prejudiciais é estritamente proibido. Isso inclui
                        a violação dos direitos autorais, a tentativa de hacking ou a disseminação de malware.
                    </p>
                </details>
                <details>
                    <summary>Alterações na politica</summary>
                    <p> O FoodExpress reserva-se o direito de modificar esta política a qualquer momento, com notificação
                        prévia aos usuários, quando aplicável.

                        O uso contínuo do site após as alterações na política implicará na aceitação das novas condições.

                        Ao usar o site FoodExpres, você concorda em cumprir estas diretrizes e políticas. A não conformidade
                        pode resultar em restrições ou suspensão do acesso ao site. Em caso de dúvidas ou problemas, entre
                        em contato com a equipe de suporte do site.</p>
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
