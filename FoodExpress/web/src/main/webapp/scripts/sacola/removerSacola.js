$(function() {
    $('.bag-remover-produto').each(function(index, element) {
        let current = $(element);

        current.on("click", function() {
            remover(current);
        });
    });
});

function remover(currentElement) {
    let produtoEl = currentElement.parent().parent();

    $.ajax({
        type: 'POST',
        url: 'sacola/remover-sacola',
        data: {idItem: produtoEl.data('id-item')},
        success: function(response) {
            console.log(response.responseType);

            produtoEl.remove();

            if(response.responseType === 'remover') {
                $('#bag-preco').text(response.total.toFixed(2).replace('.', ','));

                $('#orders-preco').text(response.total.toFixed(2).replace('.', ','));
                $('#orders-quantidade').text(response.quantidade);
            }
            else if(response.responseType === 'esvaziar') {
                $('#bag-preco').text('0,00');
                $('#bag-nome').text('');
                $('#bag-anchor').attr('href', '');
                $('#bag-container').addClass('hidden');
                $('#empty-bag').removeClass('hidden');

                $('#orders-preco').text('0,00');
                $('#orders-quantidade').text('0');
            }
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}

export default remover;