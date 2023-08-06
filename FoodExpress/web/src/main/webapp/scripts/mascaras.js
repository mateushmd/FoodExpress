const tel = document.querySelector("#phone"); ;

tel.addEventListener('keypress', (e) => mascaraTelefone(e.target.value)) 
tel.addEventListener('change', (e) => mascaraTelefone(e.target.value))

const mascaraTelefone = (valor) => {
    valor = valor.replace(/\D/g, "")
    valor = valor.replace(/(\d{2})(\d)/, "($1) $2")
    valor = valor.replace(/(\d{2})(\d)/, "$1 $2")
    valor = valor.replace(/(\d{5})(\d)/, "$1-$2")
    valor = valor.replace(/(-\d{4})(\d+?)$/, "$1")
    tel.value = valor 
}
