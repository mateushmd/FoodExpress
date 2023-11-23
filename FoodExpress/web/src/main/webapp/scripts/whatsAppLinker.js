$(function() {
   $('.whatsapp').each(function(index) {
      $(this).on('click', () => go($(this).data('numero')));
   });
});

function go(phone, text = null) {
    let link = `https://api.whatsapp.com/send?phone=${phone}`;

    if(text !== null)
        link += `&text=${text}`;

    console.log(link);

    window.open(link);
}

export default go;