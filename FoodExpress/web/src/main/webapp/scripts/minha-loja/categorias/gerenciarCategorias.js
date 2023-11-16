$(function() {
    $('#add-categoria').on('click', function() {
        $.ajax({
            type: 'POST',
            url: 'adicionar-categoria',
            success: function(response) {
                let categoria = $('.categoria.clone').clone();

                categoria.removeClass('hidden');
                categoria.removeClass('clone');

                categoria.data('id', response.id);

                categoria.insertBefore('#add-categoria');
            },
            error: function(xhr, status, error) {
                console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        });
    });
});

const removerCategoria = function(element) {
    $.ajax({
        type: 'POST',
        url: 'remover-categoria',
        data: {id: id},
        success: function(response) {

        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
};
