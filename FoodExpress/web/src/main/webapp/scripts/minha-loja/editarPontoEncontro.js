function excluirPontoc1(button)
{
    var row = button.parentNode.parentNode;
    row.parentNode.removeChild(row);
}

const salvarPontoElements = [...document.querySelectorAll('.salvar-ponto')];

salvarPontoElements.forEach(element =>
{
    element.addEventListener('click', e =>
    {
        let parent = element.parentElement;

        let ponto = parent.querySelector('.ponto-encontro').value;

        let pontosEncontro = parent.querySelector('.pontos-encontro');

        let msg = pontosEncontro.querySelector('.pontos-encontro-msg');

        if (msg !== null)
            msg.remove();

        let pontoEncontroContainer = document.createElement('div');
        pontoEncontroContainer.classList.add('ponto-encontro-container');

        let pontoEncontroTxt = document.createElement('p');
        pontoEncontroTxt.innerHTML = ponto;

        let buttonExcluir = document.createElement('button');
        buttonExcluir.classList.add('excluirPonto');

        let imgExcluir = document.createElement('img');
        imgExcluir.src = 'imgs/x-symbol.svg';

        buttonExcluir.append(imgExcluir);

        pontoEncontroContainer.append(pontoEncontroTxt);
        pontoEncontroContainer.append(buttonExcluir);

        pontosEncontro.append(pontoEncontroContainer);
    });
});