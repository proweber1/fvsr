'use strict';

let btns = document.querySelectorAll('.btn-toggle');

btns.forEach((btn) => {
	btn.onclick = (e) => {
		e.preventDefault();
		let attr = e.target.getAttribute('href'),
				block = document.querySelector(attr);

		block.classList.toggle('active');

		attr === '#search__block' ?
			block.nextElementSibling.classList.remove('active') :
			block.previousElementSibling.classList.remove('active');
	};
});