const starInputs = [...document.querySelectorAll('.star-input')];

const starLabels = [...document.querySelectorAll('.star-label')];

starLabels.forEach((el) =>
{
    el.addEventListener('click', (e) =>
    {
        starLabels.forEach((el) =>
        {
            el.classList.remove('checked');
        });

        const starAmmount = el.dataset.star;

        for (let i = 0; i < starAmmount; i++)
        {
            starLabels[i].classList.add('checked');
        }
    });
});