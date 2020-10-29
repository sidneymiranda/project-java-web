
const pageHome = document.querySelector('#pageRegisterBook');
const pageRegister = document.querySelector('#pageQueryBook');

pageHome.addEventListener('click', () => {
	pageRegister.classList.remove('selected');
	pageHome.classList.add('selected');
});

pageRegister.addEventListener('click', () => {
	pageHome.classList.remove('selected');
	pageRegister.classList.add('selected');
});


