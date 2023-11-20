const campoElements = [...document.querySelectorAll('.editavel')];
const defaultCampoElements = [...document.querySelectorAll('.default')];

const botaoSalvarEl = document.querySelector('#save');

console.log(campoElements)

for (let i = 0; i < campoElements.length; i++)
{
    let el = campoElements[i];

    let defaultEl = defaultCampoElements[i];

    el.value = defaultEl.value;

    el.addEventListener('input', e =>
    {
        let igual = true;

        for (let i = 0; i < campoElements.length; i++)
        {
            if (campoElements[i].value !== defaultCampoElements[i].value)
            {
                igual = false;
                break;
            }
        }

        if (!igual)
        {
            botaoSalvarEl.classList.remove('hidden');
            return;
        }

        botaoSalvarEl.classList.add('hidden');
    });
}