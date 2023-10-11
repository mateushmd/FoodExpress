<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/gerenciarperfil.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="icon" type="image/png" href="imgs/icon.png">
        <style>
            .card {
                width: 252px;
                height: 265px;
                background: white;
                border-radius: 30px;
                box-shadow: 15px 15px 30px #bebebe,
                    -15px -15px 30px #ffffff;
                transition: 0.2s ease-in-out;
                overflow: hidden;
            }
            
            .img {
                width: 100%;
                height: 50%;
                object-fit: fill;
                border-top-left-radius: 30px;
                border-top-right-radius: 30px;
                background: linear-gradient(#e66465, #9198e5);
                display: flex;
                align-items: top;
                justify-content: right;
            }
            
            .img img {
                width: 100%;
                height: auto;
                object-fit: cover;
            }

            .save {
                transition: 0.2s ease-in-out;
                border-radius: 10px;
                margin: 20px;
                width: 30px;
                height: 30px;
                background-color: #ffffff;
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .text {
                margin: 20px;
                display: flex;
                flex-direction: column;
                align-items: space-around;
            }

            .save .svg {
                transition: 0.2s ease-in-out;
                width: 15px;
                height: 15px;
            }

            .icon-box {
                margin-top: 15px;
                width: 70%;
                padding: 10px;
                background-color: #e3fff9;
                border-radius: 10px;
                display: flex;
                align-items: center;
                justify-content: left;
            }

            .icon-box svg {
                width: 17px;
            }

            .text .h3 {
                font-family: 'Lucida Sans' sans-serif;
                font-size: 15px;
                font-weight: 600;
                color: black;
            }

            .text .p {
                font-family: 'Lucida Sans' sans-serif;
                color: #999999;
                font-size: 13px;
            }

            .icon-box .span {
                margin-left: 10px;
                font-family: 'Lucida Sans' sans-serif;
                font-size: 13px;
                font-weight: 500;
                color: #9198e5;
            }

            .card:hover {
                cursor: pointer;
                box-shadow: 0px 10px 20px rgba(0,0,0,0.1);
            }

            .save:hover {
                transform: scale(1.1) rotate(10deg);
            }

            .save:hover .svg {
                fill: #ced8de;
            }
            input[type="file"] {
                color: transparent;
            }
        </style>
    </head>

    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
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
            <div class="container">
                <nav id="menu-perfil">
                    <h2 id="gpp">GERENCIAR PERFIL</h2>
                    <div class="card" style="left: 13%;position: relative;">
                        <div class="img">
                            <img src="" alt="" id="imgPerfil">
                        </div>
                        <div class="text" style="right: -19%;position: relative;">
                            <input type="file" id="file-input">
                            <button id="uploadButton" style="width: 117px; margin-top: 20px;">Enviar a Imagem</button>
                        </div>
                    </div>

                    <div id="perfil">

                        <h2>${usuario.getNome()}</h2>
                    </div>

                    <h2 class="item" id="selected">INFORMAÇÕES DA CONTA</h2>

                    <h2 class="item">FAVORITOS</h2>

                    <h2 class="item">CHAT</h2>

                    <h2 class="item">PEDIDOS</h2>

                    <h2 class="item">AJUDA</h2>

                    <h2 class="item">SAIR</h2>       
                </nav>
                <section id="informacoes-conta">
                    <form action="gerenciarPerfil" method="post">
                        <ul>
                            <li>
                                <label>NOME:</label>
                                <div>
                                    <input type="text" name="name" value="${usuario.getNome()}" disabled id="name" class="perfil-input">
                                    <button class="editar" data-default="${usuario.getNome()}"><img src="imgs/editar.png" alt=""></button>
                                </div>
                            </li>
                            <li>
                                <label>TELEFONE:</label>
                                <div>
                                    <input type="tel" name="tel" value="${usuario.getTelefone()}" id="phone" maxlength="18" disabled class="perfil-input">
                                    <button class="editar" data-default="${usuario.getTelefone()}"><img src="imgs/editar.png" alt=""></button>
                                </div>
                            </li>
                            <li>
                                <label>EMAIL:</label>
                                <div>
                                    <input type="password" name="email" value="${usuario.getEmail()}" disabled id="email" class="perfil-input" id="email">
                                    <button class="editar" id="revelar" data-default="${usuario.getEmail()}"><img src="imgs/mostrar.png" alt=""></button>
                                </div>
                            </li>
                            <li>
                                <div class="botao">
                                    <input type="submit" name="submit" value="ALTERAR SENHA" style="font-family: 'Oswald', sans-serif;" class="editar-perfil enabled">
                                </div>

                                <div class="botao disabled">
                                    <input type="submit" name="submit" value="APLICAR ALTERAÇÕES" style="font-family: 'Oswald', sans-serif;" class="editar-perfil" disabled id="aplicar-alteracoes">
                                </div>
                            </li>
                            <li>
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
                                    let e = document.getElementById("email");
                                    const storageRef = ref(storage, 'images/' + e.value);
                                    return getDownloadURL(storageRef)
                                            .then(downloadURL => {
                                            return downloadURL;
                                            })
                                            .catch(error => {
                                            console.error('Error getting download URL:', error);
                                            return null;
                                            });
                                    }

                                    document.addEventListener("DOMContentLoaded", async function () {
                                    let imageUrl = await getImageUrlByName();
                                    // Encontra o elemento <img> no HTML pelo ID e define o atributo src
                                    const imgElement = document.getElementById('imgPerfil');
                                    imgElement.src = imageUrl;
                                    });
                                </script>


                                <script type="module">
                                    import { initializeApp } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-app.js";
                                    import { getStorage, ref, uploadBytes, getDownloadURL } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-storage.js";
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
                                    async function uploadFile(file) {
                                    const storage = getStorage(app);
                                    let e = document.getElementById("email");
                                    const storageRef = ref(storage, 'images/' + e.value);
                                    try {
                                    await uploadBytes(storageRef, file);
                                    // Get the download URL of the uploaded file
                                    const downloadURL = await getDownloadURL(storageRef);
                                    console.log('Uploaded and replaced file:', file.name);
                                    console.log('File available at', downloadURL);
                                    location.reload();
                                    } catch (error) {
                                    console.error('Error uploading file:', error);
                                    }
                                    }

                                    document.addEventListener("DOMContentLoaded", function () {
                                    const fileInput = document.getElementById('file-input');
                                    const uploadButton = document.getElementById('uploadButton');
                                    uploadButton.addEventListener('click', () => {
                                    const file = fileInput.files[0];
                                    if (file) {
                                    uploadFile(file);
                                    }
                                    });
                                    });</script>






                                <c:choose>
                                    <c:when test="${usuario.getTipo() eq 1}">
                                        <div class="botao">
                                            <input type="submit" name="submit" value="ABRIR LOJA" style="font-family: 'Oswald', sans-serif;" class="editar-perfil enabled">
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="botao">
                                            <input type="submit" name="submit" value="FECHAR LOJA" style="font-family: 'Oswald', sans-serif;" class="editar-perfil enabled">
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </li>
                            <input type="hidden" name="defName" id="def-name" value="${usuario.getNome()}">
                            <input type="hidden" name="defTel" id="def-tel" value="${usuario.getTelefone()}">
                            <input type="hidden" name="defMail" id="def-mail" value="${usuario.getEmail()}">
                        </ul>
                    </form>
                </section>
            </div>
        </main>

        <script src="scripts/mascaras.js"></script>
        <script src="scripts/editarperfil.js"></script>
        <script src="scripts/menuinterativo.js"></script>
        <script src="scripts/menu.js"></script>
    </body>

</html>
