$(function ()
{
    if ($(window).width() < 1001)
    {
        $('#navbar').addClass('hidden');

        $('#navbar-responsive').removeClass('hidden');

        $('footer').addClass('hidden');
    }

    $(window).on('resize', function ()
    {

        console.log($(window).width())

        if ($(window).width() < 1001)
        {
            $('#navbar').addClass('hidden');

            $('#navbar-responsive').removeClass('hidden');

            $('footer').addClass('hidden');
        }
        else
        {
            $('#navbar').removeClass('hidden');

            $('#navbar-responsive').addClass('hidden');

            $('footer').removeClass('hidden');
        }
    })
})