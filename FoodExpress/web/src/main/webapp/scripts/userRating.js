const userRatingEl = document.querySelector('#user-rating');
const userRatingFormEl = document.querySelector('#user-rating-form');
const starLabels = [...userRatingEl.querySelectorAll('.star-label')];
const ratingInputEl = document.querySelector('#rating');
const commentInputEl = document.querySelector('#comment');

const editButtonEl = document.querySelector('#edit');
const saveButtonEl = document.querySelector('#save');
const deleteButtonEl = document.querySelector('#delete');
const defaultMessageEl = document.querySelector('#default-message');
const defaultRatingEl = document.querySelector('#default-rating');

starLabels.forEach(element =>
{
    element.addEventListener('click', e =>
    {
        if (userRatingEl.classList.contains('disabled'))
            return

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

if (editButtonEl !== null)
{
    editButtonEl.addEventListener('click', e =>
    {
        e.preventDefault();

        if (editButtonEl.value === 'EDITAR')
        {
            editButtonEl.value = 'CANCELAR';

            saveButtonEl.classList.remove('hidden');

            commentInputEl.disabled = false;

            userRatingEl.classList.remove('disabled');

            return;
        }

        editButtonEl.value = 'EDITAR';

        saveButtonEl.classList.add('hidden');

        commentInputEl.disabled = true;

        commentInputEl.value = defaultMessageEl.value;

        userRatingEl.classList.add('disabled');

        ratingInputEl.value = defaultRatingEl.value;

        starLabels.forEach(el =>
        {
            const img = el.querySelector('img');
            img.src = 'imgs/gray-star.svg';

            if (el.dataset.star <= userRatingEl.dataset.rating)
            {
                img.src = 'imgs/star.svg';
            }
        });
    });
}

if (deleteButtonEl !== null)
{
    deleteButtonEl.addEventListener('click', e =>
    {
        const actionInput = document.createElement('input');
        actionInput.type = 'hidden';
        actionInput.name = 'submit';
        actionInput.value = 'DELETAR';

        userRatingFormEl.appendChild(actionInput);
        HTMLFormElement.prototype.submit.call(userRatingFormEl);
        userRatingFormEl.removeChild(actionInput);
    });
}