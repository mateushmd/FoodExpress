<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    <header>
        <nav class="nav-bar">
            <div class="logo"><a href="menuprincipal.jsp"><img src="imgs/logo2.png" alt="Logo" id="logoimg"></a></div>

            <div class="menu-options">
                <ul>
                    <li class="menu-item"><a href="menuprincipal.jsp" class="menu-link">INÍCIO</a></li>
                    <li class="menu-item"><a href="gerenciarperfil.jsp" class="menu-link">PERFIL</a></li>
                    <li class="menu-item"><a href="#" class="menu-link">PEDIDOS</a></li>
                    <li class="menu-item"><a href="#" class="menu-link">FAVORITOS</a></li>
                    <li class="menu-item"><a href="gerenciarloja.jsp" class="menu-link">MINHA LOJA</a></li>
                    <li class="menu-item"><a href="#" class="menu-link">SOBRE</a></li>
                </ul>
            </div>

            <div class="botao-menu"><button onclick="menuShow()"><img class="menuBtn"
                        src="imgs/menu_white_36dp.svg"></button></div>
        </nav>

        <div class="menu-options-mobile">
            <ul>
                <li class="menu-item"><a href="menuprincipal.html" class="menu-link">INÍCIO</a></li>
                <li class="menu-item"><a href="perfil.html" class="menu-link">PERFIL</a></li>
                <li class="menu-item"><a href="#" class="menu-link">PEDIDOS</a></li>
                <li class="menu-item"><a href="#" class="menu-link">FAVORITOS</a></li>
                <li class="menu-item"><a href="perfilVendedor.html" class="menu-link">MINHA LOJA</a></li>
                <li class="menu-item"><a href="#" class="menu-link">SOBRE</a></li>
            </ul>
        </div>
    </header>

    <section>
        <div class="container-loja">
            <div>
                <h1>LOJA</h1>
            </div>
            <div id="container-dados-loja">
                <div id="container-img-loja">
                    <label class="picture-loja" for="picture_input-loja" tabindex="0">
                        <span class="picture_image-loja"></span>
                        <input type="file" name="picture_input-loja" id="picture_input-loja" />
                    </label>
                </div>
                <div id="container-forms-loja">
                    <form style="display: flex;" action="gerenciarLoja" method="post">
                        <div id="editaLoja">
                            <div class="dados-loja">
                                <label class="labels-loja">Nome:</label>
                                <input type="text" class="form-control-loja" name="nome" placeholder="" value="${loja.getNome()}">
                            </div>
                            <div class="dados-loja">
                                <label class="labels-loja">Descrição:</label>
                                <textarea type="text" class="form-control-loja" id="textarea" name="descricao"
                                    placeholder="">${loja.getDescricao()}</textarea>
                            </div>
                            <div class="dados-loja" id="radioLoja">
                                <label class="labelRadio"><input class="input" type="radio" name="opcao" value="1"
                                        required>Disponível</label>
                                <label class="labelRadio"><input class="input" type="radio" name="opcao" value="1"
                                        required>Fechado</label>
                            </div>
                        </div>
                        <div class="botoes-loja">
                            <button class="botaoLoja" type="submit" name="submit" value="1">Salvar</button>
                            <button class="botaoLoja">Editar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="container-produtos">
            <div id="h1">
                <h1>PRODUTOS</h1>
            </div>
            <div id="produtos">
                <div class="container-produto">
                    <div class="container-img-produtos">
                        <label class="picture-produtos" for="picture_input-produtos" tabindex="0">
                            <span class="picture_image-produtos"></span>
                            <input type="file" name="picture_input-produtos" id="picture_input-produtos" />
                        </label>
                    </div>
                    <div class="container-forms-produto">
                        <form style="display: flex;" action="gerenciarLoja" method="post">
                            <div>
                                <div class="dados-produto">
                                    <label class="labels-produto">Produto:</label>
                                    <input type="text" class="form-control-produto" name="produto" placeholder="">
                                    <label class="labels-produto">R$:</label>
                                    <input type="text" class="form-control-produto" name="valor" placeholder=""
                                        onKeyPress="return(moeda(this,'.',',',event))">
                                    <label class="labels-produto">Quantidade:</label>
                                    <div class="botoesQuantidade">
                                        <button class="quantidade-btn" type="button">-</button>
                                        <span class="quantidade" name="quantidade">0</span>
                                        <button class="quantidade-btn" type="button">+</button>
                                    </div>
                                </div>
                                <div class="botoes-produto">
                                    <button class="botaoProduto" type="submit" name="submit" value="2">Adicionar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <script src="scripts/editarloja.js"></script>
    <script src="scripts/menu.js"></script>
</body>

</html>
