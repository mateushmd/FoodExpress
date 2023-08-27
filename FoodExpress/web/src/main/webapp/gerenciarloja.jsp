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
        <c:set var="produtos" value="${sessionScope.produtos}"/>
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