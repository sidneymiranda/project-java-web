window.addEventListener('load', profile);

function profile() {
  const nameUser = document.querySelector('.nameUser');
  nameUser.innerHTML = 'Olá, ' + sessionStorage.getItem('logado');

  const form = document.querySelector('#form-search');
  form.addEventListener('submit', function (e) {
    e.preventDefault();
  });

  const input_search = document.querySelector('#input-search');
  form.addEventListener('submit', function (e) {
    e.preventDefault();
  });

  const logoff = document.querySelector('#logoff');
  logoff.addEventListener('click', logout);

  function logout() {
    window.location.assign('http://127.0.0.1:5501/src/pages/login/login.html');
  }
}
