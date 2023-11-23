let buttonElements = [...document.querySelectorAll('#barra-lateral-navegador>div')];
let sectionElements = [...document.querySelectorAll('.barra-lateral-section')];

let selected = 0;

buttonElements.forEach((element, index) =>
{
    element.addEventListener('click', e =>
    {
        console.log(index);

        buttonElements[selected].classList.remove('selected');
        sectionElements[selected].classList.add('hidden');

        buttonElements[index].classList.add('selected');
        sectionElements[index].classList.remove('hidden');

        selected = index;
    });
});