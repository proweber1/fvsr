'use strict';

window.App = window.App || {};
App.plugins = (() => {
	return {
		datetimepicker() {
			$.datetimepicker.setLocale('ru');

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
		}
	}
})();

App.navbar = (() => {
	return {
		run() {
			document.getElementById('toggle_sidemenu_l')
				.onclick = () => {
				if ( window.innerWidth > 1200 ) {
					this.asideToggleDesktop();
				} else {
					this.asideToggleTablet();
				}

				this.setState();
			};
		},
		setState() {
			if (document.body.classList.contains('toggle-close')) {
				localStorage.setItem('aside-state', 'true');
			} else {
				localStorage.setItem('aside-state', 'false');
			}
		},
		asideToggleDesktop() {
			this.animateFadeIn('toggle-close');

			document.body.classList.toggle('toggle-close');
			document.body.classList.remove('toggle-open');
		},
		asideToggleTablet() {
			document.body.classList.toggle('toggle-open');
			document.body.classList.remove('toggle-close');

			this.animateFadeIn('toggle-open');
		},
		animateFadeIn(state) {
			if (document.body.classList.contains(state)) {
				document.body.classList.add('animate');

				setTimeout(function () {
					document.body.classList.remove('animate');
				}, 1000)
			}
		}
	}
})();

App.tabs = (() => {
	return {
		run() {
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
		}
	}
})();

window.onload = () => {
	App.plugins.datetimepicker();
	App.tabs.run();
	App.navbar.run();
};