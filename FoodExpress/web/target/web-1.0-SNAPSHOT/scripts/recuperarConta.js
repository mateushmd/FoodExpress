$(function() {
    $('button').on('click', () => {
        let email = $('#email').val();

        if(email.trim().length < 1)
            return;

        $.ajax({
            type: 'POST',
            url: 'recuperar-conta',
            data: {email: email},
            success: function(response) {
                window.location.replace('confirmar-email.jsp');
            },
            error: function(xhr, status, error) {
                console.error(`AJAX request failed with status ${status}, error: ${error}`);
            }
        })
    })
})
