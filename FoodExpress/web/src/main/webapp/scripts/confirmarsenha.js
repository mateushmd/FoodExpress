let senhaEl = document.querySelector('#password');
let confirmarSenhaEl = document.querySelector('#confirm-password');
let msgEl = document.querySelector('#msg-password');
let buttonEl = document.querySelector('#cadastro');

senhaEl.addEventListener('input', (e) => {
    checkPasswords();
});

confirmarSenhaEl.addEventListener('input', (e) => {
    checkPasswords();
});

function checkPasswords() {
    if(senhaEl.value === '' && confirmarSenhaEl.value === '') {
        msgEl.hidden = true;
        return
    }

    buttonEl.disabled = true;

    msgEl.hidden = false;

    if(senhaEl.value !== confirmarSenhaEl.value) {
        msgEl.innerHTML = 'As senhas não se coincidem!';
        return;
    }

    buttonEl.disabled = false;

    msgEl.innerHTML = 'Senha confirmada!';
}