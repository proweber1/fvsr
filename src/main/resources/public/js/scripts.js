'use strict';

let btns = document.querySelectorAll('.btn-toggle');

btns.forEach((btn) => {
	btn.onclick = (e) => {
	e.preventDefault();
	e.target.classList.toggle('active');
		let elem = e.target,
	 	  attr = elem.getAttribute('href'),
	 		block = document.querySelector(attr);
			block.classList.toggle('active');

			if (attr === '#search__block') {
				block.nextElementSibling.classList.remove('active');
				elem.nextElementSibling.classList.remove('active');
			} else {
				block.previousElementSibling.classList.remove('active');
				elem.previousElementSibling.classList.remove('active');
			}
	};
});

document.getElementById('toggle_sidemenu_l')
	.onclick = () => {
		if ( window.innerWidth > 1200 ) {
			asideToggleDesktop();
		} else {
			asideToggleTablet();
		}

	setState();
};
function setState() {
	if (document.body.classList.contains('toggle-close')) {
		localStorage.setItem('aside-state', 'true');
	} else {
		localStorage.setItem('aside-state', 'false');
	}
}
function asideToggleDesktop() {
	animate('toggle-close');
	
	document.body.classList.toggle('toggle-close');
	document.body.classList.remove('toggle-open');
}
function asideToggleTablet() {
	document.body.classList.toggle('toggle-open');
	document.body.classList.remove('toggle-close');

	animate('toggle-open');
}
function animate(state) {
	if (document.body.classList.contains(state)) {
		document.body.classList.add('animate');

		setTimeout(function () {
			document.body.classList.remove('animate');
		}, 1000)
	}
}

$.datetimepicker.setLocale('ru');
$( document ).ready(function() {
	$('.datepicker').datetimepicker({
		timepicker:false,
		format:'d.m.Y',
		lang:'ru',
		dayOfWeekStart: 1,
		scrollTime: true,
		step: 15
	});
	$('.datetimepicker').datetimepicker({
		format:'d.m.Y H:i:s',
		lang:'ru',
		dayOfWeekStart: 1,
		scrollTime: true,
		step: 15
	});
});

$('.select2').select2();

let sort = document.querySelectorAll('.sort');

sort.forEach((item) => {
	item.onclick = (e) => {
		let elem = e.target,
			elemSort = elem.getAttribute('data-sort');

		document.querySelector('.sort.active').classList.remove('active');
		elem.classList.add('active');
		localStorage.setItem('sort', elemSort);
	};
});

$( document ).ready(function() {
	let activeSort = localStorage.getItem('sort');
	if (!activeSort) return;

	document.querySelector('[data-sort="' + activeSort +'"]').classList.add('active');
});
