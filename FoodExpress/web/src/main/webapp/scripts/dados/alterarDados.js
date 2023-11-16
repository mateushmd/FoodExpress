$(function() {
    const saveEl = $('#save');

    saveEl.click(function() {
        const parent = saveEl.parent();

        const loader = $('<div>', {'class': 'loader'});

        const checkmark = $('<div>', {'class': 'checkmark hidden'});

        loader.append(checkmark);

        saveEl.addClass('hidden');

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
    });
});