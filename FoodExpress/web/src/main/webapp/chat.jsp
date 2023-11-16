<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/main/main.css">
        <link rel="stylesheet" type="text/css" href="styles/loja.css">
        <link rel="stylesheet" type="text/css" href="styles/rating.css">
        <link rel="stylesheet" type="text/css" href="styles/main/header.css">
        <link rel="stylesheet" type="text/css" href="styles/carrossel.css">
        <link rel="stylesheet" type="text/css" href="styles/main/footer.css">
        <link rel="stylesheet" type="text/css" href="styles/slider.css">
        <link rel="stylesheet" type="text/css" href="styles/modal.css">
        <link rel="icon" type="image/png" href="imgs/icon.png" />
        <style>
            #chatbox {
                height: 300px;
                width: 300px;
                border: 1px solid black;
                overflow: auto;
            }
            #userInput {
                width: 300px;
            }


            .chat-container {
                display: flex;
            }

            .sidebar {
                width: 400px;
                height: 100vh;
                border-right: 1px solid #ccc;
                display: flex;
                flex-direction: column;
                justify-content: space-between;
                align-items: center;
            }

            .sidebar .container-client-list {
                display: flex;
                flex-direction: column;
                align-items: center;
                margin-top: 30px;
            }
            .sidebar .container-client-list img {
                width: 200px;
                height: auto;
            }
            .sidebar .text-client h3 {
                font-size: 1.7rem;
                color: #1c76b4;
                margin-bottom: 20px;
                margin-top: 20px;
            }
            .sidebar .client-list {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: flex-start;
                width: 350px;
                padding: 20px 0px 20px 0px;
                max-height: 300px;
                overflow-y: auto;
            }

            .sidebar .client-list button {
                border-radius: 50px;
                background: #55b3f3;
                color: white;
                width: 50%;
                height: 45px;
                cursor: pointer;
                margin-bottom: 20px;
                font-size: 19px;
                border: none;
            }
            .sidebar .button-change-user {
                border-radius: 50px;
                background: #1c76b4;
                color: white;
                width: 50%;
                height: 50px;
                cursor: pointer;
                margin-bottom: 40px;
                font-size: 19px;
                border: none;
            }

            .chat-box {
                width: 70%;
                padding: 40px;
                height: 80vh;
            }
            .chat-box .user-header {
                height: 300px;
                background-color: #cd606b;
                border-radius: 25px 25px 0px 0px;
                height: 105px;
                display: flex;
                flex-direction: column;
                align-items: flex-start;
                justify-content: center;
                color: white;
                padding-left: 30px;
            }
            .chat-box .user-header h2 {
                font-size: 2rem;
                margin-bottom: 10px;
            }
            .chat-box .user-header span {
                font-size: 1rem;
            }
            .messagesContainer {
                min-height: 60vh;
                background: rgba(32, 33, 35, 0.1);
                overflow-y: auto;
                max-height: 60vh;
                border-bottom: 1px solid #ccc;
                padding: 10px;
                border-radius: 5px;
                display: flex;
                flex-direction: column;
                align-items: center;
            }
            .chat-box .messages {
                width: 80%;
            }

            .messages .self {
                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: flex-end;
                margin-top: 10px;
            }
            .messages span {
                font-size: 10px;
            }

            .messages .self p {
                padding: 10px;
                display: flex;
                flex-direction: row;
                align-items: flex-end;
                border-radius: 10px;
                background-color: #55b3f3;
                color: white;
                text-align: right;
                font-size: 1.2rem;
            }
            .messages .self span {
                margin-left: 50px;
            }
            .messages .other {
                display: flex;
                flex-direction: row;
                align-items: center;
                justify-content: flex-start;
                margin-top: 10px;
            }
            .messages .other p {
                display: flex;
                font-size: 1.2rem;
                flex-direction: row;
                align-items: flex-end;
                padding: 10px;
                border-radius: 10px;
                color: black;
                background-color: rgba(32, 33, 35, 0.2);
            }
            .messages .other span {
                margin-left: 50px;
            }

            .chat-box form {
                min-height: 10vh;
                background: rgba(32, 33, 35, 0.1);
                display: flex;
                align-items: center;
                justify-content: center;
            }
            .container-input {
                border-radius: 50px;
                background: rgba(32, 33, 35, 0.5);
                width: 80%;
                color: white;
                border: none;
                height: 40px;
                font-size: 18px;
                padding: 12px;
                margin: 20px;
                position: relative;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .input-icon {
                position: absolute;
                right: 10px;
                top: 50%;
                transform: translateY(-50%);
                z-index: 10;
                fill: #333;
                width: 30px;
                height: auto;
            }
            input {
                padding-left: 10px;
                height: 40px;
                width: 80%;
                background: transparent;
                display: flex;
                align-items: center;
                justify-content: flex-start;
                resize: none;
                border: none;
                color: white;
                font-size: 16px;
            }
            input::placeholder {
                color: white;
                font-size: 16px;
            }
            input:focus {
                outline: none;
            }

            .submit-button {
                margin-left: 5px;
                background-color: transparent;
                border: none;
                cursor: pointer;
            }
            .submit-button .input-icon {
                position: absolute;
                right: 10px;
                top: 50%;
                transform: translateY(-50%);
                z-index: 10;
                fill: #333;
                width: 30px;
                height: auto;
            }

            @media screen and (max-width: 800px) {
                .chat-container {
                    flex-direction: column;
                    padding: 15px;
                }
                .sidebar {
                    height: 70px;
                    width: 100%;
                    align-items: center;
                    justify-content: center;
                    border: none;
                }
                .container-client-list {
                    display: none !important;
                }

                .sidebar .button-change-user {
                    width: 80%;
                    height: 50px;
                    cursor: pointer;
                    margin-bottom: 0px;
                    font-size: 16px;
                    border: none;
                }
                .chat-box {
                    width: 100%;
                    padding: 0px;
                }
            }
        </style>
    </head>
    <body>
        <c:set var="usuario" value="${sessionScope.usuario}"/>
        <c:set var="sacola" value="${sessionScope.sacola}"/>
        <c:set var="acessibilidade" value="${sessionScope.acessibilidade}"/>
        <c:set var="loja" value="${requestScope.loja}"/>
        <c:set var="produtos" value="${requestScope.produtos}"/>
        <c:set var="avaliacoes" value="${requestScope.avaliacoes}"/>
        <c:set var="avaliacaoUsuario" value="${requestScope.avaliacaoUsuario}"/>
        <c:set var="favorito" value="${requestScope.favorito}"/>

        <c:set var="ratingClass" value="${not empty avaliacaoUsuario ? 'process-rating disabled' : ''}"/>
        <c:set var="ratingValue" value="${not empty avaliacaoUsuario ? avaliacaoUsuario.nota : 0}"/>

        <input type="hidden" id="emailFirebase" value="${loja.idUser}">
        <input type="hidden" id="avaliacao" value="<fmt:formatNumber value="${loja.avaliacao}" type="number" pattern="#,##0.0" />">





        <div class="chat-container">
            <div class="chat-box">
                <div class="user-header" id="user-header"></div>
                <div class="messagesContainer" id="messagesContainer">
                    <div class="messages" id="messages"></div>
                </div>
                <div class="container-input">
                    <input
                        type="text"
                        id="user-input"
                        autofocus
                        placeholder="Digite sua mensagem..."
                        />
                    <button id="btnChat">
                        <svg
                            xmlns="http://www.w3.org/2000/svg"
                            width="43"
                            height="27"
                            viewBox="0 0 43 27"
                            fill="none"
                            >
                        <path
                            d="M23.2609 13.8432L7.10756 15.52C6.92185 15.5393 6.74757 15.5888 6.60225 15.6633C6.45694 15.7379 6.3457 15.835 6.27974 15.9449L0.710122 25.2416C0.178252 26.0967 1.61301 26.9117 2.92982 26.5002L41.5332 14.4752C41.8 14.3919 42.0244 14.2639 42.1812 14.1057C42.338 13.9475 42.421 13.7652 42.421 13.5793C42.421 13.3934 42.338 13.2111 42.1812 13.0529C42.0244 12.8947 41.8 12.7668 41.5332 12.6834L2.92982 0.658414C1.61301 0.248227 0.178252 1.06326 0.710122 1.91703L6.28188 11.2137C6.34785 11.3236 6.45908 11.4207 6.6044 11.4953C6.74972 11.5699 6.924 11.6193 7.10971 11.6386L23.2631 13.3154C23.3639 13.3254 23.4556 13.3575 23.5218 13.4059C23.588 13.4542 23.6244 13.5157 23.6244 13.5793C23.6244 13.6429 23.588 13.7044 23.5218 13.7527C23.4556 13.8011 23.3639 13.8332 23.2631 13.8432H23.2609Z"
                            fill="white"
                            />
                        </svg>
                    </button>
                </div>
            </div>
        </div>
        <input style="display: none" id="id-usuario" value="${usuario.email}">
        <input style="display: none" id="id-loja">
        <script type="module">
            import { initializeApp } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-app.js";
            import { getDatabase, ref, push, onValue } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-database.js";

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
            const db = getDatabase(app);

            const usuario = document.getElementById('id-usuario').value;
            let loja = document.getElementById('id-loja').value;
            const userInput = document.getElementById('user-input');
            const messagesContainer = document.getElementById('messagesContainer');

            function sendMessage() {
                var urlParams = new URLSearchParams(window.location.search);
                var meuValor = urlParams.get('valor');
                let loja = document.getElementById("id-loja");
                loja.value = meuValor;

                const message = userInput.value;
                userInput.value = '';
                const novaStrUser = usuario.replace(/\./g, '');
                const novaStrLoja = loja.value.replace(/\./g, '');

                // Organiza os e-mails em ordem alfabética para criar a chave do chat
                let chatKey;
                if (novaStrUser < novaStrLoja) {
                    chatKey = novaStrUser + "_" + novaStrLoja;
                } else {
                    chatKey = novaStrLoja + "_" + novaStrUser;
                }

                const messageRef = ref(db, 'chats/' + chatKey);
                push(messageRef, {novaStrUser, novaStrLoja, message});
            }

            document.getElementById('btnChat').addEventListener('click', sendMessage);

            var urlParams = new URLSearchParams(window.location.search);
            let loja2 = document.getElementById("id-loja");

            var meuValor = urlParams.get('valor');
            loja2.value = meuValor;

            const message = userInput.value;
            userInput.value = '';
            const novaStrUser = usuario.replace(/\./g, '');
            const novaStrLoja = loja2.value.replace(/\./g, '');

// Organiza os e-mails em ordem alfabética para criar a chave do chat
            let chatKey;
            if (novaStrUser < novaStrLoja) {
                chatKey = novaStrUser + "_" + novaStrLoja;
            } else {
                chatKey = novaStrLoja + "_" + novaStrUser;
            }

            const chatRef = ref(db, 'chats/' + chatKey);
            onValue(chatRef, (snapshot) => {
                var urlParams = new URLSearchParams(window.location.search);
                var meuValor = urlParams.get('valor');
                const loja = document.getElementById("id-loja");
                loja.value = meuValor;

                const data = snapshot.val();
                if (data) {
                    messagesContainer.innerHTML = '';

                    const entries = Object.entries(data);
                    for (let i = 0; i < entries.length; i++) {
                        const newMessage = entries[i][1];
                        console.log(newMessage);
                        const messageElement = document.createElement('p');
                        let str = newMessage.novaStrUser;
                        str = str.replace('@gmailcom', '');
                        str = str.charAt(0).toUpperCase() + str.slice(1);


                        messageElement.textContent = str + ': ' + newMessage.message;
                        messagesContainer.appendChild(messageElement);
                    }
                }
            });

        </script>
        <script src="scripts/jquery/jquery.js"></script>
    </body>
</html>
