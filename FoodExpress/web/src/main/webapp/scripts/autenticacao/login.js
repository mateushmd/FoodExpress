$(function() {
    $('#login').on('click', function() {
        login();
    });
});

const login = function() {
    $('#aviso').remove();

    const login = $('#login');

    login.addClass('hidden');

    $('.botao').prepend($('<div>', {'class': 'loader'}));

    const email = $('#email').val();
    const password = $('#password').val();

    console.log(`${email}, ${password}`);

    $.ajax({
        type: 'POST',
        url: 'login',
        data: {email: email, password: password},
        success: function(response) {
            if(response.responseType === 'error') {
                $('.form').append($('<p>', {'id': 'aviso'}).text('E-mail ou senha incorretos'));

                login.removeClass('hidden');

                $('.loader').remove();

                return;
            }

            window.location.replace(response.redirect);
        },
        error: function(xhr, status, error) {
            console.error(`AJAX request failed with status ${status}, error: ${error}`);
        }
    });
}
