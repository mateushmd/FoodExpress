const inputFileLoja = document.querySelector('#picture-input-loja');
const pictureImageLoja = document.querySelector('#picture-image-loja');
pictureImageLoja.innerHTML = pictureImgLoja;

inputFileLoja.addEventListener('change', function (e)
{
    const inputTarget = e.target;
    const file = inputTarget.files[0];

    if (file)
    {
        const reader = new FileReader();
        reader.addEventListener('load', function (e)
        {
            const readerTarget = e.target;
            const img = document.createElement('img');
            img.src = readerTarget.result;
            img.classList.add('picture-img');

            pictureImageLoja.innerHTML = "";
            pictureImageLoja.appendChild(img);
        });

        reader.readAsDataURL(file);
    }
    else
    {
        pictureImageLoja.innerHTML = pictureImgLoja;
    }
});

function previewImage()
{
    const input = document.getElementById('picture-input-loja-perfil');
    const imageContainer = document.getElementById('picture-image-loja-perfil');

    if (input.files && input.files[0])
    {
        const reader = new FileReader();

        reader.onload = function (e)
        {
            imageContainer.style.backgroundImage = `url(${e.target.result})`;
            imageContainer.innerText = '';
        };

        reader.readAsDataURL(input.files[0]);
    } else
    {
        imageContainer.style.backgroundImage = 'none';
        imageContainer.innerText = 'Logo';
    }
}

function previewPromocao()
{
    const input = document.getElementById('picture-input-promove');
    const imageContainer = document.getElementById('picture-image-promove');

    if (input.files && input.files[0])
    {
        const reader = new FileReader();

        reader.onload = function (e)
        {
            imageContainer.style.backgroundImage = `url(${e.target.result})`;
            imageContainer.innerText = '';
        };

        reader.readAsDataURL(input.files[0]);
    } else
    {
        imageContainer.style.backgroundImage = 'none';
        imageContainer.innerText = 'Carregar Imagem';
    }
}
