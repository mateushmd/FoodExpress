const arrows = [...document.querySelectorAll('.arrow')];

const bodyEl = document.querySelector('body');

resizeArrow();

window.addEventListener('resize', (e) =>
{
    resizeArrow();
});

arrows.forEach((el) =>
{
    el.addEventListener('click', (e) =>
    {
        const itemsInScreen = parseInt(el.closest('.carousel-container').dataset.items);

        let axis = el.classList.contains('left-arrow') ? 1 : -1;

        let carrosselEl = axis === 1 ? el.nextElementSibling : el.previousElementSibling;

        let itemSize = getComputedStyle(document.documentElement).getPropertyValue('--item-width');

        let index = parseInt(carrosselEl.dataset.index);

        index = carrosselEl.dataset.index = index - axis > -1 ? (index - axis < carrosselEl.children.length - itemsInScreen ? index - axis : carrosselEl.children.length - itemsInScreen) : 0;

        carrosselEl.style.transform = `translateX(calc(((${itemSize} + 40px) * ${index}) * -1))`;
    });
});

function resizeArrow() 
{
    if (bodyEl.scrollHeight <= bodyEl.clientHeight)
        return;

    arrows.forEach((el) =>
    {
        if (!el.classList.contains('right-arrow') || !el.classList.contains('arrow-squared'))
            return;

        const itemWidth = getComputedStyle(document.documentElement).getPropertyValue('--item-width');

        const rightArrowEl = arrows[1];

        rightArrowEl.style.width = `calc(${itemWidth} / 2.2 - .6vw)`;
    });
}