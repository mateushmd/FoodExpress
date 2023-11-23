$(function() {
    $('#reenviar').on('click', function () {
            reenviar();
        });

    $('#verificar').on('click', function() {
        verificar();
    });
});

const reenviar = function() {
    const reenviar = $('#reenviar');

    if(reenviar.hasClass('.loading'))
        return;

    $('#aviso').remove();

    reenviar.addClass('.loading');

    const loader = $('<div>', {'class': 'loader'});
    
    const checkmark = $('<div>', {'class': 'checkmark hidden'});

    loader.append(checkmark);

    reenviar.append(loader);

    $.ajax({
        type: 'POST',
        url: 'reenviar-codigo',
        success: function(response) {
            loader.addClass('complete');
            checkmark.removeClass('hidden');
            checkmark.addClass('draw');

            setTimeout(function() {
                loader.addClass('hide');

                setTimeout(function () {
                    loader.remove();
                }, 300);
            }, 400);

            let tempoRestante = 5;

            let child = reenviar.find('input');

            let intervalo = setInterval(function() {
                tempoRestante--;

                if(tempoRestante <= 0) {
                    clearInterval(intervalo);
                    child.val('REENVIAR CÓDIGO');
                    reenviar.removeClass('.loading');
                } else {
                    child.val(`REENVIAR CÓDIGO     ${tempoRestante}`);
                }
            }, 1000);
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
};

const verificar = function() {
    const verificar = $('#verificar');

    if(verificar.hasClass('.loading'))
        return;

    $('#aviso').remove();

    verificar.addClass('.loading');

    const loader = $('<div>', {'class': 'loader'});

    const checkmark = $('<div>', {'class': 'checkmark hidden'});

    loader.append(checkmark);

    verificar.append(loader);

    const codigo = $('.code-input').map(function() {
        return $(this).val();
    }).get().join('');

    $.ajax({
        type: 'POST',
        url: 'verificar-email',
        data: {codigo: codigo},
        success: function(response) {
            if(response.responseType === "error") {
                $('.form').append($('<p>', {'id': 'aviso'}).text(response.message));

                $('.loader').remove();

                verificar.removeClass('.loading');

                return;
            }

            loader.addClass('complete');
            checkmark.removeClass('hidden');
            checkmark.addClass('draw');

            setTimeout(function() {
                loader.addClass('hide');

                setTimeout(function () {
                    loader.remove();
                    window.location.replace(response.redirect);
                }, 300);
            }, 400);
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
};