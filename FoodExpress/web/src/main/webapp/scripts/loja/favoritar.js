$(function() {
    $('.favorite').click(function() {
        let idLoja = $('.favorite input').val();

        let button = $('.favorite button');

        let url = undefined;

        url = 'favoritos/adicionar-favorito';

        if(button.hasClass('active'))
            url = 'favoritos/remover-favorito';

        $.ajax({
            type: 'POST',
            url: url,
            data: {idLoja: idLoja},
            success: function(response) {
                $('.favorite button').toggleClass('active');
            },
            error: function(xhr, status, error) {
              console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        });
    });
});