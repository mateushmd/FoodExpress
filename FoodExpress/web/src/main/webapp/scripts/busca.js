$(function() {
    $('#search-bar img').on('click', () => buscar());

    $('#search-bar input').on('keypress', (e) => {
        if(e.keyCode === 13)
            $('#search-bar img').click();
    });
});

const buscar = function() {
    let busca = $('#search-bar input').val();

    window.location.assign(`busca?s=${busca}`);
}
