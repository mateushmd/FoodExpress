import acessar from "./loja/acessar.js";

$(function() {
    $('.carregar-mais-lojas').on('click', () => carregar());
});

const carregar = function() {
    let call = $('.carregar-mais-lojas').data('call') + 1;

    const loader = $('<div>', {'class': 'loader white'});

    const checkmark = $('<div>', {'class': 'checkmark hidden'});

    loader.append(checkmark);

    loader.insertBefore($('.carregar-mais-lojas'));

    $.ajax({
        type: 'POST',
        url: 'carregar-mais-lojas',
        data: {callNumber: call},
        success: function(response) {
            let elements = $();

            for(let i = 0; i < response.length; i++) {
                let loja = response[i];

                let element = $('.loja.clone').clone();
                element.removeClass('clone');
                element.removeClass('hidden');

                element.data('id', loja.id);

                element.find('.loja-body h2').text(loja.nome);

                element.find('.avaliacao p').text(loja.avaliacao.toString().replace('.', ','));

                element.find('.disponibilidade').addClass(loja.aberto ? 'aberto' : 'fechado');

                element.find('svg').css({fill: loja.aberto ? 'green' : 'red'});

                element.find('.disponibilidade p').text(loja.aberto ? 'Aberto' : 'Fechado');

                element.on('click', () => acessar(element));

                elements = elements.add(element);
            }

            $('.lojas').append(elements);

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
    })
}