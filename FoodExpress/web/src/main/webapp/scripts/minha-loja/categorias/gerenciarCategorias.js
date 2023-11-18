import abrirModal from "../../janelas-modais/modal.js";
import adicionar from "../produtos/gerenciarProdutos.js";

$(function() {
    $('#add-categoria').on('click', function() {
        adicionarCategoria();
    });

    $('.remover-categoria').each(function(index) {
        let current = $(this);

        current.on('click', function() {
            removerCategoriaAlerta(current);
        });
    });

    $('#alerta-sim').on('click', function() {
        removerCategoria($(`.categoria[data-id="${$('#alerta').data('id')}"]`));
    })

    $('.toggle').each(function(index) {
        let buttons = $(this).find('.toggle-button');

        let categoria = $('.toggle').closest('.categoria');

        buttons.each(function(index) {
            $(this).on('click', () =>
            {
                alterarVisibilidade(categoria.data('id'), buttons, index);
            });
        });
    });

    $('.editar-categoria').each(function(index) {
       let current = $(this);

       current.on('click', () => editar(current));
    });

    $('.icon-expande-btn').each(function(index) {
        let current = $(this);

        current.on('click', () => expandir(current));
    });
});

const adicionarCategoria = function() {
    $.ajax({
        type: 'POST',
        url: 'minha-loja/categorias/adicionar-categoria',
        success: function(response) {
            let categoria = $('.categoria.clone').clone();

            categoria.removeClass('hidden');
            categoria.removeClass('clone');

            categoria.data('id', response.id);

            let toggleButtons = categoria.find('.toggle-button');

            toggleButtons.each(function(index) {
                $(this).on('click', () =>
                {
                    alterarVisibilidade(toggleButtons, index);
                });
            });

            let editarButton = categoria.find('.editar-categoria');

            editarButton.on('click', () => editar(editarButton));

            let expandirButton = categoria.find('.icon-expande-btn');

            expandirButton.on('click', () => expandir(expandirButton));

            let removerButton = categoria.find('.remover-categoria');

            removerButton.on('click', () => removerCategoriaAlerta(removerButton));

            let addProduto = categoria.find('.add-produto');

            addProduto.on('click', () => adicionar(addProduto));

            $('#categorias').prepend(categoria);
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}

const removerCategoriaAlerta = function(element) {
    const categoria = element.closest('.categoria');

    if(categoria.find('.produto').length > 0) {
        abrirModal(categoria.find('.remover-categoria').get(0));
        $('#alerta').data('id', categoria.data('id'));
        return;
    }

    removerCategoria(categoria);
}

const removerCategoria = function(categoria) {
    const id = categoria.data('id');

    $.ajax({
        type: 'POST',
        url: 'minha-loja/categorias/remover-categoria',
        data: {id: id},
        success: function(response) {
            categoria.remove();
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
};

const alterarVisibilidade = function(id, buttons, index) {
    let button = $(buttons.get(index));
    let other = $(buttons.get(!index ? 1 : 0));

    if (button.hasClass('active'))
        return;

    $.ajax({
        type: 'POST',
        url: 'minha-loja/categorias/alterar-visibilidade-categoria',
        data: {id: id},
        success: function(response) {
            button.addClass('active');

            other.removeClass('active');

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
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    })
}

const editar = function(button) {
    let categoria = button.closest('.categoria');

    let nomeInput = categoria.find('.nome-categoria');

    if(button.text() === 'Editar') {
        nomeInput.prop('disabled', false);

        button.text('Salvar');

        return;
    }

    let id = categoria.data('id');

    let nome = nomeInput.val();

    const loader = $('<div>', {'class': 'loader white'});

    const checkmark = $('<div>', {'class': 'checkmark hidden'});

    loader.append(checkmark);

    categoria.find('.opcoes').prepend(loader);

    $.ajax({
        type: 'POST',
        url: 'minha-loja/categorias/alterar-nome-categoria',
        data: {id: id, nome: nome},
        success: function(response) {
            nomeInput.prop('disabled', true);

            button.text('Editar');

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
}

const expandir = function (button) {
    let svg = button.find('svg');

    let menu = button.closest('.categoria').find('.body-categoria');

    if (menu.hasClass("expanded"))
    {
        menu.removeClass("expanded");
        svg.css('transform', 'rotate(0deg)');
    } else
    {
        menu.addClass("expanded");
        svg.css('transform', 'rotate(180deg)');
    }
}
