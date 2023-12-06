let inputElements = [...document.querySelectorAll('.moeda')];

const moeda = (valor) =>
{
    valor = valor.replace(/\D+/g, '');
    valor = valor.replace(',', '');

    valor = (parseInt(valor) / 100).toFixed(2).replace('.', ',')

    return valor;
}

inputElements.forEach(element =>
{
    element.addEventListener('input', (e) =>
    {
        element.value = moeda(element.value);
    });
})