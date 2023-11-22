const horarioElements = [...document.querySelectorAll('.horario')];

horarioElements.forEach(element =>
{
    let parent = element.parentElement.parentElement;

    element.addEventListener('click', e =>
    {
        const aberturaInput = parent.querySelector('.abertura');
        const fechamentoInput = parent.querySelector('.fechamento');
        const c1Radio = parent.querySelector('.c1');
        const c2Radio = parent.querySelector('.c2');

        c1Radio.addEventListener('change', () =>
        {
            if (c1Radio.checked)
            {
                c2Radio.checked = false;
            }
        });

        c2Radio.addEventListener('change', () =>
        {
            if (c2Radio.checked)
            {
                c1Radio.checked = false;
            }
        });

        aberturaInput.disabled = !element.checked;
        fechamentoInput.disabled = !element.checked;
        c1Radio.disabled = !element.checked;
        c2Radio.disabled = !element.checked;
    })
});