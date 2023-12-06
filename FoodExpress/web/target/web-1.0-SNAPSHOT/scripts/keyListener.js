$(function() {
    $(document).on('keypress', e => {
        console.log(e.keyCode)
        $(`[data-key="${e.keyCode}"]`).click();
    })
});