$(function() {
    $('#cadastro').on('click', function() {
        cadastro();
    })
})

const cadastro = function () {
    $('#aviso').remove();

    const cadastro = $('#cadastro');

    cadastro.addClass('hidden');

    $('.botao').prepend($('<div>', {'class': 'loader'}));

    const nome = $('#name').val();
    const email = $('#email').val();
    const senha = $('#password').val();
    const confirmarSenha = $('#confirm-password').val();
    const telefone = $('#phone').val();
    const tipo = $('input[name="opcao"]:checked').val();

    if(confirmarSenha !== senha) {
        $('#confirm-password').focus();

        $('.form').append($('<p>', {'id': 'aviso'}).text('As senhas não se correspondem.'));

        $('.loader').remove();

        cadastro.removeClass('hidden');

        return;
    }

    $.ajax({
        type: 'POST',
        url: 'cadastrar',
        data: {nome: nome, email: email, senha: senha, telefone: telefone, tipo: tipo},
        success: function(response) {
            if(response.responseType === 'error') {
                $('.form').append($('<p>', {'id': 'aviso'}).text(response.message));

                $('.loader').remove();

                cadastro.removeClass('hidden');

                return;
            }

            window.location.replace(response.redirect);
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}