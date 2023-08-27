const inputs = [...document.querySelectorAll('.perfil-input')];
const editButtons = [...document.querySelectorAll('.editar')];
const revelarButtonEl = document.querySelector('#revelar');

const aplicarAlteracoesEl = document.querySelector('#aplicar-alteracoes');

editButtons.forEach((el, index) => {
    el.addEventListener('click', (e) => {
        e.preventDefault();

        const targetInput = inputs[index];

        let img = el.firstChild;
        
        if(!el.hasAttribute('id')) {
            targetInput.disabled = !targetInput.disabled;

            if(targetInput.disabled) {
                targetInput.value = el.dataset.default;
                img.src = 'imgs/editar.png';
            } else {
                img.src = 'imgs/cancelar.png';
            }

            const areAllDisabled = inputs.every((input) => input.disabled);

            if (areAllDisabled) {
                aplicarAlteracoesEl.disabled = true;
                aplicarAlteracoesEl.classList.remove('enabled');
            }
            else {
                aplicarAlteracoesEl.disabled = false;
                aplicarAlteracoesEl.classList.add('enabled');
            }
        } else {
            if (targetInput.type === 'password') {
                targetInput.type = 'text';
                img.src = 'imgs/esconder.png';
            } else {
                targetInput.type = 'password';
                img.src = 'imgs/mostrar.png';
            }
        }
    });
}); 