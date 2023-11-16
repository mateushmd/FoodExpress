const rangeInputEl = document.querySelector('.range');
const valorEl = document.querySelector('h4');


let valor = rangeInputEl.value;

rangeInputEl.addEventListener('input', e =>
{
    atualizar();
});

function atualizar()
{
    valor = rangeInputEl.value;

    valorEl.innerHTML = (valor / 100).toString().replace('.', ',') + '<span></span>';

    valor -= 100;

    valorEl.style = `transform: translateX(-50%) scale(${1 + (valor / 100)}); left: ${valor + 0.2}%;`;
}
