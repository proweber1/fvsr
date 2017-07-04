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
			document.body.classList.toggle('toggle-close');
			document.body.classList.remove('toggle-open');
		} else {
			document.body.classList.toggle('toggle-open');
			document.body.classList.remove('toggle-close');
		}
};

$.datetimepicker.setLocale('ru');
$( document ).ready(function() {
	$('.datetimepicker').datetimepicker({
		timepicker:false,
		format:'d.m.Y',
		lang:'ru',
		dayOfWeekStart: 1,
		scrollTime: true,
		step: 15
	});
});

$('.select2').select2();