const inputFileLoja = document.querySelector('#picture_input-loja');
const pictureImageLoja = document.querySelector('.picture_image-loja');
const pictureImgLoja = 'Foto da Loja';


pictureImageLoja.innerHTML = pictureImgLoja; 
inputFileLoja.addEventListener('change', function(e) {
    const inputTarget = e.target;
    const file = inputTarget.files[0];

    if (file) {
        const reader = new FileReader();
        reader.addEventListener('load', function(e) {
            const readerTarget = e.target;
            const img = document.createElement('img');
            img.src = readerTarget.result;
            img.classList.add('picture_img');

            pictureImageLoja.innerHTML = "";
            pictureImageLoja.appendChild(img);
        });

        reader.readAsDataURL(file);
    }
    else {
        pictureImageLoja.innerHTML = pictureImgLoja; 
    }
});

const inputFileProduto = document.querySelector('#picture_input-produtos');
const pictureImageProduto = document.querySelector('.picture_image-produtos');
const pictureImgProduto = 'Produto';


pictureImageProduto.innerHTML = pictureImgProduto; 
inputFileProduto.addEventListener('change', function(e) {
    const inputTarget = e.target;
    const file = inputTarget.files[0];

    if (file) {
        const reader = new FileReader();
        reader.addEventListener('load', function(e) {
            const readerTarget = e.target;
            const img = document.createElement('img');
            img.src = readerTarget.result;
            img.classList.add('picture_img');

            pictureImageProduto.innerHTML = "";
            pictureImageProduto.appendChild(img);
        });

        reader.readAsDataURL(file);
    }
    else {
        pictureImageProduto.innerHTML = pictureImgProduto; 
    }
});

function moeda(a, e, r, t) {
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
    u > 2) {
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

let quantidade = 0;

function incrementeQuantidade() {
  quantidade++;
  updateQuantity();
}

function decrementaQuantidade() {
  if (quantidade > 0) {
    quantidade--;
    updateQuantity();
  }
}

function updateQuantity() {
  document.getElementById("quantidade").innerText = quantidade;
}