const modalElements = [...document.querySelectorAll('.modal')];
const modalTriggerElements = [...document.querySelectorAll('.modal-trigger')];
const overlayEl = document.querySelector('#overlay');
const closeModalButtonEl = document.querySelector('#close-modal-produto');

const modalProdutoBotaoQuantidadeElements = [...document.querySelectorAll('.modal-produto-botao-quantidade')];

modalTriggerElements.forEach(el =>
{
    el.addEventListener('click', e =>
    {
        modalElements.forEach(mEl =>
        {

            if (mEl.dataset.modalIndex === el.dataset.modalIndex)
            {
                mEl.classList.toggle('hidden');
                if (mEl.dataset.lockScreen === 'true')
                {
                    overlayEl.classList.toggle('hidden');
                }

                //Janela modal do produto
                if (parseInt(mEl.dataset.modalIndex) === 1)
                {
                    const avaliacao = document.querySelector('#avaliacao').value;
                    const produtoNome = el.querySelector('.nome').innerHTML;
                    const produtoDescricao = el.querySelector('.descricao').innerHTML;
                    const produtoPreco = el.querySelector('.preco').innerHTML.replace('R$', '');

                    document.querySelector('#modal-produto-avaliacao').querySelector('p').innerHTML = avaliacao;
                    document.querySelector('#modal-produto-nome').innerHTML = produtoNome;
                    document.querySelector('#modal-produto-descricao').innerHTML = produtoDescricao;
                    document.querySelector('#modal-produto-preco').innerHTML = produtoPreco;
                    document.querySelectorAll('.modal-produto-preco-total').forEach(el => el.innerHTML = produtoPreco);
                    document.querySelectorAll('.modal-produto-quantidade').forEach(el => el.innerHTML = 1);
                }
            }
        });
    });
});

if (closeModalButtonEl !== null)
{
    closeModalButtonEl.addEventListener('click', e =>
    {
        const modalEl = closeModalButtonEl.parentElement;
        modalEl.classList.add('hidden');
        overlayEl.classList.toggle('hidden');
    });
}


modalProdutoBotaoQuantidadeElements.forEach(el =>
{
    el.addEventListener('click', e =>
    {
        const precoEl = document.querySelector('#modal-produto-preco');
        const quantidadeElements = [...document.querySelectorAll('.modal-produto-quantidade')];
        const precoTotalElements = [...document.querySelectorAll('.modal-produto-preco-total')];

        let operacao = parseInt(el.dataset.operacao);

        let quantidade = parseInt(quantidadeElements[0].innerHTML) + operacao;

        if (quantidade < 1)
            return;

        quantidadeElements.forEach(el => el.innerHTML = quantidade);

        let novoPreco = parseFloat(precoEl.innerHTML.replace(',', '.')) * quantidade;
        novoPreco = novoPreco.toFixed(2);
        novoPreco = novoPreco.replace('.', ',');

        precoTotalElements.forEach(el => el.innerHTML = novoPreco);
    });
});
