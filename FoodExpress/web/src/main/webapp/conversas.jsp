<!DOCTYPE html>
<html>
<head>
    <title>Conversas</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        
        #emailTable{
            background-color: #cd606b;
            font-size: 30px;
        }
        a{
            text-decoration: none;
            color: white;
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
        <input style="display: none" id="id-usuario" value="${usuario.email}">

    <table id="emailTable">
        <tr>
            <th>Conversas</th>
        </tr>
        <!-- As linhas da tabela serão preenchidas aqui pelo JavaScript -->
    </table>
    
    

    <script type="module">
        import { initializeApp } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-app.js";
        import { getDatabase, ref, onValue } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-database.js";

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
        var urlParams = new URLSearchParams(window.location.search);
        var meuValor = urlParams.get('valor');
        let newUsuario = meuValor.replace(/\./g, '');
        const usuario = newUsuario;  // Substitua isso pelo e-mail do usuário
        console.log(usuario);
        const emailTable = document.getElementById('emailTable');

        const chatsRef = ref(db, 'chats');
        onValue(chatsRef, (snapshot) => {
            const data = snapshot.val();
            if (data) {
                // Limpa o contêiner de mensagens
                
                
                emailTable.innerHTML = '<tr><th>Conversas</th></tr>';

                const keys = Object.keys(data);
                for (let i = 0; i < keys.length; i++) {
                    const key = keys[i];
                    const emails = key.split('_');
                    let otherEmail;
                    if (emails[0] === usuario) {
                        otherEmail = emails[1];
                    } else if (emails[1] === usuario) {
                        otherEmail = emails[0];
                    }

                    if (otherEmail) {
                        const row = emailTable.insertRow(-1);
                        const cell = row.insertCell(0);
                        const link = document.createElement('a');
                        
                        
                        
                        link.href = 'chat.jsp?valor='+otherEmail;  // Substitua isso pelo link para o chat com a pessoa
                        let str = otherEmail;
                        str = str.replace('@gmailcom', '');
                        str = str.charAt(0).toUpperCase() + str.slice(1);
                        link.textContent = str;
                        cell.appendChild(link);
                    }
                }
            }
        });
    </script>
</body>
</html>
