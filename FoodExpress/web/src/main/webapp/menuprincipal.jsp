<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/menuprincipal.css">
        <link rel="stylesheet" type="text/css" href="styles/carrossel.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="stylesheet" type="text/css" href="styles/footer.css">
        <link rel="stylesheet" type="text/css" href="styles/scrollbar.css">
        <link rel="icon" type="image/png" href="imgs/icon.png"/>
    </head>
    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <c:set var="lojas" value="${sessionScope.lojas}"/>
        <header id="navbar">
            <img id="navbar-logo" src="imgs/logo3.png" alt="Logo">
            <div id="navbar-menu">
                <a class="navbar-link" href="menuprincipal.jsp">Início</a>
                <a class="navbar-link" href="gerenciarperfil.jsp">Perfil</a>
                <a class="navbar-link" href="#">Favoritos</a>
                <a class="navbar-link" href="gerenciarloja.jsp">Loja</a>
                <a class="navbar-link" href="#">Sobre</a>
            </div>
            <div id="search-bar">
                <img src="imgs/lupa-azul.svg" alt="">
                <input type="text" placeholder="Pesquisar...">
            </div>
            <div id="navbar-icons">
                <img id="profile-pic" src="imgs/icone-perfil.png" alt="Perfil">
                <div id="orders">
                    <img id="orders-pic" src="imgs/sacola.png" alt="Pedidos">
                    <div id="orders-info">
                        <p>R$0,00</p>
                        <p>0 itens</p>
                    </div>
                </div>
            </div>
        </header>

        <main>
            <section class="content">
                <h1>DESTAQUES</h1>
                <div class="carousel-container realign" data-items="2">
                    <div class="arrow arrow-squared left-arrow"><img src="imgs/arrow-left.png" alt=""></div>
                    <div class="carousel" data-index="0" >
                        <c:forEach items="${lojas}" var="loja">
                            <form action="loja" method="post">
                                <div class="item">
                                    <div class="img-container">
                                        <img src="imgs/teste/teste.jpg" alt="${loja.idUser}" id="imgLojaF">
                                    </div>
                                    <div class="info-container">
                                        <h2>${loja.nome}</h2>
                                        <div class="carousel-rate" aria-label="4">
                                            <span class="carousel-star filled">★</span>
                                            <span class="carousel-star filled">★</span>
                                            <span class="carousel-star filled">★</span>
                                            <span class="carousel-star filled">★</span>
                                            <span class="carousel-star">★</span>
                                        </div>
                                        <div class="carousel-favorite">
                                            <button type="submit" value="FAVORITAR">♥</button>
                                        </div>
                                        <input type="hidden" name="id" value="${loja.id}" class="id">
                                        <input type="hidden" name="submitAction" class="submit-action">
                                    </div>
                                </div>
                            </form>
                        </c:forEach>
                    </div>
                    <div class="arrow arrow-squared right-arrow"><img src="imgs/arrow-right.png" alt=""></div>
                </div>
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
        <script type="module">
            import { initializeApp } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-app.js";
            import { getStorage, ref, getDownloadURL } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-storage.js";
            const firebaseConfig = {
                apiKey: "AIzaSyC6E9U_uW78MMsIf9oQKBTm5LjvRp6OB2A",
                authDomain: "restricted-d6b24.firebaseapp.com",
                databaseURL: "https://restricted-d6b24-default-rtdb.firebaseio.com",
                projectId: "restricted-d6b24",
                storageBucket: "restricted-d6b24.appspot.com",
                messagingSenderId: "351037789777",
                appId: "1:351037789777:web:5a43c6cd09be7a53d70a70",
                measurementId: "G-G0VFKP7XGK"
            };
            const app = initializeApp(firebaseConfig);
            function getImageUrlByName() {
                const storage = getStorage(app); // Corrigido para usar 'app' em vez de 'firebaseApp'
                let e = document.getElementById("imgLojaF");
                const imgElements = document.querySelectorAll('.img-container img');
                imgElements.forEach(async imgElement => {
                  const altText = imgElement.getAttribute('alt');
                  console.log(altText);

                  const storageRef = ref(storage, 'lojaFoto/' + altText);

                  try {
                    const imageUrl = await getDownloadURL(storageRef);
                    if (imageUrl) {
                      imgElement.src = imageUrl;
                    } else {
                      console.log("Erro ao carregar a imagem para o email:", altText);
                    }
                  } catch (error) {
                    console.error('Erro ao obter URL de download:', error);
                  }
                });
            }

            document.addEventListener("DOMContentLoaded", async function () {
               getImageUrlByName();
            });
        </script>
        <script src="scripts/carrossel.js"></script>
    </body>
</html>

