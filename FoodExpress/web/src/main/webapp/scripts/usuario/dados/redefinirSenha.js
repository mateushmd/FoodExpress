$(function() {
    $('#redefinir').on('click', () => redefinirSenha());
});

const redefinirSenha = function() {
    $('#aviso').remove();

    let senha = $('#password').val();
    let confirmarSenha = $('#confirm-password').val();

    if(senha !== confirmarSenha) {
        let aviso = $('<p>', {'id': 'aviso'}).text('As senhas não se correspondem.');

        aviso.insertBefore('button');

        $('#confirm-password').focus();

        return;
    }

    $.ajax({
        type: 'POST',
        url: 'redefinir-senha',
        data: {senha: senha},
        success: function(response) {
            if(response.responseType === 'error')
                return;

            window.location.replace(response.redirect);
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}