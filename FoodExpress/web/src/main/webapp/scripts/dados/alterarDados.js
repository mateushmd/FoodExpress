$(function() {
    $('#save').click(function() {
        const nome = $('#name').val();
        const telefone = $('#phone').val();

        $.ajax({
            type: 'POST',
            url: 'alterar-dados',
            data: {nome: nome, telefone: telefone},
            success: function(response) {
                $('#default-nome').val(nome);
                $('#default-telefone').val(telefone);
                $('#save').addClass('hidden');
            },
            error: function(xhr, status, error) {
                console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        });
    });
});