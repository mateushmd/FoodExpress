let lupaEl = document.querySelector('#pesquisa-icon');
let barraPesquisaEl = document.querySelector('#barra-pesquisa');

/*script para aparecer a barra de pesquisa*/
lupaEl.addEventListener('click', e => {
    if (barraPesquisaEl.style.display === 'none') {
        barraPesquisaEl.style.display = 'block';
    } else {
        barraPesquisaEl.style.display = 'none';
    }
});

