let menuItensEl = [...document.querySelectorAll('.item')];

let itemAtual = menuItensEl[0];

menuItensEl.forEach((el, index) => {
    el.addEventListener('click', e => {
        itemAtual.removeAttribute('id');

        el.setAttribute('id', 'selected');

        itemAtual = el;
    });
});