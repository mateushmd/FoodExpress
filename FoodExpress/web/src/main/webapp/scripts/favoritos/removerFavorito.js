$(function() {
    $('.remover').click(function(e) {
        const target = $(e.currentTarget);

        console.log(target);
        console.log(target.parent());

        $.ajax({
            type: 'POST',
            url: 'favoritos/remover-favorito',
            data: {idLoja: target.data('lojaId')},
            success: function(response) {
                target.parent().remove();
            },
            error: function(xhr, status, error) {
                console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        });
    });
});