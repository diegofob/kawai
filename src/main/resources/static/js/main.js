const listaBotonesHtml = document.querySelectorAll('.electroplus__step__link');
const listaBotonesHtmlMobile = document.querySelectorAll('.step__code');
var listaImagenes = ['image/iphone1.gif', 'image/iphone2.gif', 'image/iphone3.gif'];
var listaBotones = ['busca', 'elige', 'paga'];
var indice = 1;

let timer = setInterval(() => {
    slider(listaBotones[indice]);
}, 6000);

$(document).ready(function () {
    // Scrollspy
    $('.nav-link').on('click', function () {
        $('.electroplus__menu__navbar').removeClass('show');
        var clickedItem = $(this).attr('href');
        $('html, body').animate({
            scrollTop: $(clickedItem).offset().top
        }, 600);
    });
});

// Open menu mobile
function toggleMenuMobile() {
    $('.electroplus__menu__navbar').toggleClass('show');
}

function slider(clickedItem) {
    $('.electroplus__step__link, .step__code').removeClass('active');
    //listaBotonesHtml[indice].classList.add('active');
    //listaBotonesHtmlMobile[indice].classList.add('active');
    $('.content__step').addClass('d-none');
    $('#' + clickedItem).removeClass('d-none');
    $('#iphone__content').attr('src', listaImagenes[indice]);
    indice = indice + 1;
    if (clickedItem === 'paga') {
        indice = 0;
    }
}

function activeSlider(posicion) {
    indice = posicion;
    clearInterval(timer);
    slider(listaBotones[indice]);
    timer = setInterval(() => {
        slider(listaBotones[indice]);
    }, 6000);
}

$(document).ready(function(){
    $("#myToast").toast();
});