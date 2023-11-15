$(function() {
    $('#enviar').on('click', function() {
        $('#aviso').remove();

        let input = $('#nome-loja');

        let nome = input.val();

        if(nome.trim().length === 0) {
            $('main').append($('<p>', {'id' : 'aviso'}).text('Insira um nome válido'));
            input.focus();
            return;
        }

        $('#enviar input').addClass('hidden');

        $('#enviar').append($('<div>', {'class': 'loader'}));

        $.ajax({
            type: 'POST',
            url: 'configuracao-inicial',
            data: {nome: nome},
            success: function(response) {
                window.location.replace(response.redirect);
            },
            error: function(xhr, status, error) {
                console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        });
    });
});