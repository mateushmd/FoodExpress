$(function () {
    adicionarNomes();

    $('#horario').on('click', () => salvar());
});

const diasDaSemana = ['Segunda-feira', 'Terça-feira', 'Quarta-feira', 'Quinta-feira', 'Sexta-feira', 'Sábado', 'Domingo'];

const adicionarNomes = function() {

    let dias = $('.dia');

    dias.each(function(index) {
        let dia = $(this);

        let diaStr = diasDaSemana[dia.data('dia') - 1];

        dia.find('.dia-da-semana').append($('<p>').text(diaStr));
    });
}

const salvar = function() {
    $('#aviso').remove();

    let dias = $('.dia');

    let lista = [];

    let unchecked = [];

    dias.each(function(index) {
        let dia = $(this);

        if(!dia.find('.liga-desliga__checkbox').is(':checked')) {
            unchecked.push(dia);
            return;
        }

        let abertura = dia.find('.abertura').val();

        let fechamento = dia.find('.fechamento').val();

        if(abertura.length === 0 || fechamento.length === 0) {
            $('<p>', {'id': 'aviso'}).text('Todos os campos devem ser preenchidos corretamente').insertAfter('#container-horario div');
            return;
        }

        if(abertura.length < 6)
            abertura += ':00';

        if(fechamento.length < 6)
            fechamento += ':00';

        let c1 = dia.find(`.c1[name="campus-${index + 1}"]`).is(':checked');
        let c2 = dia.find(`.c2[name="campus-${index + 1}"]`).is(':checked');

        if(c1 === false && c2 === false) {
            $('<p>', {'id': 'aviso'}).text('Todos os campos devem ser preenchidos corretamente').insertAfter('#container-horario div');
            return;
        }


        lista.push({
            diaSemana: index + 1,
            abertura: abertura,
            fechamento: fechamento,
            campus1: dia.find(`.c1[name="campus-${index + 1}"]`).is(':checked'),
            campus2: dia.find(`.c2[name="campus-${index + 1}"]`).is(':checked')
        });
    });

    console.log(lista);

    console.log(JSON.stringify({lista}));

    if(lista.length === 0)
        return;

    const loader = $('<div>', {'class': 'loader white'});

    const checkmark = $('<div>', {'class': 'checkmark hidden'});

    loader.append(checkmark);

    $('#container-horario div').append(loader);

    $.ajax({
        type: 'POST',
        url: 'minha-loja/atualizar-agenda',
        contentType: 'application/json',
        data: JSON.stringify({lista: lista}),
        success: function(response) {
            loader.addClass('complete');
            checkmark.removeClass('hidden');
            checkmark.addClass('draw');

            setTimeout(function() {
                loader.addClass('hide');

                setTimeout(function() {
                    loader.remove();
                }, 400);
            }, 1000);

            unchecked.forEach(element => {
                element.find('.abertura').val('');
                element.find('.fechamento').val('');
                element.find('.campus c1').prop('checked', false);
                element.find('.campus c2').prop('checked', false);
            });
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}

