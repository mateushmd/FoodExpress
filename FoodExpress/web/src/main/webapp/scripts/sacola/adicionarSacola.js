import remover from './removerSacola.js';

$(function() {
    const adicionarElement = $('#modal-produto-adicionar');

    adicionarElement.click(function(e) {
        if(adicionarElement.hasClass('loading'))
        {
            console.log('loading');
            return;
        }

        let pElements = adicionarElement.find('p');

        pElements.addClass('hidden');

        const loader = $('<div>', {'class': 'loader white'});

        const checkmark = $('<div>', {'class': 'checkmark hidden'});

        loader.append(checkmark);

        adicionarElement.append(loader);

        adicionarElement.addClass('loading');

        let produtoId = $('#modal-produto-id').val();
        let quantidade = $('p .modal-produto-quantidade').text();

        $.ajax({
            type: 'POST',
            url: 'sacola/adicionar-sacola',
            data: {idProduto: produtoId, quantidade: quantidade},
            success: function(response) {
                loader.addClass('complete');
                checkmark.removeClass('hidden');
                checkmark.addClass('draw');

                setTimeout(function() {
                    loader.addClass('hide');

                    setTimeout(function() {
                        loader.remove();
                        pElements.removeClass('hidden');
                    }, 400);
                }, 1000);

                adicionarElement.removeClass('loading');

                let headerPrecoEl = $('#orders-preco');
                let preco = parseFloat(headerPrecoEl.text().replace(',', '.'));
                headerPrecoEl.text((preco + response.precoTotal).toFixed(2).replace('.', ','));

                let headerQuantidadeEl = $('#orders-quantidade');
                headerQuantidadeEl.text(parseInt(headerQuantidadeEl.text()) + response.quantidade);

                let sacolaPrecoEl = $('#bag-preco');
                sacolaPrecoEl.text(headerPrecoEl.text());

                if(response.responseType === 'atualizar') {
                    let produtoContainerEl = $(`.bag-produto[data-id-produto="${response.idProduto}"]`);

                    console.log(produtoContainerEl);

                    let produtoQuantidadeEl = produtoContainerEl.find('.bag-produto-quantidade');
                    produtoQuantidadeEl.text(parseInt(produtoQuantidadeEl.text()) + response.quantidade);

                    let produtoPrecoEl = produtoContainerEl.find('.bag-produto-preco');
                    preco = parseFloat(produtoPrecoEl.text().replace(',', '.'));
                    produtoPrecoEl.text((preco + response.precoTotal).toFixed(2).replace('.', ','));

                    return;
                }

                if(response.responseType === 'gerarSacola') {
                    $('#empty-bag').addClass('hidden');
                    $('#bag-container').removeClass('hidden');
                    $('#bag-nome').text(response.nomeLoja);
                    $('#bag-anchor').attr('href', `loja?id=${response.idLoja}`);
                }

                let produtoEl = $('.bag-produto.clone').clone();

                produtoEl.removeClass('hidden');
                produtoEl.removeClass('clone');

                produtoEl.attr('data-id-produto', response.produtoId);
                produtoEl.attr('data-id-item', response.itemSacolaId);

                produtoEl.find('.bag-produto-quantidade').text(response.quantidade);

                produtoEl.find('.bag-produto-nome').text(response.produtoNome);

                produtoEl.find('.bag-produto-preco').text(response.precoTotal.toFixed(2).replace('.', ','));

                produtoEl.find('.bag-produto-descricao').text(response.produtoDescricao);

                let removerProdutoEl = produtoEl.find('.bag-remover-produto')

                removerProdutoEl.on('click', function() {
                    remover(removerProdutoEl);
                });

                $('.bag-produtos').append(produtoEl);
            },
            error: function(xhr, status, error) {
                console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        });
    });
});