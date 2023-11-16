const inputElements = [...document.querySelectorAll('input.code-input')];

inputElements.forEach((el, index) => {
    el.addEventListener('keydown', (e) => {
        if (e.keyCode === 8 && e.target.value === '') inputElements[Math.max(0, index - 1)].focus();
    });
    
    el.addEventListener('input', (e) => {
        const [first, ...rest] = e.target.value;
        e.target.value = first ?? '';
        const lastInputBox = index === inputElements.length - 1;
        const didInsertContent = first !== undefined;
        if (didInsertContent && !lastInputBox) {
            inputElements[index + 1].focus();
            inputElements[index + 1].value = rest.join('');
            inputElements[index + 1].dispatchEvent(new Event('input'));
        }
    });
});