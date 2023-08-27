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
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>

    <body>
        <c:set var="produtos" value="${sessionScope.produtos}"/>
        <header>
            <nav class="nav-bar">
                <div class="logo"><a href="menuprincipal.html"><img src="imgs/logo2.png" alt="Logo" id="logoimg"></a></div>

                <div class="menu-options">
                    <ul>
                        <li class="menu-item"><a href="menuprincipal.jsp" class="menu-link">INÍCIO</a></li>
                        <li class="menu-item"><a href="gerenciarperfil.jsp" class="menu-link">PERFIL</a></li>
                        <li class="menu-item"><a href="#" class="menu-link">PEDIDOS</a></li>
                        <li class="menu-item"><a href="#" class="menu-link">FAVORITOS</a></li>
                        <li class="menu-item"><a href="perfilVendedor.html" class="menu-link">MINHA LOJA</a></li>
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
                                        <input type="text" class="form-control-loja" name="nome" placeholder="">
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
                                    <button class="botaoLoja">Salvar</button>
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
                                            <input type="text" class="form-control-produto" name="produto" placeholder="">
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
                                            <button type="submit" class="botao-produto" name="submit" value="ADICIONAR">Adicionar</button>
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
                                               id="picture-cria-produto" />
                                    </label>
                                </div>
                                <div class="container-forms-produto">
                                    <form style="display: flex;" action="gerenciarProduto" method="post">
                                        <div class="edita-produto">
                                            <div class="dados-produto">
                                                <label class="labels-produto">Produto:</label>
                                                <input type="text" class="form-control-produto" name="produto" placeholder=""
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
                                                <button class="botao-produto salvar-produto" name="submit" value="EDITAR" disabled>Salvar</button>
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

        <script src="scripts/editarloja.js"></script>
        <script src="scripts/menu.js"></script>
    </body>

</html>