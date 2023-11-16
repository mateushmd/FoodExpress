function toggleState(buttons, index)
{
    if (buttons[index].classList.contains('active'))
        return;

    buttons[index].classList.add('active')

    buttons[!index ? 1 : 0].classList.remove('active')

    if (!index)
    {
        buttons[index].innerHTML = 'Pausado';
        buttons[!index ? 1 : 0].innerHTML = 'Ativar';
    }
    else
    {
        buttons[index].innerHTML = 'Ativado';
        buttons[!index ? 1 : 0].innerHTML = 'Pausar';
    }
}

let toggleElements = [...document.querySelectorAll('.toggle')];

toggleElements.forEach(element =>
{
    let buttons = [...element.querySelectorAll('.toggle-button')];

    buttons.forEach((child, index) =>
    {
        child.addEventListener('click', () =>
        {
            toggleState(buttons, index);
        })
    })
})