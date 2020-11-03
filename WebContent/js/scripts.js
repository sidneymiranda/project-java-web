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

const select = document.querySelector('select');
const optYear = document.querySelector('#year');

select.addEventListener('click', (e) => {
  const selected = e.target[13].selected;
  if (selected) {
    select.setAttribute('hidden', 'hidden');
    optYear.removeAttribute('hidden', 'hidden');
  }
});


