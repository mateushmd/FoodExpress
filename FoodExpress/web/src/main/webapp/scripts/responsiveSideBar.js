$(function ()
{
    if ($(window).width() < 1371)
    {
        $('#barra-lateral-navegador div').each(function (index)
        {
            let current = $(this);

            current.on('click', () => responsiveSideBar(current))
        })
    }

    $(window).on('resize', function ()
    {
        if ($(window).width() < 1371)
        {
            $('#barra-lateral-navegador div').each(function (index)
            {
                let current = $(this);

                current.on('click', () => responsiveSideBar(current))
            })
        }
    })
})

let previous;

const responsiveSideBar = function (current)
{
    if (previous === current && $('#barra-lateral-container').hasClass('open'))
    {
        $('#barra-lateral-container').removeClass('open');
        return;
    }

    previous = current

    $('#barra-lateral-container').addClass('open');
}