const sliderEl = document.querySelector('#slider');

const closeSliderButtonEl = document.querySelector('#close-slider');

const sliderTriggers = [...document.querySelectorAll('.slider-trigger')];

const containerElements = [...document.querySelectorAll('.slider-container')];

closeSliderButtonEl.addEventListener('click', (e) =>
{
    resetContainersState();

    if (!sliderEl.classList.contains('open'))
        return;

    sliderEl.classList.remove('open');
});

sliderTriggers.forEach((el) =>
{
    el.addEventListener('click', (e) =>
    {
        resetContainersState();

        containerElements[el.dataset.sliderIndex].classList.remove('hidden');

        if (sliderEl.classList.contains('open'))
            return;

        sliderEl.classList.add('open');
    });
});

function resetContainersState()
{
    containerElements.forEach(el => {
        el.classList.add('hidden')
    });
}