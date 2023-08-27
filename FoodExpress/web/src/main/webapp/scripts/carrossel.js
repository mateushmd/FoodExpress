const arrows = [...document.querySelectorAll('.arrow')];

arrows.forEach((el) =>
{
    el.addEventListener('click', (e) =>
    {
        let axis = el.classList.contains('left-arrow') ? 1 : -1;

        let carrosselEl = axis === 1 ? el.nextElementSibling : el.previousElementSibling;

        let itemSize = getComputedStyle(document.documentElement).getPropertyValue('--item-width');

        let index = parseInt(carrosselEl.dataset.index);

        index = carrosselEl.dataset.index = index - axis > -1 ? (index - axis < carrosselEl.children.length - 2 ? index - axis : carrosselEl.children.length - 2) : 0;

        carrosselEl.style.transform = `translateX(calc(((${itemSize} + 20px) * ${index}) * -1))`;
    });
});

const items = [...document.querySelectorAll('.item')];

items.forEach((el) =>
{
    el.addEventListener('click', (e) =>
    {
        const inputIdEl = el.querySelector('input');

        //window.location.href = "";
    });
});