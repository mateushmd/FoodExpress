$(function() {

    $('.salvar-ponto').each(function(index) {
        let current = $(this);

        current.on('click', () => adicionar(current));
    });

    $('.excluir-ponto').each(function(index) {
        let current = $(this);

        current.on('click', () => remover(current));
    });

    $('.icon-expande-local-btn').each(function(index) {
        let current = $(this);

        current.on('click', () => expandir(current))
    });
})

const adicionar = function(button) {
    let container = button.closest('.container-local');

    let ponto = container.find('.ponto-encontro').val();

    if(ponto.trim().length < 1)
        return;

    $.ajax({
        type: 'POST',
        url: 'minha-loja/pontos/adicionar-ponto-encontro',
        data: {campus: container.data('campus'), nome: ponto},
        success: function(response) {
            container.find('.pontos-encontro-msg').remove();

            let pontoEncontroContainer = $('<div>', {'class': 'ponto-encontro-container'});
            pontoEncontroContainer.data('id', response.id);

            let pontoEncontroTxt = $('<p>').text(ponto);

            let buttonExcluir = $('<button>', {'class': 'excluir-ponto'});
            buttonExcluir.on('click', () => remover(buttonExcluir));

            let imgExcluir = $('<img alt="" src="imgs/x-symbol.svg">');

            buttonExcluir.append(imgExcluir);

            pontoEncontroContainer.append(pontoEncontroTxt);
            pontoEncontroContainer.append(buttonExcluir);

            container.find('.pontos-encontro').append(pontoEncontroContainer);

            container.find('.ponto-encontro').val('');
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    })
}

const remover = function(button) {
    let ponto = button.closest('.ponto-encontro-container');

    let campus = ponto.closest('.container-local').data('campus');

    $.ajax({
        type: 'POST',
        url: 'minha-loja/pontos/remover-ponto-encontro',
        data: {campus: campus, id: ponto.data('id')},
        success: function(response) {
            let container = ponto.closest('.pontos-encontro');

            ponto.remove();

            let restante = container.find('.ponto-encontro-container');

            if(restante.length < 1)
                container.append($('<p>', {'class': 'pontos-encontro-msg'}).text('Comece adicionando algum ponto de encontro'));
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    })
}

const expandir = function(button) {
    svg = button.find('svg');

    let menu = button.closest('.container-local').find('.submenu');

    if (menu.hasClass("expanded"))
    {
        menu.removeClass("expanded");
        svg.css('transform', 'rotate(0deg)');
    } else
    {
        menu.addClass("expanded");
        svg.css('transform', 'rotate(180deg)');
    }
};