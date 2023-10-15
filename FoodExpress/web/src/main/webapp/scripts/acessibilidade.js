const escalaInicial = 1;

const corFundoPadrao = '#fff';
const corFundoEscuro = '#121212';

const corFonte1Padrao = '#000';
const corFonte1Escuro = '#fff';

const corFonte2Padrao = '#e6f1f5';

const corBordaPadrao = '#ccc';
const corBordaEscuro = '#585858';
const corBordaContraste = '#000';
const corBordaContrasteEscuro = '#fff';

const corPlaceholderPadrao = '#c0c0c0';
const corPlaceholderContraste = '#000';
const corPlaceholderContrasteEscuro = '#fff';

const corSetaPadrao = '#27272766';
const corSetaPadraoHover = '#272727';

const corSetaEscuro = '#ffffff4d';
const corSetaEscuroHover = '#ffffff';

const fontWeightPadrao = 100;
const fontWeightContraste = 707;


const rootEl = document.querySelector(':root');
const rootStyle = rootEl.style;
const rangeEscalaEl = document.querySelector('#range-escala');

const acessibilidadeInputElements = [...document.querySelectorAll('.acessibilidade')];

const setaElements = [...document.querySelectorAll('.arrow>img')];

aplicarConfiguracoes();

function aplicarConfiguracoes()
{
    reiniciarConfiguracoes();

    rootStyle.setProperty('--escala', configuracoesAcessibilidade[3]);
    rootStyle.setProperty('--escala-menor', acharValorEquivalente(configuracoesAcessibilidade[3]));

    if (configuracoesAcessibilidade[0])
    {
        rootStyle.setProperty('--cor-fundo', corFundoEscuro);
        rootStyle.setProperty('--cor-fonte-1', corFonte1Escuro);
        rootStyle.setProperty('--cor-borda', corBordaEscuro);
        rootStyle.setProperty('--cor-seta', corSetaEscuro);
        rootStyle.setProperty('--cor-seta-hover', corSetaEscuroHover);

        setaElements.forEach(el =>
        {
            el.src = 'imgs/menu-principal/seta-escuro.svg';
        });
    }

    if (configuracoesAcessibilidade[1])
    {
        rootStyle.setProperty('--cor-borda', corBordaContraste);
        rootStyle.setProperty('--cor-placeholder', corPlaceholderContraste);
    }

    if (configuracoesAcessibilidade[0] && configuracoesAcessibilidade[1])
    {
        rootStyle.setProperty('--cor-borda', corBordaContrasteEscuro);
        rootStyle.setProperty('--cor-placeholder', corPlaceholderContrasteEscuro);
    }

    if (configuracoesAcessibilidade[2])
    {
        rootStyle.setProperty('--font-weight', fontWeightContraste);
    }
}

function acharValorEquivalente(valor)
{
    const porcentagem = ((valor - 1) / (2 - 1)) * 100;
    const valorEquivalente = 1 + (porcentagem / 100) * (1.3 - 1);
    return valorEquivalente;
}

function reiniciarConfiguracoes() 
{
    rootStyle.setProperty('--escala', escalaInicial);
    rootStyle.setProperty('--escala-menor', escalaInicial);

    rootStyle.setProperty('--cor-fundo', corFundoPadrao);

    rootStyle.setProperty('--cor-fonte-1', corFonte1Padrao);
    rootStyle.setProperty('--cor-fonte-2', corFonte2Padrao);

    rootStyle.setProperty('--cor-borda', corBordaPadrao);

    rootStyle.setProperty('--cor-placeholder', corPlaceholderPadrao);

    rootStyle.setProperty('--cor-seta', corSetaPadrao);
    rootStyle.setProperty('--cor-seta-hover', corSetaPadraoHover);

    rootStyle.setProperty('--font-weight', fontWeightPadrao);

    setaElements.forEach(el =>
    {
        el.src = 'imgs/menu-principal/seta.svg';
    });
}

if (acessibilidadeInputElements.length > 0)
{
    for (let i = 0; i < acessibilidadeInputElements.length; i++) 
    {
        const el = acessibilidadeInputElements[i];

        el.addEventListener('change', e =>
        {
            let value;

            if (i === 3)
                value = el.value / 100;
            else
                value = el.checked;

            console.log(value)

            configuracoesAcessibilidade[i] = value;

            aplicarConfiguracoes();
        });
    }
}
