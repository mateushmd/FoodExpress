const userRatingEl = document.querySelector('#user-rating');
const starLabels = [...userRatingEl.querySelectorAll('.star-label')];
const ratingInputEl = document.querySelector('#rating');

starLabels.forEach(element =>
{
    element.addEventListener('click', e =>
    {
        const track = element.dataset.star;

        starLabels.forEach(el =>
        {
            const img = el.querySelector('img');
            img.src = 'imgs/gray-star.svg';

            if (el.dataset.star <= track)
            {
                img.src = 'imgs/star.svg';
            }
        });

        ratingInputEl.value = track;

        console.log(ratingInputEl.value);
    });
});