import abrirModal from "../../janelas-modais/modal.js";

$(function() {
    $('.add-produto').each(function(index) {
       let current = $(this);

       current.on('click', () => adicionar(current));
    });

    $('.remover-produto').each(function(index) {
       let current = $(this);

       current.on('click', () => remover(current));
    });

    $('#modal-produto-salvar').on('click', () => editar());

    $('#modal-produto-body .toggle').each(function(index){
        let parent = $(this);

        let buttons = parent.find('.toggle-button');

        buttons.each(function(index) {
            let current = $(this)

            current.on('click', () => interagir(parent, index));
        });
    });
})

const adicionar = function(button) {
    let categoria = button.closest('.categoria');

    let produtosContainer = button.parent();

    let idCategoria = categoria.data('id');

    $.ajax({
        type: 'POST',
        url: 'minha-loja/produtos/adicionar-produto',
        data: {idCategoria: idCategoria},
        success: function(response) {
            let produto = $('.produto.clone').clone();

            produto.removeClass('clone');
            produto.removeClass('hidden');

            produto.attr('data-id', response.id);

            let editarButton = produto.find('.editar-produto');

            editarButton.on('click', () => abrirModal(editarButton.get(0)));

            let removerButton = produto.find('.remover-produto');

            removerButton.on('click', () => remover(removerButton));

            produtosContainer.prepend(produto);

            let text = categoria.find('.ct-vazia');

            if(text.length > 0) {
                text.remove();
            }
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}

const remover = function(button) {
    let produto = button.parent();

    let id = produto.data('id');

    let categoria = produto.closest('.categoria');

    let idCategoria = categoria.data('id');

    $.ajax({
        type: 'POST',
        url: 'minha-loja/produtos/remover-produto',
        data: {id: id, idCategoria: idCategoria},
        success: function(response) {
            produto.remove();

            if(response.categoriaVazia === true) {
                let before = categoria.find('.nome-categoria');
                $('<p>', {'class': 'ct-vazia'}).text('Categoria vazia').insertAfter(before);
            }

        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
};

const editar = function() {
    $('#aviso').remove();

    let container = $('#modal-produto-salvar-container');

    let id = $('#modal-produto-id').val();

    let nome = $('#modal-produto-nome').val();

    if(nome.trim().length === 0) {
        container.prepend($('<p>', {'id': 'aviso'}).text('O produto deve conter um nome!'));
        $('#modal-produto-nome').focus();
        return;
    }

    let descricao = $('#modal-produto-descricao').val();
    let preco = parseFloat($('#modal-produto-preco').val().replace(',', '.'));
    let disponivel = !$('.modal .toggle.visibilidade button:first-of-type').hasClass('active');
    let destaque = !$('.modal .toggle.destaque button:first-of-type').hasClass('active');

    const loader = $('<div>', {'class': 'loader'});

    const checkmark = $('<div>', {'class': 'checkmark hidden'});

    loader.append(checkmark);

    container.append(loader);

    $.ajax({
        type: 'POST',
        url: 'minha-loja/produtos/editar-produto',
        data: {id: id, nome: nome, descricao: descricao, preco: preco, disponivel: disponivel, destaque: destaque},
        success: function(response) {
            let produto = $(`.produto[data-id="${id}"]`);

            produto.find('.nome').text(nome);
            produto.find('.descricao').text(descricao.trim().length > 0 ? descricao : '');
            produto.find('.preco').val(preco.toFixed(2).replace('.', ','));
            produto.find('.visibilidade').text(disponivel ? 'Ativado' : 'Pausado');

            if(destaque)
                produto.find('.informacoes').append($('<p>', {'class': 'destaque'}).text('Destaque'));
            else
                produto.find('.destaque').remove();

            loader.addClass('complete');
            checkmark.removeClass('hidden');
            checkmark.addClass('draw');

            setTimeout(function() {
                loader.addClass('hide');

                setTimeout(function() {
                    loader.remove();
                }, 400);
            }, 1000);
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
};

const interagir = function(parent, index) {
    let buttons = parent.find('.toggle-button');

    let button = $(buttons.get(index));
    let other = $(buttons.get(!index ? 1 : 0));

    button.addClass('active');

    other.removeClass('active');

    if (parent.hasClass('destaque'));
        return;

    if (!index)
    {
        button.text('Pausado');
        other.text('Ativar');
    }
    else
    {
        button.text('Ativado');
        other.text('Pausar');
    }
}

export default adicionar;