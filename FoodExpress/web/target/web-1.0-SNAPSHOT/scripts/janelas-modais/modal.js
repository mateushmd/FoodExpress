const modalElements = [...document.querySelectorAll('.modal')];
const modalTriggerElements = [...document.querySelectorAll('.modal-trigger')];
const overlayEl = document.querySelector('#overlay');
const closeModalElements = [...document.querySelectorAll('.close-modal')];

const modalProdutoBotaoQuantidadeElements = [...document.querySelectorAll('.modal-produto-botao-quantidade')];

modalTriggerElements.forEach(el =>
{
    el.addEventListener('click', e => abrirModal(el));
});

function abrirModal(element) {
    modalElements.forEach(mEl =>
    {
        if (mEl.dataset.modalIndex === element.dataset.modalIndex)
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
                const produtoId = element.querySelector('.id-produto').value;
                const produtoNome = element.querySelector('.nome').innerHTML;
                const produtoDescricao = element.querySelector('.descricao').innerHTML;
                const produtoPreco = element.querySelector('.preco').innerHTML.replace('R$', '');

                document.querySelector('#modal-produto-id').value = produtoId;
                document.querySelector('#modal-produto-avaliacao').querySelector('p').innerHTML = avaliacao;
                document.querySelector('#modal-produto-nome').innerHTML = produtoNome;
                document.querySelector('#modal-produto-descricao').innerHTML = produtoDescricao;
                document.querySelector('#modal-produto-preco').innerHTML = produtoPreco;
                document.querySelectorAll('.modal-produto-preco-total').forEach(el => el.innerHTML = produtoPreco);
                document.querySelectorAll('.modal-produto-quantidade').forEach(el => el.innerHTML = 1);
            }
            //Janela modal edição de produto
            else if (parseInt(mEl.dataset.modalIndex) === 2)
            {
                const parent = element.parentElement;

                const id = parent.dataset.id;
                const nome = parent.querySelector('.nome').innerHTML;
                const descricao = parent.querySelector('.descricao').innerHTML;
                const preco = parent.querySelector('.preco').value.replace('.', ',');
                const visibilidade = parent.querySelector('.visibilidade').innerHTML === 'Ativado';
                const destaque = parent.querySelector('.destaque') !== null;

                document.querySelector('#modal-produto-id').value = id;
                document.querySelector('#modal-produto-nome').value = nome;
                document.querySelector('#modal-produto-descricao').value = descricao;
                document.querySelector('#modal-produto-preco').value = preco;

                const toggleVisibilidadeElements = [...document.querySelector('.toggle.visibilidade').querySelectorAll('button')];

                if(!visibilidade) {
                    toggleVisibilidadeElements[0].innerHTML = 'Pausado';
                    toggleVisibilidadeElements[0].classList.add('active');
                    toggleVisibilidadeElements[1].innerHTML = 'Avitar';
                    toggleVisibilidadeElements[1].classList.remove('active');
                } else {
                    toggleVisibilidadeElements[0].innerHTML = 'Pausar';
                    toggleVisibilidadeElements[0].classList.remove('active');
                    toggleVisibilidadeElements[1].innerHTML = 'Ativado';
                    toggleVisibilidadeElements[1].classList.add('active');
                }

                const toggleDestaqueElements = [...document.querySelector('.toggle.destaque').querySelectorAll('button')];

                if(destaque) {
                    toggleDestaqueElements[1].classList.add('active');
                    toggleDestaqueElements[0].classList.remove('active');
                } else {
                    toggleDestaqueElements[0].classList.add('active');
                    toggleDestaqueElements[1].classList.remove('active');
                }
            }
        }
    });
}

closeModalElements.forEach(element => {
    element.addEventListener('click', e =>
    {
        const modalEl = element.closest('.modal');
        modalEl.classList.add('hidden');
        overlayEl.classList.add('hidden');
    });
})

modalProdutoBotaoQuantidadeElements.forEach(el =>
{
    el.addEventListener('click', e =>
    {
        const precoEl = document.querySelector('#modal-produto-preco');
        const quantidadeElements = [...document.querySelectorAll('.modal-produto-quantidade')];
        const precoTotalElements = [...document.querySelectorAll('.modal-produto-preco-total')];

        let operacao = parseInt(el.dataset.operacao);

        let quantidade = parseInt(quantidadeElements[0].innerHTML) + operacao;

        if (quantidade < 1 || quantidade > 10)
            return;

        quantidadeElements.forEach(el => el.innerHTML = quantidade);

        let novoPreco = parseFloat(precoEl.innerHTML.replace(',', '.')) * quantidade;
        novoPreco = novoPreco.toFixed(2);
        novoPreco = novoPreco.replace('.', ',');

        precoTotalElements.forEach(el => el.innerHTML = novoPreco);
    });
});

export default abrirModal;
