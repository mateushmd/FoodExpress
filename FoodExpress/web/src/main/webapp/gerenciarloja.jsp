<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/gerenciarloja.css">
        <link rel="stylesheet" type="text/css" href="styles/header.css">
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>

    <body>
        <c:set var="loja" value="${sessionScope.loja}"/>
        <c:set var="produtos" value="${sessionScope.produtos}"/>
        <input type="hidden" id="emailFirebase" value="${usuario.email}">

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
            <section>
                <div id="container-loja">
                    <div>
                        <h1>LOJA</h1>
                    </div>
                    <div id="container-dados-loja">
                        <div id="container-img-loja">
                            <label id="picture-loja" for="picture-input-loja" tabindex="0">
                                <span id="picture-image-loja"></span>
                                <input type="file" name="picture-input-loja" id="picture-input-loja" />
                            </label>
                        </div>
                        <div id="container-forms-loja">
                            <form style="display: flex;" action="gerenciarLoja" method="post">
                                <div id="editaLoja">
                                    <div class="dados-loja">
                                        <label class="labels-loja">Nome:</label>
                                        <input type="text" class="form-control-loja" name="nome" value="${loja.nome}" placeholder="">
                                    </div>
                                    <div class="dados-loja">
                                        <label class="labels-loja">Descrição:</label>
                                        <textarea type="text" class="form-control-loja" id="textarea" name="descricao"
                                                  placeholder=""></textarea>
                                    </div>
                                    <div class="dados-loja" id="radioLoja">
                                        <label class="labelRadio"><input class="input" type="radio" name="opcao" value="1"
                                                                         required>Disponível</label>
                                        <label class="labelRadio"><input class="input" type="radio" name="opcao" value="1"
                                                                         required>Fechado</label>
                                    </div>
                                </div>
                                <div id="botoes-loja">
                                    <button class="botaoLoja" id="uploadButton">Salvar</button>
                                    <button class="botaoLoja">Editar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>

            <section>
                <div id="container-produtos">
                    <div>
                        <h1 id="titulo-produtos">PRODUTOS</h1>
                    </div>
                    <div id="produtos">
                        <div class="container-produto">
                            <div>
                                <label class="picture-produto" for="picture-cria-produto" tabindex="0">
                                    <span class="picture-image-produto"></span>
                                    <input type="file" name="picture-input-produto" class="picture-input-produto"
                                           id="picture-cria-produto" />
                                </label>
                            </div>
                            <div class="container-forms-produto">
                                <form style="display: flex;" action="gerenciarProduto" method="post">
                                    <div class="edita-produto">
                                        <div class="dados-produto">
                                            <label class="labels-produto">Produto:</label>
                                            <input type="text" class="form-control-produto" name="produto" placeholder="" id="produtoNomeFb">
                                            <label class="labels-produto">R$:</label>
                                            <input type="text" class="form-control-produto" name="preco" placeholder=""
                                                   onKeyPress="return(moeda(this, '.', ',', event))">
                                            <label class="labels-produto">Disponibilidade:</label>
                                            <select class="form-control-produto" name="disponibilidade"
                                                    id="disponibilidade">
                                                <option value="0">Não disponível</option>
                                                <option value="1">Disponível</option>
                                            </select>
                                        </div>
                                        <div class="botoes-produto">
                                            <button type="submit" class="botao-produto" name="submit" value="ADICIONAR" id="botaoAddProduto">Adicionar</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--Para os produtos já adicionados-->
                        <c:forEach items="${produtos}" var="produto">
                            <div class="container-produto">
                                <div>
                                    <label class="picture-produto" for="picture-cria-produto" tabindex="0">
                                        <span class="picture-image-produto"></span>
                                        <input type="file" name="picture-input-produto" class="picture-input-produto"
                                               id="picture-cria-produtoEd" />
                                    </label>
                                </div>
                                <div class="container-forms-produto">
                                    <form style="display: flex;" action="gerenciarProduto" method="post">
                                        <div class="edita-produto">
                                            <div class="dados-produto">
                                                <input type="text" class="form-control-produto" name="produto" id="produtoNomeEditado" placeholder=""
                                                       value="${produto.nome}" disabled>
                                                <label class="labels-produto">R$:</label>
                                                <input type="text" class="form-control-produto" name="preco" placeholder=""
                                                       value="<fmt:formatNumber value='${produto.preco}' pattern='0.00' />" onKeyPress="return(moeda(this, '.', ',', event))" disabled>
                                                <label class="labels-produto">Disponibilidade:</label>
                                                <select class="form-control-produto" name="disponibilidade" disabled>
                                                    <option value="0" ${produto.disponivel ? '' : 'selected'}>Não disponível</option>
                                                    <option value="1" ${produto.disponivel ? 'selected' : ''}>Disponível</option>
                                                </select>
                                            </div>
                                            <div class="botoes-produto">
                                                <button class="botao-produto editar-produto">Editar</button>
                                                <button class="botao-produto salvar-produto" name="submit" value="EDITAR" id="botaoProdutoEditado" disabled>Salvar</button>
                                            </div>
                                        </div>

                                        <input type="hidden" name="id" value="${produto.id}">
                                        <input type="hidden" name="def-produto" class="def-produto" value="${produto.nome}">
                                        <input type="hidden" name="def-preco" class="def-preco" value="<fmt:formatNumber value='${produto.preco}' pattern='0.00' />">
                                    </form>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
        </main>

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
            let e = document.getElementById("emailFirebase");
            const storageRef = ref(storage, 'lojaFoto/' + e.value); //Alteração
            try {
            await uploadBytes(storageRef, file);
            // Get the download URL of the uploaded file
            const downloadURL = await getDownloadURL(storageRef);
            console.log('Uploaded and replaced file:', file.name);
            console.log('File available at', downloadURL);
            } catch (error) {
            console.error('Error uploading file:', error);
            }
            }

            document.addEventListener("DOMContentLoaded", function () {
            const fileInput = document.getElementById('picture-input-loja'); //Alteração
            const uploadButton = document.getElementById('uploadButton');
            uploadButton.addEventListener('click', () => {
            const file = fileInput.files[0];
            if (file) {
            uploadFile(file);
            }
            });
            });</script>
       <script type="module">
    import { initializeApp } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-app.js";
    import { getStorage, ref, uploadBytes, getDownloadURL, listAll } from "https://www.gstatic.com/firebasejs/9.23.0/firebase-storage.js";
    
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
        let e = document.getElementById("emailFirebase");
        
        const folderRef = ref(storage, 'ProdutoFoto/' + e.value); // Referência para a pasta
        let produtoNome = document.getElementById("produtoNomeFb");
        const storageRef = ref(storage, 'ProdutoFoto/' + e.value + "/" + produtoNome.value); // Alteração para usar o próximo número de arquivo
        
        try {
            await uploadBytes(storageRef, file);
            // Get the download URL of the uploaded file
            const downloadURL = await getDownloadURL(storageRef);
            console.log('Uploaded and replaced file:', file.name);
            console.log('File available at', downloadURL);
        } catch (error) {
            console.error('Error uploading file:', error);
        }
    }

    document.addEventListener("DOMContentLoaded", function () {
        const fileInput = document.getElementById('picture-cria-produto'); //Alteração
        const uploadButton = document.getElementById('botaoAddProduto');
        
        uploadButton.addEventListener('click', () => {
            const file = fileInput.files[0];
            if (file) {
                uploadFile(file);
            }
        });
    });
</script>


        <script src="scripts/editarloja.js"></script>
        <script src="scripts/menu.js"></script>
    </body>

</html>