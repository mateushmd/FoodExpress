$(function() {
    $('.loja').each(function(index) {
        let current = $(this);

        current.on('click', () => acessar(current));
    });

});

function acessar(loja) {
    let id = loja.data('id');

    window.location.assign(`loja?id=${id}`);
}

export default acessar;