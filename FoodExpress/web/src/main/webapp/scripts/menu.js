function menuShow() {
    let menuMobile = document.querySelector('.menu-options-mobile');
    if (menuMobile.classList.contains('open')) {
        menuMobile.classList.remove('open');
        document.querySelector('.menuBtn').src = "imgs/menu_white_36dp.svg";
    } else {
        menuMobile.classList.add('open');
        document.querySelector('.menuBtn').src = "imgs/close_white_36dp.svg";
    }
}