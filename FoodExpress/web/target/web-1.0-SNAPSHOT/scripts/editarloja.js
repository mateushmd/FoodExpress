const inputFileLoja = document.querySelector('#picture-input-loja');
const pictureImageLoja = document.querySelector('#picture-image-loja');
const pictureImgLoja = 'Foto da Loja';


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


const inputFileProdutos = [...document.querySelectorAll('.picture-input-produto')];
const pictureImageProduto = document.querySelector('.picture-image-produto');
const pictureImgProduto = 'Produto';


pictureImageProduto.innerHTML = pictureImgProduto;
inputFileProdutos.forEach((el) =>
{
    el.addEventListener('click', () => { console.log('a') });

    el.addEventListener('change', function (e)
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

                pictureImageProduto.innerHTML = "";
                pictureImageProduto.appendChild(img);
            });

            reader.readAsDataURL(file);
        }
        else
        {
            pictureImageProduto.innerHTML = pictureImgProduto;
        }
    });
})

function moeda(a, e, r, t)
{
    let n = ""
        , h = j = 0
        , u = tamanho2 = 0
        , l = ajd2 = ""
        , o = window.Event ? t.which : t.keyCode;
    if (13 == o || 8 == o)
        return !0;
    if (n = String.fromCharCode(o),
        -1 == "0123456789".indexOf(n))
        return !1;
    for (u = a.value.length,
        h = 0; h < u && ("0" == a.value.charAt(h) || a.value.charAt(h) == r); h++)
        ;
    for (l = ""; h < u; h++)
        -1 != "0123456789".indexOf(a.value.charAt(h)) && (l += a.value.charAt(h));
    if (l += n,
        0 == (u = l.length) && (a.value = ""),
        1 == u && (a.value = "0" + r + "0" + l),
        2 == u && (a.value = "0" + r + l),
        u > 2)
    {
        for (ajd2 = "",
            j = 0,
            h = u - 3; h >= 0; h--)
            3 == j && (ajd2 += e,
                j = 0),
                ajd2 += l.charAt(h),
                j++;
        for (a.value = "",
            tamanho2 = ajd2.length,
            h = tamanho2 - 1; h >= 0; h--)
            a.value += ajd2.charAt(h);
        a.value += r + l.substr(u - 2, u)
    }
    return !1
}

const boatoEditarProdutoElements = [...document.querySelectorAll('.editar-produto')];

boatoEditarProdutoElements.forEach((el) =>
{
    el.addEventListener('click', (e) =>
    {
        e.preventDefault();

        el.classList.toggle('editing');

        const botaoSalvarProduto = el.nextElementSibling;

        const formEl = el.closest('form');

        const defaultProdutoEl = formEl.childNodes[5];
        const defaultPrecoEl = formEl.childNodes[7];

        const dadosProdutoEl = formEl.childNodes[1].childNodes[1];

        const inputProdutoEl = dadosProdutoEl.childNodes[3];
        const inputPrecoEl = dadosProdutoEl.childNodes[7];
        const selectDisponibilidadeEl = dadosProdutoEl.childNodes[11];

        const isEditing = el.classList.contains('editing');

        console.log(isEditing)

        if (!isEditing)
        {
            el.innerHTML = 'Editar';

            botaoSalvarProduto.disabled = true;

            inputProdutoEl.value = defaultProdutoEl.value;
            inputPrecoEl.value = defaultPrecoEl.value;

            inputProdutoEl.disabled = true;
            inputPrecoEl.disabled = true;
            selectDisponibilidadeEl.disabled = true;

            return;
        }

        el.innerHTML = 'Cancelar';

        botaoSalvarProduto.disabled = false;

        inputProdutoEl.disabled = false;
        inputPrecoEl.disabled = false;
        selectDisponibilidadeEl.disabled = false;
    });
});