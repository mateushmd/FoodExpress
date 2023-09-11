const ratingElements = [...document.querySelectorAll('.process-rating')];

ratingElements.forEach(el =>
{
    const starLabels = [...el.querySelectorAll('.star-label')];
    const rating = el.dataset.rating;

    starLabels.forEach(label =>
    {
        if (label.dataset.star <= rating)
        {
            const imgEl = label.querySelector('img');
            imgEl.src = 'imgs/star.svg';
        }
    })
});
