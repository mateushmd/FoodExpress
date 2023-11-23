<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FoodExpress</title>
        <link rel="stylesheet" type="text/css" href="styles/main/main.css">
        <link rel="stylesheet" type="text/css" href="styles/minhaLoja.css">
        <link rel="stylesheet" href="styles/rating.css">
        <link rel="stylesheet" href="styles/main/modal.css">
        <link rel="icon" type="image/png" href="imgs/icon.png" />
    </head>
    <body>
        <c:choose>
            <c:when test="${empty sessionScope.usuario}">
                <c:redirect url="login.jsp" />
            </c:when>
            <c:otherwise>
                <c:set var="usuario" value="${sessionScope.usuario}" />
            </c:otherwise>
        </c:choose>

        <c:if test="${usuario.tipo ne 2}">
            <c:redirect url="login.jsp" />
        </c:if>

        <c:set var="loja" value="${sessionScope.loja}" />

        <c:set var="categorias" value="${sessionScope.categorias}" />

        <c:set var="avaliacoes" value="${sessionScope.avaliacoes}" />

        <c:set var="agenda" value="${sessionScope.agenda}" />

        <c:set var="pontos" value="${sessionScope.pontosEncontro}" />

        <c:set var="pedidos" value="${sessionScope.pedidos}" />

        <div id="overlay" class="hidden"></div>

        <div id="barra-lateral-container">
            <div>
                <section class="barra-lateral-section">
                    <div id="container-horario">
                        <h1><img width="25" height="25" src="https://img.icons8.com/windows/32/so-so--v1.png"
                                 alt="so-so--v1" />
                            Olá, ${usuario.nome}</h1>
                        <table id="horarios">
                            <thead>
                                <tr>
                                    <th colspan="2">Dia da Semana</th>
                                    <th>Abertura</th>
                                    <th>Fechamento</th>
                                    <th>C1</th>
                                    <th>C2</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${agenda}" var="a">
                                    <tr class="dia" data-dia="${a.diaSemana}">
                                        <td class="dia-da-semana"></td>
                                        <td class="ativado-desativado">
                                            <input type="checkbox" class="liga-desliga__checkbox horario" ${a.idLoja ne -1 ? 'checked' : ''}>
                                            <label class="liga-desliga__botao"></label>
                                        </td>
                                        <td><input type="time" class="abertura" value="${a.abertura ne null ? a.abertura : ''}" ${a.abertura eq null ? 'disabled' : ''}></td>
                                        <td><input type="time" class="fechamento" value="${a.fechamento ne null ? a.fechamento : ''}" ${a.fechamento eq null ? 'disabled' : ''}></td>


                                        <td><input type="radio" name="campus-${a.diaSemana}" class="campus c1" value="1" ${a.idLoja eq -1 ? 'disabled' : a.campus1 ? 'checked' : ''}></td>
                                        <td><input type="radio" name="campus-${a.diaSemana}" class="campus c2" value="2" ${a.idLoja eq -1 ? 'disabled' : a.campus2 ? 'checked' : ''}></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div>
                            <button type="button" id="horario">Salvar</button>
                        </div>
                    </div>
                    <div class="linha-de-separacao"></div>
                    <div class="menu-localidade">
                        <c:forEach items="${pontos}" var="campus" varStatus="loop">
                            <div class="container-local" data-campus="${loop.index + 1}">
                                <div class="container-local-header">
                                    <h2>Campus ${loop.index + 1}</h2>
                                    <button class="icon-expande-local-btn">
                                        <svg viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg" class="icon-expande">
                                        <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                        <g transform="translate(-433.000000, -1392.000000)" fill="currentColor"
                                           fill-rule="nonzero">
                                        <g transform="translate(47.000000, 1227.000000)">
                                        <g class="icon-seta-restaurante"
                                           transform="translate(386.000000, 165.000000)">
                                        <path
                                            d="M17.4142136,18.5479578 C16.633165,17.8173474 15.366835,17.8173474 14.5857864,18.5479578 C13.8047379,19.2785683 13.8047379,20.4631219 14.5857864,21.1937324 L24,30 L33.4142136,21.1937324 C34.1952621,20.4631219 34.1952621,19.2785683 33.4142136,18.5479578 C32.633165,17.8173474 31.366835,17.8173474 30.5857864,18.5479578 L24,24.708451 L17.4142136,18.5479578 Z"
                                            id="Path-5-Copy-3"></path>
                                        </g>
                                        </g>
                                        </g>
                                        </g>
                                        </svg>
                                    </button>
                                </div>
                                <div class="submenu">
                                    <div>
                                        <input type="text" placeholder="Ponto de encontro" class="ponto-encontro"
                                               maxlength="40">
                                        <button type="button" class="botao salvar-ponto">Adicionar
                                        </button>
                                        <h2>Pontos de Encontro</h2>
                                        <div class="pontos-encontro">
                                            <c:choose>
                                                <c:when test="${empty campus}">
                                                    <p class="pontos-encontro-msg">Comece adicionando algum ponto de encontro</p>
                                                </c:when>
                                                <c:otherwise>
                                                    <c:forEach items="${campus}" var="ponto">
                                                        <div class="ponto-encontro-container" data-id="${ponto.id}">
                                                            <p>${ponto.nome}</p>
                                                            <button class="excluir-ponto">
                                                                <img src="imgs/x-symbol.svg">
                                                            </button>
                                                        </div>
                                                    </c:forEach>
                                                </c:otherwise>
                                            </c:choose>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <c:if test="${loop.index eq 0}"><div class="linha-de-separacao"></div></c:if>
                        </c:forEach>
                    </div>
                    <div class="linha-de-separacao"></div>
                    <div id="promoverLoja" class="modal-trigger" data-modal-index="4">
                        <img id="imgPromove" src="imgs/minha-loja/promover.png" alt="">
                    </div>
                </section>
                <section class="barra-lateral-section hidden">
                    <h1><img src="imgs/minha-loja/pedidos.svg" alt=""> Pedidos</h1>

                    <div class="mensagem ${empty pedidos ? '' : 'hidden'}">
                        <img src="imgs/sad.svg" alt="">
                        <h2>Oh não!</h2>
                        <p>Você ainda não fez o seu primeiro pedido no FoodExpress! Tá esperando o que?</p>
                    </div>
                    <c:forEach items="${pedidos}" var="pedido">
                        <div class="pedido">
                            <div class="pedido-header">
                                <div>
                                    <img src="imgs/teste/teste.png" alt="">
                                    <div>
                                        <p>Pedido concluído</p>
                                        <p>Nº ${pedido.id}</p>
                                    </div>
                                </div>

                                <div>
                                    <p><fmt:formatDate value="${pedido.dataPedido}" pattern="dd/MM/yyyy"/></p>
                                </div>
                            </div>
                            <div class="pedido-body">
                                <c:forEach items="${pedido.produtos}" var="produto">
                                    <p><span class="quantidade">${produto.quantidade}</span> ${produto.nome}</p>
                                </c:forEach>
                            </div>
                            <div class="pedido-footer">
                                <p>Total:</p>
                                <p class="preco"><fmt:formatNumber value='${pedido.pTotal}' pattern='0.00' /></p>
                            </div>
                        </div>
                    </c:forEach>
                </section>
                <section class="barra-lateral-section hidden" id="avaliacoes">
                    <h1><img src="imgs/minha-loja/star.svg" alt=""> Avaliações</h1>

                    <div id="avaliacoes-header">
                        <div class="rating process-rating" data-rating="<fmt:formatNumber value="${loja.avaliacao}" type="number" maxFractionDigits="0"/>" data-slider-index="1">
                            <input class="star-input" id="star1" type="radio" name="rating" value="1">
                            <label class="star-label" for="star1" data-star="1"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>

                            <input class="star-input" id="star2" type="radio" name="rating" value="2">
                            <label class="star-label" for="star2" data-star="2"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>

                            <input class="star-input" id="star3" type="radio" name="rating" value="3">
                            <label class="star-label" for="star3" data-star="3"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>

                            <input class="star-input" id="star4" type="radio" name="rating" value="4">
                            <label class="star-label" for="star4" data-star="4"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>

                            <input class="star-input" id="star5" type="radio" name="rating" value="5">
                            <label class="star-label" for="star5" data-star="5"><img src="imgs/gray-star.svg"
                                                                                     alt=""></label>
                        </div>
                        <p><fmt:formatNumber value="${loja.avaliacao}" type="number" pattern="#,##0.0" /></p>
                        <h2>${loja.qtdAvaliacoes} avaliações</h2>
                    </div>

                    <div id="avaliacoes-body">
                        <c:forEach items="${avaliacoes}" var="avaliacao">
                            <div class="comentario">
                                <h2>${avaliacao.idCliente}</h2>
                                <p>${avaliacao.comentario}</p>
                                <div class="comentario-footer">
                                    <div>
                                        <span>${avaliacao.nota}</span>
                                        <div class="rating process-rating small" data-rating="${avaliacao.nota}">
                                            <input class="star-input" type="radio" name="rating" value="1">
                                            <label class="star-label" for="star1" data-star="1"><img src="imgs/gray-star.svg"
                                                                                                     alt=""></label>

                                            <input class="star-input" type="radio" name="rating" value="2">
                                            <label class="star-label" for="star2" data-star="2"><img src="imgs/gray-star.svg"
                                                                                                     alt=""></label>

                                            <input class="star-input" type="radio" name="rating" value="3">
                                            <label class="star-label" for="star3" data-star="3"><img src="imgs/gray-star.svg"
                                                                                                     alt=""></label>

                                            <input class="star-input" type="radio" name="rating" value="4">
                                            <label class="star-label" for="star4" data-star="4"><img src="imgs/gray-star.svg"
                                                                                                     alt=""></label>

                                            <input class="star-input" type="radio" name="rating" value="5">
                                            <label class="star-label" for="star5" data-star="5"><img src="imgs/gray-star.svg"
                                                                                                     alt=""></label>
                                        </div>
                                    </div>
                                    <span><fmt:formatDate value="${avaliacao.data}" pattern="dd/MM/yyyy"/></span>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </section>
                <section class="barra-lateral-section hidden" id="dados-pessoais">
                    <h1><img src="imgs/header/engrenagem.svg" alt="">Dados pessoais</h1>
                    <ul>
                        <li>
                            <p>Nome</p>
                            <div class="opcao-body">
                                <input type="text" class="editavel" id="name" value="${usuario.nome}">
                            </div>
                        </li>
                        <li>
                            <p>E-mail</p>
                            <div class="opcao-body">
                                <input type="text" value="${usuario.email}" disabled>
                            </div>
                        </li>
                        <li>
                            <p>Celular</p>
                            <div class="opcao-body">
                                <input type="text" class="editavel" id="phone" value="${usuario.telefone}" maxlength="16">
                            </div>
                        </li>
                    </ul>
                    <div class="botao-dados-container">
                        <div class="botao-dados">
                            <input type="submit" value="Alterar senha" id="alterar-senha">
                        </div>
                        <div class="botao-dados">
                            <input type="submit" value="Salvar" id="save" class="hidden" name="SUBMIT">
                        </div>
                    </div>
                    <div class="botao-dados-container">
                        <div class="botao-dados">
                            <a href="logout">
                                <input type="submit" value="Sair" id="sair">
                            </a>
                        </div>
                    </div>

                    <input type="hidden" value="${usuario.nome}" id="default-nome" class="default">
                    <input type="hidden" value="${usuario.telefone}" id="default-telefone" class="default">
                </section>
            </div>
            <nav id="barra-lateral-navegador">
                <div class="selected" data-barra-lateral-section-index="0">
                    <button>
                        <img src="imgs/minha-loja/info.svg" alt="">
                    </button>
                </div>
                <div data-barra-lateral-section-index="1">
                    <button>
                        <img src="imgs/minha-loja/pedidos.svg" alt="">
                        <div id="notificacao"></div>
                    </button>
                </div>
                <div data-barra-lateral-section-index="2">
                    <button>
                        <img src="imgs/minha-loja/star.svg" alt="">
                    </button>
                </div>
                <div data-barra-lateral-section-index="3">
                    <button>
                        <img src="imgs/header/engrenagem.svg" alt="">
                    </button>
                </div>
            </nav>
        </div>
<div>
            <input hidden="false" type="text" id="emailFb" value="${usuario.email}">
        </div>  
        <main>
            <div id="container-dados-loja">
                <div id="container-img-loja">
                    <label id="banner" for="picture-banner" tabindex="0">
                        <span id="picture-image-loja"></span>
                        <input type="file" name="picture-input-loja" id="picture-banner" onchange="previewBanner()" />

                    </label>
                    <label id="perfil" for="picture-input-loja-perfil" tabindex="0">
                        <span id="picture-perfil">Foto</span>
                        <input type="file" name="picture-input-loja-perfil" id="picture-input-loja-perfil" accept="image/*"
                               onchange="previewPerfil()" />
                    </label>
                </div>
                <div id="container-info-loja">
                    <ul>
                        <li>
                            <input type="text" name="name" id="nome-loja" class="info-loja"
                                   placeholder="Adicionar nome da loja" value="${loja.nome}">
                        </li>
                    </ul>
                    <ul>
                        <li>
                            <textarea type="text" name="name" id="descricao-loja" class="info-loja"
                                      placeholder="Descrição da loja" maxlength="1000">${loja.descricao}</textarea>
                        </li>
                    </ul>
                    <div>
                        <button type="button" class="botao hidden" id="salvar-dados-loja">Salvar dados</button>
                    </div>

                    <input type="hidden" class="default-campo-loja" id="default-nome-loja" value="${loja.nome}">
                    <input type="hidden" class="default-campo-loja" id="default-descricao-loja" value="${loja.descricao}">
                </div>
            </div>
            <h2 id="h2Produtos">Produtos &#10095;</h2>
            <div id="categorias">
                <c:forEach items="${categorias}" var="categoria">
                    <div class="categoria" data-id="${categoria.id}">
                        <div class="menu-categoria">
                            <input type="text" class="nome-categoria" value="${categoria.nome}" disabled>
                            <c:if test="${empty categoria.produtos}">
                                <p class="ct-vazia">Categoria vazia</p>
                            </c:if>
                            <div class="opcoes">
                                <button class="editar-categoria">Editar</button>
                                <div class="toggle">
                                    <button class="toggle-button ${!categoria.visivel ? 'active' : ''}">${!categoria.visivel ? 'Pausado' : 'Pausar'}</button>
                                    <button class="toggle-button ${categoria.visivel ? 'active' : ''}">${categoria.visivel ? 'Ativado' : 'Ativar'}</button>
                                </div>
                                <button class="icon-expande-btn">
                                    <svg viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg" class="icon-expande">
                                    <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                    <g transform="translate(-433.000000, -1392.000000)" fill="currentColor"
                                       fill-rule="nonzero">
                                    <g transform="translate(47.000000, 1227.000000)">
                                    <g class="icon-seta-restaurante"
                                       transform="translate(386.000000, 165.000000)">
                                    <path
                                        d="M17.4142136,18.5479578 C16.633165,17.8173474 15.366835,17.8173474 14.5857864,18.5479578 C13.8047379,19.2785683 13.8047379,20.4631219 14.5857864,21.1937324 L24,30 L33.4142136,21.1937324 C34.1952621,20.4631219 34.1952621,19.2785683 33.4142136,18.5479578 C32.633165,17.8173474 31.366835,17.8173474 30.5857864,18.5479578 L24,24.708451 L17.4142136,18.5479578 Z"
                                        id="Path-5-Copy-3"></path>
                                    </g>
                                    </g>
                                    </g>
                                    </g>
                                    </svg>
                                </button>
                                <button class="remover-categoria" data-modal-index="3">
                                    <img src="imgs/lixeira.svg" alt="">
                                </button>
                            </div>
                        </div>
                        <div class="body-categoria">
                            <div class="linha-de-separacao-cardapio"></div>
                            <div class="container-adiciona-categoria">
                                <div class="produtos">
                                    <c:forEach items="${categoria.produtos}" var="produto">
                                        <div class="produto" data-id="${produto.id}">
                                            <div class="img-container">
                                                <img class="img-produto" src="imgs/teste/teste.png" alt="${produto.nome}">
                                            </div>

                                            <div>
                                                <p class="nome">${produto.nome}</p>
                                                <p class="descricao">${produto.descricao}</p>
                                            </div>
                                            <div class="input-container">
                                                <div>
                                                    <label for="preco">R$</label>
                                                    <input type="text" name="preco" class="preco moeda" disabled value="<fmt:formatNumber value='${produto.preco}' pattern='0.00' />" />
                                                </div>
                                                <div class="informacoes">
                                                    <p class="visibilidade">${produto.disponivel eq true ? 'Ativado' : 'Pausado'}</p>
                                                    <c:if test="${produto.destaque}">
                                                        <p class="destaque">Destaque</p>
                                                    </c:if>
                                                </div>
                                            </div>
                                            <button class="botao editar-produto modal-trigger" data-modal-index="2">Editar</button>
                                            <img class="remover-produto" src="imgs/lixeira.svg" alt="">
                                        </div>
                                    </c:forEach>
                                    <button class="botao add-produto">+ Adicionar produto</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <button id="add-categoria" class="botao">+ Adicionar categoria</button>

                <!--Templates para clonagem em scripts-->
                <div class="categoria clone hidden">
                    <div class="menu-categoria">
                        <input type="text" class="nome-categoria" value="Nova categoria" disabled>
                        <p class="ct-vazia">Categoria vazia</p>
                        <div class="opcoes">
                            <button class="editar-categoria">Editar</button>
                            <div class="toggle">
                                <button class="toggle-button active">Pausado</button>
                                <button class="toggle-button">Ativar</button>
                            </div>
                            <button class="icon-expande-btn">
                                <svg viewBox="0 0 48 48" xmlns="http://www.w3.org/2000/svg" class="icon-expande">
                                <g stroke="none" stroke-width="1" fill="none" fill-rule="evenodd">
                                <g transform="translate(-433.000000, -1392.000000)" fill="currentColor"
                                   fill-rule="nonzero">
                                <g transform="translate(47.000000, 1227.000000)">
                                <g class="icon-seta-restaurante"
                                   transform="translate(386.000000, 165.000000)">
                                <path
                                    d="M17.4142136,18.5479578 C16.633165,17.8173474 15.366835,17.8173474 14.5857864,18.5479578 C13.8047379,19.2785683 13.8047379,20.4631219 14.5857864,21.1937324 L24,30 L33.4142136,21.1937324 C34.1952621,20.4631219 34.1952621,19.2785683 33.4142136,18.5479578 C32.633165,17.8173474 31.366835,17.8173474 30.5857864,18.5479578 L24,24.708451 L17.4142136,18.5479578 Z"
                                    id="Path-5-Copy-3"></path>
                                </g>
                                </g>
                                </g>
                                </g>
                                </svg>
                            </button>
                            <button class="remover-categoria" data-modal-index="3">
                                <img src="imgs/lixeira.svg" alt="">
                            </button>
                        </div>
                    </div>
                    <div class="body-categoria">
                        <div class="linha-de-separacao-cardapio"></div>
                        <div class="container-adiciona-categoria">
                            <div class="produtos">
                                <button class="botao add-produto">+ Adicionar produto</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="produto clone hidden">
                    <img class="img-produto" src="imgs/teste/teste.png" alt="">
                    <div>
                        <p class="nome">Novo produto</p>
                        <p class="descricao"></p>
                    </div>
                    <div class="input-container">
                        <div>
                            <label for="preco">R$</label>
                            <input type="text" name="preco" class="preco moeda" disabled value="0.00" />
                        </div>
                        <div class="informacoes">
                            <p class="visibilidade">Pausado</p>
                        </div>
                    </div>
                    <button class="botao editar-produto modal-trigger" data-modal-index="2">Editar</button>
                    <img class="remover-produto" src="imgs/lixeira.svg" alt="">
                </div>
            </div>
        </main>

        <div class="modal generic hidden" id="modal-produto" data-modal-index="2" data-lock-screen="true">
            <button class="modal-produto-botao close-modal styled">
                <img src="imgs/x-symbol.svg" alt="">
            </button>
            <div id="modal-produto-body">
                <div id="modal-produto-main">
                    <ul>
                        <li>
                            <div class="campo">
                                <p>Nome</p>
                                <div class="opcao">
                                    <input type="text" id="modal-produto-nome">
                                </div>
                            </div>
                            <div class="campo">
                                <p>Preço</p>
                                <div class="opcao">
                                    <label for="modal-produto-preco">R$</label>
                                    <input type="text" name="preco" id="modal-produto-preco" class="moeda">
                                </div>
                            </div>
                        </li>
                        <li>
                            <p>Descrição</p>
                            <div class="opcao">
                                <textarea name="descricao" id="modal-produto-descricao" cols="30" rows="10"></textarea>
                            </div>
                        </li>
                        <li>
                            <div class="campo">
                                <p>Visibilidade</p>
                                <div class="opcao">
                                    <div class="toggle visibilidade">
                                        <button class="toggle-button active">Pausado</button>
                                        <button class="toggle-button">Ativar</button>
                                    </div>
                                </div>
                            </div>
                            <div class="campo">
                                <p>Destaque</p>
                                <div class="opcao">
                                    <div class="toggle destaque">
                                        <button class="toggle-button active">Não</button>
                                        <button class="toggle-button">Sim</button>
                                    </div>
                                </div>
                            </div>
                        </li>
                    </ul>
                    <div id="modal-produto-salvar-container">
                        <button class="botao" id="modal-produto-salvar">Salvar</button>
                    </div>
                </div>
                <div id="modal-produto-img">
                    <div style="width: 300px; height: 300px; border: 2px solid black;">
                        <img id="imgProduto" style="max-width: 100%; max-height: 100%;">
                    </div>
                    <input type="file" id="file-inputProduto" accept="image/*">
                    <script>document.getElementById('file-inputProduto').addEventListener('change', function(e) {
                        const file = e.target.files[0];
                        if (file) {
                        const reader = new FileReader();
                        reader.onload = function(e) {
                        document.getElementById('imgProduto').src = e.target.result;
                        };
                        reader.readAsDataURL(file);
                        }
                        });
                    </script>
                </div>
            </div>
            <input type="hidden" id="modal-produto-id">
        </div>

        <div class="modal hidden" id="alerta" data-modal-index="3" data-lock-screen="true">
            <h1>Atenção</h1>
            <p>Esta categoria contém um ou mais produtos. Removê-la resultará na remoção de todos os produtos contidos nela. Deseja prosseguir?</p>
            <div>
                <button class="botao close-modal" id="alerta-sim">Sim</button>
                <button class="botao close-modal" id="alerta-nao">Não</button>
            </div>
        </div>

        <div class="modal generic hidden" data-modal-index="4" data-lock-screen="true">
            <button class="modal-produto-botao close-modal styled">
                <img src="imgs/x-symbol.svg" alt="">
            </button>
            <div class="modal-content">
                <div id="conteudo-promove">
                    <div id="conteudo-top-promove">
                        <h3 id="h3Promove">Carregue aqui uma imagem para promover sua loja!</h3>
                        <label id="picture-promove" for="picture-input-promove" tabindex="0">
                            <span id="picture-image-promove">Carregar Imagem</span>
                            <input type="file" name="picture-input-promove" id="picture-input-promove"
                                   accept="image/*" onchange="previewPromocao()" />
                        </label>
                    </div>

                    <div id="btns-promove">
                        <button id="btnPromoveS">Salvar</button>
                        <button id="btnPromoveE">Editar</button>
                    </div>

                </div>
            </div>
        </div>

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
            let e = document.getElementById("emailFb");
            const storageRef = ref(storage, 'lojaPerfil/' + e.value);
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
            const inputLojaPerfil = document.getElementById('picture-input-loja-perfil');
            inputLojaPerfil.addEventListener('change', () => {
            const file = inputLojaPerfil.files[0];
            if (file) {
            uploadFile(file);
            }
            });
            });</script>

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
            let e = document.getElementById("emailFb");
            const storageRef = ref(storage, 'lojaBanner/' + e.value);
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
            const inputLojaBanner = document.getElementById('picture-banner');
            inputLojaBanner.addEventListener('change', () => {
            const file = inputLojaBanner.files[0];
            if (file) {
            uploadFile(file);
            }
            });
            });</script>
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
            let e = document.getElementById("emailFb");
            const storageRef = ref(storage, 'lojaPerfil/' + e.value);
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
            const imgElement = document.getElementById('picture-img');
            imgElement.src = imageUrl;
            });
        </script>


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
            let e = document.getElementById("emailFb");
            let produtoNome = document.getElementById("modal-produto-nome");
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
            const fileInput = document.getElementById('file-inputProduto'); //Alteração
            fileInput.addEventListener('change', () => {
            const file = fileInput.files[0];
            if (file) {
            uploadFile(file);
            }
            });
            });</script>


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
            let e = document.getElementById("emailFb");
            const storageRef = ref(storage, 'lojaBanner/' + e.value);
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
            const inputLojaBanner = document.getElementById('picture-input-promove');
            inputLojaBanner.addEventListener('change', () => {
            const file = inputLojaBanner.files[0];
            if (file) {
            uploadFile(file);
            }
            });
            });</script>

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
            const imgElements = document.querySelectorAll('.img-produto');
            imgElements.forEach(async imgElement => {
            const altText = imgElement.getAttribute('alt');
            console.log(altText);
            let email = document.getElementById("emailFb");
            const storageRef = ref(storage, 'ProdutoFoto/' + email.value + "/" + altText);
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

        <script src="scripts/jquery/jquery.js"></script>

        <script type="module" src="scripts/janelas-modais/modal.js"></script>

        <script src="scripts/minha-loja/agenda/gerenciarAgenda.js"></script>
        <script src="scripts/minha-loja/agenda/editarAgenda.js"></script>

        <script type="module" src="scripts/minha-loja/produtos/gerenciarProdutos.js"></script>

        <script type="module" src="scripts/minha-loja/categorias/gerenciarCategorias.js"></script>

        <script src="scripts/minha-loja/dados/editarDadosLoja.js"></script>
        <script src="scripts/minha-loja/dados/alterarDadosLoja.js"></script>

        <script src="scripts/minha-loja/alterarImagem.js"></script>

        <script src="scripts/minha-loja/pontos/gerenciarPontoEncontro.js"></script>

        <script src="scripts/usuario/dados/editarDados.js"></script>
        <script src="scripts/usuario/dados/alterarDados.js"></script>

        <script src="scripts/minha-loja/formatarMoeda.js"></script>

        <script src="scripts/minha-loja/barraLateral.js"></script>
        <script src="scripts/responsiveSideBar.js"></script>

        <script src="scripts/rating.js"></script>
        <script src="scripts/mascaras.js"></script>
    </body>

</html>