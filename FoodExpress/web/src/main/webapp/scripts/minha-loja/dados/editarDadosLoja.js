const dadoElements = [...document.querySelectorAll('.info-loja')];
const defaultDadosElements = [...document.querySelectorAll('.default-campo-loja')];
const salvarEl = document.querySelector('#salvar-dados-loja');

dadoElements.forEach(element =>
{
    element.addEventListener('input', e =>
    {
        let igual = true;

        for (let i = 0; i < dadoElements.length; i++)
        {
            if (dadoElements[i].value !== defaultDadosElements[i].value)
            {
                igual = false;
                break;
            }
        }

        if (!igual)
        {
            salvarEl.classList.remove('hidden');
            return;
        }

        salvarEl.classList.add('hidden');
    })
})