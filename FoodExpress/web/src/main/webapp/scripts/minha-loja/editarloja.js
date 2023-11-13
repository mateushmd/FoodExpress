const botaoEditar = [...document.querySelectorAll('.editar')];
const inputTexto = [...document.querySelectorAll('.loja-input')];


botaoEditar.forEach((el, index) =>
{
    el.addEventListener('click', (e) =>
    {
        e.preventDefault();

        const targetInput = inputTexto[index];

        let img = el.firstChild;

        if (!el.hasAttribute('id'))
        {
            targetInput.disabled = !targetInput.disabled;

            if (targetInput.disabled)
            {
                targetInput.value = el.dataset.default;
                img.src = 'imgs/minha-loja/editar.png';
            } else
            {
                img.src = 'imgs/x-symbol.svg';
            }
        }
    });
});

const titles = document.querySelectorAll('.container-local h2');

titles.forEach(title =>
{
    title.addEventListener('click', () =>
    {
        const submenu = title.nextElementSibling;
        submenu.style.maxHeight = submenu.style.maxHeight ? null : '100%';


        titles.forEach(otherTitle =>
        {
            if (otherTitle !== title)
            {
                otherTitle.classList.remove('active');
                otherTitle.nextElementSibling.style.maxHeight = null;
            }
        });

        title.classList.toggle('active');
    });
});

document.addEventListener("DOMContentLoaded", function ()
{
    const menuButtons = document.querySelectorAll(".btn-exclui-cat");
    const menus = document.querySelectorAll(".menu-exclui-cat");

    menuButtons.forEach(function (menuButton, index)
    {
        menuButton.addEventListener("click", function (event)
        {
            const menu = menus[index];
            const rect = menuButton.getBoundingClientRect();
            menu.classList.toggle("show-menu");
        });
    });
});

document.addEventListener("DOMContentLoaded", function ()
{
    const menuButtons = document.querySelectorAll(".btn-item");
    const menus = document.querySelectorAll(".menu-item");

    menuButtons.forEach(function (menuButton, index)
    {
        menuButton.addEventListener("click", function (event)
        {
            const menu = menus[index];
            const rect = menuButton.getBoundingClientRect();
            menu.classList.toggle("show-menu");
        });
    });
});



const buttons = document.querySelectorAll(".icon-expande-btn");
const menus = document.querySelectorAll(".body-categoria");

console.log(buttons)

buttons.forEach((button, index) =>
{
    button.addEventListener("click", () =>
    {
        console.log(buttons[index])
        let svg = button.querySelector('svg');

        console.log(svg);

        if (menus[index].classList.contains("expanded"))
        {
            menus[index].classList.remove("expanded");
            svg.style.transform = 'rotate(0deg)';
        } else
        {
            menus[index].classList.add("expanded");
            svg.style.transform = 'rotate(180deg)';
        }
    });
});


function previewImageItem(input)
{
    const inputContainer = input.parentElement;
    const imageContainer = inputContainer.querySelector('.picture-image-item');

    if (input.files && input.files[0])
    {
        const reader = new FileReader();

        reader.onload = function (e)
        {
            imageContainer.style.backgroundImage = `url(${e.target.result})`;
            imageContainer.innerText = ''; // Remova o texto quando uma imagem for carregada
        };

        reader.readAsDataURL(input.files[0]);
    } else
    {
        imageContainer.style.backgroundImage = 'none';
        imageContainer.innerText = 'Logo'; // Restabeleça o texto "Logo"
    }
}





function excluirCategoria(botao)
{
    var divParaExcluir = botao.closest('.container-produto');
    if (divParaExcluir)
    {
        divParaExcluir.remove();
    }
}


function toggleClearButton()
{
    var input = document.getElementById("pesquisa-categoria");
    var inputContainer = input.parentElement;

    if (input.value.length > 0)
    {
        inputContainer.classList.add("has-content");
    } else
    {
        inputContainer.classList.remove("has-content");
    }
}

function clearInput()
{
    var input = document.getElementById("pesquisa-categoria");
    input.value = "";
    input.focus();
    var inputContainer = input.parentElement;
    inputContainer.classList.remove("has-content");
}



var modal = document.getElementById('myModal');
var trigger = document.querySelector('#imgPromove');
var closeBtn = document.querySelector('.close');


trigger.addEventListener('click', function ()
{
    modal.style.display = 'block';
});


closeBtn.addEventListener('click', function ()
{
    modal.style.display = 'none';
});


window.addEventListener('click', function (event)
{
    if (event.target == modal)
    {
        modal.style.display = 'none';
    }
});
