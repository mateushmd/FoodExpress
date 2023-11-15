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
                                <th>Dia da Semana</th>
                                <th>On/Off</th>
                                <th>Abertura</th>
                                <th>Fechamento</th>
                                <th>C1</th>
                                <th>C2</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Segunda-feira</td>
                                <td>
                                    <input type="checkbox" class="liga-desliga__checkbox horario" id="segundaAberto">
                                    <label for="segundaAberto" class="liga-desliga__botao"></label>
                                </td>
                                <td><input type="time" class="abertura" disabled></td>
                                <td><input type="time" class="fechamento" disabled></td>

                                <td><input type="radio" class="c1" name="c1_segunda" disabled></td>
                                <td><input type="radio" class="c2" name="c2_segunda" disabled></td>
                            </tr>
                            <tr>
                                <td>Terça-feira</td>
                                <td>
                                    <input type="checkbox" class="liga-desliga__checkbox horario" id="tercaAberto">
                                    <label for="tercaAberto" class="liga-desliga__botao"></label>
                                </td>
                                <td><input type="time" class="abertura" disabled></td>
                                <td><input type="time" class="fechamento" disabled></td>

                                <td><input type="radio" class="c1" name="c1_terca" disabled></td>
                                <td><input type="radio" class="c2" name="c2_terca" disabled></td>
                            </tr>
                            <tr>
                                <td>Quarta-feira</td>
                                <td>
                                    <input type="checkbox" class="liga-desliga__checkbox horario" id="quartaAberto">
                                    <label for="quartaAberto" class="liga-desliga__botao"></label>
                                </td>
                                <td><input type="time" class="abertura" disabled></td>
                                <td><input type="time" class="fechamento" disabled></td>

                                <td><input type="radio" class="c1" name="c1_quarta" disabled></td>
                                <td><input type="radio" class="c2" name="c2_quarta" disabled></td>
                            </tr>
                            <tr>
                                <td>Quinta-feira</td>
                                <td>
                                    <input type="checkbox" class="liga-desliga__checkbox horario" id="quintaAberto">
                                    <label for="quintaAberto" class="liga-desliga__botao"></label>
                                </td>
                                <td><input type="time" class="abertura" disabled></td>
                                <td><input type="time" class="fechamento" disabled></td>

                                <td><input type="radio" class="c1" name="c1_quinta" disabled></td>
                                <td><input type="radio" class="c2" name="c2_quinta" disabled></td>
                            </tr>
                            <tr>
                                <td>Sexta-feira</td>
                                <td>
                                    <input type="checkbox" class="liga-desliga__checkbox horario" id="sextaAberto">
                                    <label for="sextaAberto" class="liga-desliga__botao"></label>
                                </td>
                                <td><input type="time" class="abertura" disabled></td>
                                <td><input type="time" class="fechamento" disabled></td>

                                <td><input type="radio" class="c1" name="c1_sexta" disabled></td>
                                <td><input type="radio" class="c2" name="c2_sexta" disabled></td>
                            </tr>
                            <tr>
                                <td>Sábado</td>
                                <td>
                                    <input type="checkbox" class="liga-desliga__checkbox horario" id="sabadoAberto">
                                    <label for="sabadoAberto" class="liga-desliga__botao"></label>
                                </td>
                                <td><input type="time" class="abertura" disabled></td>
                                <td><input type="time" class="fechamento" disabled></td>

                                <td><input type="radio" class="c1" name="c1_sabado" disabled></td>
                                <td><input type="radio" class="c2" name="c2_sabado" disabled></td>
                            </tr>
                            <tr>
                                <td>Domingo</td>
                                <td>
                                    <input type="checkbox" class="liga-desliga__checkbox horario" id="domingoAberto">
                                    <label for="domingoAberto" class="liga-desliga__botao"></label>
                                </td>
                                <td><input type="time" class="abertura" disabled></td>
                                <td><input type="time" class="fechamento" disabled></td>

                                <td><input type="radio" class="c1" name="c1_domingo" disabled></td>
                                <td><input type="radio" class="c2" name="c2_domingo" disabled></td>
                            </tr>
                            </tbody>
                        </table>
                        <button type="button" id="horario">Salvar</button>

                    </div>
                    <div class="linha-de-separacao"></div>
                    <div class="menu-localidade">
                        <div class="container-local">
                            <h2>Campus 1 ⌵</h2>
                            <div class="submenu">
                                <div id="container-ponto-encontroc1">
                                    <input type="text" placeholder="Ponto de encontro" class="ponto-encontro"
                                           id="ponto-encontroc1">
                                    <button type="button" class="botao salvar-ponto">Adicionar
                                    </button>
                                    <h2>Pontos de Encontro</h2>
                                    <div class="pontos-encontro">
                                        <p class="pontos-encontro-msg">Comece adicionando algum ponto de encontro</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="linha-de-separacao"></div>
                        <div class="container-local">
                            <h2>Campus 2 ⌵</h2>
                            <div class="submenu">
                                <div id="container-ponto-encontroc2">
                                    <input type="text" placeholder="Ponto de encontro" class="ponto-encontro"
                                           id="ponto-encontroc2">
                                    <button type="button" class="botao salvar-ponto">Adicionar
                                    </button>
                                    <h2>Pontos de Encontro</h2>
                                    <div class="pontos-encontro">
                                        <p class="pontos-encontro-msg">Comece adicionando algum ponto de encontro</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="linha-de-separacao"></div>
                    <div id="promoverLoja">
                        <img id="imgPromove" src="imgs/minha-loja/promover.png" alt="">
                    </div>
                    <div id="myModal" class="modal hidden">
                        <div class="modal-content">
                            <span class="close">&times;</span>
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
                </section>
                <section class="barra-lateral-section hidden">
                    <h1><img src="imgs/minha-loja/pedidos.svg" alt=""> Pedidos</h1>
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
                                <input type="text" class="editavel" value="${usuario.nome}">
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
                                <input type="text" class="editavel" id="phone" value="${usuario.telefone}">
                            </div>
                        </li>
                    </ul>
                    <div id="botao-dados-container">
                        <div class="botao-dados">
                            <input type="submit" value="ALTERAR SENHA" id="senha">
                        </div>
                        <div class="botao-dados">
                            <input type="submit" value="SALVAR" id="save" class="hidden" name="SUBMIT">
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

        <main>
            <div id="container-dados-loja">
                <div id="container-img-loja">
                    <label id="banner" for="picture-banner" tabindex="0">
                        <span id="picture-image-loja"></span>
                        <input type="file" name="picture-input-loja" id="picture-banner" />
                    </label>
                    <label id="perfil" for="picture-input-loja-perfil" tabindex="0">
                        <span id="picture-perfil">Foto</span>
                        <input type="file" name="picture-input-loja-perfil" id="picture-input-loja-perfil" accept="image/*"
                               onchange="previewImage()" />
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
                <!--Se a categoria estiver vazia-->
                <div class="categoria">
                    <div class="menu-categoria">
                        <h2>Bebidas</h2>
                        <!--Se a categoria estiver vazia-->
                        <p class="ct-vazia">Categoria vazia</p>
                        <!--Se a categoria estiver vazia-->
                        <div class="opcoes">
                            <div class="toggle">
                                <button class="toggle-button active">Pausado</button>
                                <button class="toggle-button">Ativar</button>
                            </div>
                            <button class=" icon-expande-btn">
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
                            <button>
                                <img src="imgs/lixeira.svg" alt="">
                            </button>
                        </div>
                    </div>
                    <div class="body-categoria">
                        <div class="linha-de-separacao-cardapio"></div>
                        <div class="container-adiciona-categoria">
                            <div class="produtos">
                                <div class="produto">
                                    <img class="img-produto" src="imgs/teste/teste.jpg" alt="">
                                    <div>
                                        <p class="nome">Coquinha Gelada 300ml</p>
                                        <p class="descricao">ASDASDASDASD</p>
                                    </div>
                                    <div class="input-container">
                                        <div>
                                            <label for="preco">R$</label>
                                            <input type="number" id="preco" name="preco" class="preco moeda" disabled value="5.99" />
                                        </div>
                                        <div>
                                            <input type="number" id="quantidade" name="quantidade" class="quantidade" disabled value="3" />
                                            <label for="quantidade">unid.</label>
                                        </div>

                                    </div>
                                    <button class="botao editar-produto modal-trigger" data-modal-index="2">Editar</button>
                                    <img src="imgs/lixeira.svg" alt="">
                                </div>
                                <button class="botao" id="add-produto">+ Adicionar produto</button>
                            </div>
                        </div>
                    </div>
                </div>
                <button id="add-categoria" class="botao">+ Adicionar categoria</button>
            </div>
        </main>

        <div class="modal hidden" data-modal-index="2" data-lock-screen="true">
            <button id="close-modal" class="modal-produto-botao">
                <img src="imgs/x-symbol.svg" alt="">
            </button>
            <div id="modal-produto-body">
                <div id="modal-produto-main">
                    <ul>
                        <li>
                            <p>Nome</p>
                            <div class="opcao">
                                <input type="text" id="modal-produto-nome">
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
                                <p>Preço</p>
                                <div class="opcao">
                                    <label for="preco">R$</label>
                                    <input type="text" name="preco" id="modal-produto-preco" class="moeda">
                                </div>
                            </div>
                            <div class="campo">
                                <p>Quantidade</p>
                                <div class="opcao">
                                    <input type="number" id="modal-produto-quantidade" min="0">
                                </div>
                            </div>
                        </li>
                    </ul>
                    <div>
                        <button class="botao">Salvar</button>
                    </div>
                </div>
                <div id="modal-produto-img">
                    <img src="imgs/teste/teste.jpg" alt="">
                </div>
            </div>
        </div>

        <script src="scripts/jquery/jquery.js"></script>

        <script src="scripts/minha-loja/editarloja.js"></script>
        <script src="scripts/minha-loja/alterarImagem.js"></script>
        <script src="scripts/minha-loja/editarProduto.js"></script>
        <script src="scripts/minha-loja/editarHorarios.js"></script>
        <script src="scripts/minha-loja/editarPontoEncontro.js"></script>
        <script src="scripts/minha-loja/barraLateral.js"></script>
        <script src="scripts/minha-loja/alterarEstadoCategoria.js"></script>
        <script src="scripts/minha-loja/formatarMoeda.js"></script>
        <script src="scripts/minha-loja/editarDadosLoja.js"></script>
        <script src="scripts/minha-loja/alterarDadosLoja.js"></script>

        <script src="scripts/janelas-modais/modal.js"></script>
        <script src="scripts/dados/editarDados.js"></script>
        <script src="scripts/dados/alterarDados.js"></script>
        <script src="scripts/rating.js"></script>
        <script src="scripts/mascaras.js"></script>
    </body>

</html>