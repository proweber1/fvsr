'use strict';

let btns = document.querySelectorAll('.btn-toggle');

btns.forEach((btn) => {
	btn.onclick = (e) => {
		e.preventDefault();
		let attr = e.target.getAttribute('href'),
			block = document.querySelector(attr);
		console.log(block);
		block.classList.toggle('active');

		attr === '#search__block' ?
			block.nextElementSibling.classList.remove('active') :
			block.previousElementSibling.classList.remove('active');
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
		format:'Y-m-d H:i:s',
		lang:'ru',
		dayOfWeekStart: 1,
		scrollTime: true,
		step: 15
	});
});