$(function() {
    $('#modal-produto-adicionar').click(function(e) {
        let produtoId = $('#modal-produto-id').val();
        let quantidade = $('p .modal-produto-quantidade').text();
        let precoItem = $('#modal-produto-preco').text().replace(',', '.');
        let precoTotal = $('.modal-produto-preco-total').first().text().replace(',', '.');

        $.ajax({
            type: 'POST',
            url: 'sacola/adicionar-sacola',
            data: {idProduto: produtoId, quantidade: quantidade, precoItem: precoItem, precoTotal: precoTotal},
            success: function(response) {
                try {
                    const jsonObject = JSON.parse(response);

                    let bagProduto = $('<div class="bag-produto"></div>');

                    let bagProdutoHeader = $('<div class="bag-produto-header"></div>');

                    let itemQuantidadeNome = $(`<p>${jsonObject.quantidade}x ${jsonObject.produtoNome}</p>`);
                    let preco = $(`<p class="preco">R$ ${jsonObject.precoTotal.toString().replace('.', ',')}</p>`);

                    bagProdutoHeader.append(itemQuantidadeNome, preco);

                    let bagProdutoBody = $(`<div class="bag-produto-body"></div>`);

                    let descricao = $(`<p>${jsonObject.produtoDescricao}</p>`);

                    bagProdutoBody.append(descricao);

                    let bagProdutoFooter = $(`<div class="bag-produto-footer"></div>`);

                    let editar = $('<input type="submit" value="Editar">');
                    let remover = $('<input type="submit" value="Remover">');

                    bagProdutoFooter.append(editar, remover);

                    bagProduto.append(bagProdutoHeader, bagProdutoBody, bagProdutoFooter);

                    $('.bag-categoria').append(bagProduto);
                } catch (e) {
                    console.error('Error parsing JSON: ', e);
                }
            },
            error: function(xhr, status, error) {
                console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        });
    });
});