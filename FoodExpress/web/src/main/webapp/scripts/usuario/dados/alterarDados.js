$(function() {
    const saveEl = $('#save');

    saveEl.on('click', () => salvarDados(saveEl));

    const alterarSenhaEl = $('#alterar-senha');

    alterarSenhaEl.on('click', () => window.location.assign('redefinir-senha.jsp'));
});

const salvarDados = function(element) {
    const parent = element.parent();

    const loader = $('<div>', {'class': 'loader'});

    const checkmark = $('<div>', {'class': 'checkmark hidden'});

    loader.append(checkmark);

    element.addClass('hidden');

    parent.append(loader);

    const nome = $('#name').val();
    const telefone = $('#phone').val();

    $.ajax({
        type: 'POST',
        url: 'alterar-dados',
        data: {nome: nome, telefone: telefone},
        success: function(response) {
            $('#default-nome').val(nome);
            $('#default-telefone').val(telefone);

            loader.addClass('complete');
            checkmark.removeClass('hidden');
            checkmark.addClass('draw');

            setTimeout(function() {
                loader.addClass('hide');

                setTimeout(function() {
                    loader.remove();
                }, 400);
            }, 1000);
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}