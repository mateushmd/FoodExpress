$(function() {
    const adicionarButtonEL = $('#modal-produto-adicionar');

    adicionarButtonEL.click(function() {
        let produtoId = $('#modal-produto-id').val();
        let produtoQuantidade = $().val();

        $.ajax({
            type: 'POST',
            url: '',
            data: {produtoId: produtoId},
            success: function(params) {

            },
            error: function(xhr, status, error) {
                console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        });
    });
});