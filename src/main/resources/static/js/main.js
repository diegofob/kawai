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
	// Touch slider 
	$(".carousel .carousel-inner").swipe({
		swipeLeft: function (event, direction, distance, duration, fingerCount) {
			this.parent().carousel('next');
		},
		swipeRight: function () {
			this.parent().carousel('prev');
		},
		threshold: 0,
		excludedElements: "label, button, input, select, textarea, .noSwipe"
	});

	$('.carousel .carousel-inner').on('dragstart', 'a', function () {
		return false;
	});
	// Beneficios
	$(".electroplus__card").mouseover(function () {
		var hoverItem = parseInt($(this).attr('data-card'));
		$('.electroplus__card').addClass("card__opacity");
		$(this).removeClass("card__opacity");
		// Imagen
		$('.beneficio').addClass('d-none');
		switch (hoverItem) {
			case 1:
				$('.beneficio.uno').removeClass('d-none');
				break
			case 2:
				$('.beneficio.dos').removeClass('d-none');
				break
			case 3:
				$('.beneficio.cinco').removeClass('d-none');
				break
			case 4:
				$('.beneficio.tres').removeClass('d-none');
				break
			case 5:
				$('.beneficio.cuatro').removeClass('d-none');
				break
		}
	});
	$(".electroplus__card").mouseout(function () {
		$('.electroplus__card').removeClass("card__opacity");
		$('.beneficio').addClass('d-none');
		$('#beneficioDefault').removeClass('d-none');
	});
});
// Open menu mobile
function toggleMenuMobile() {
	$('.electroplus__menu__navbar').toggleClass('show');
}
function slider(clickedItem) {
	$('.electroplus__step__link, .step__code').removeClass('active');
	listaBotonesHtml[indice].classList.add('active');
	listaBotonesHtmlMobile[indice].classList.add('active');
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