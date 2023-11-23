$(function() {
    $('#salvar-dados-loja').on('click', function() {
        let nome = $('#nome-loja').val();
        let descricao = $('#descricao-loja').val();

        const parent = $('#salvar-dados-loja').parent();

        if(nome.trim().length === 0) {
            parent.append($('<p>', {'id': 'aviso'}).text('Insira um nome para a loja'));

            setTimeout(function() {
                $('#aviso').remove();
            }, 4000);

            return;
        }

        $('#salvar-dados-loja').addClass('hidden');

        const loader = $('<div>', {'class': 'loader'});

        const checkmark = $('<div>', {'class': 'checkmark hidden'});

        loader.append(checkmark);

        parent.append(loader);

        $.ajax({
            type: 'POST',
            url: 'alterar-dados-loja',
            data: {nome: nome, descricao: descricao},
            success: function(response) {
                $('#default-nome-loja').val(nome);
                $('#default-descricao-loja').val(descricao);

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
    });
});