import go from "../whatsAppLinker.js";

$(function() {
    $('#fazer-pedido').on('click', () => fazerPedido());
});


function fazerPedido() {
    $('#aviso').remove();

    let idPonto = $('#pontos-pedido').find(':selected').val();

    if(idPonto === '-2') {
        $('<p>', {'id': 'aviso'}).text('A loja está fechada').insertAfter('#fazer-pedido');

        return;
    }

    let localEntrega = $('#pontos-pedido').find(':selected').text();

    const loader = $('<div>', {'class': 'loader white'});

    const checkmark = $('<div>', {'class': 'checkmark hidden'});

    loader.append(checkmark);

    loader.insertBefore('#fazer-pedido');

    $.ajax({
        type: 'POST',
        url: 'pedidos/fazer-pedido',
        data: {localEntrega: localEntrega},
        success: function(response) {
            setTimeout(function() {
                loader.addClass('hide');

                setTimeout(function() {
                    loader.remove();
                }, 400);
            }, 1000);

            $('#bag-header').find('h2').text('');

            $('.bag-produto').each(function(index) {
                $(this).remove();
            });

            $('#bag-preco').text('');

            $('#pontos-pedido').find('option').each(function (index) {
               $(this).remove();
            });

            $('#bag-container').addClass('hidden');

            $('#empty-bag').removeClass('hidden');

            $('#orders-preco').text('0,00');

            $('#orders-quantidade').text('0');

            go(response.numero, response.pedido.replace(/\n/g, '%0A'));
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}