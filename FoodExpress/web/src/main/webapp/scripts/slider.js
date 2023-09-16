const sliderEl = document.querySelector('#slider');

const closeSliderButtonEl = document.querySelector('#close-slider');

const sliderTriggers = [...document.querySelectorAll('.trigger')];

closeSliderButtonEl.addEventListener('click', (e) =>
{
    if (!sliderEl.classList.contains('open'))
        return;

    sliderEl.classList.remove('open');
});

sliderTriggers.forEach((el) =>
{
    el.addEventListener('click', (e) =>
    {
        if (sliderEl.classList.contains('open'))
            return;

        sliderEl.classList.add('open');
    });
});