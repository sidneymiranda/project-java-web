window.addEventListener('load', register);

function register() {
  // CADASTRO DE USUÁRIO
  var registry = document.querySelector('#registry');
  registry.setAttribute('maxLength', '10');
  var name = document.querySelector('#name');
  var password = document.querySelector('#password');
  password.setAttribute('maxLength', '10');
  var confirmPassword = document.querySelector('#confirmPassword');
  var formRegisterUser = document.querySelector('#formRegister');
  var typeUser = document.querySelectorAll('input[type=radio]');

  formRegisterUser.addEventListener('submit', function (e) {
    e.preventDefault();
    if (createNewUser()) {
      clearForm();
      window.location.assign(
        'http://localhost:8080/ProjectJavaWeb-JSP/pages/login/login.html'
      );
    }
  });

  function createNewUser() {
    if (validateFormRegister()) {
      var user = {
        registry: registry.value,
        name: name.value,
        password: password.value,
        typeUser: checkUserType(),
      };

      var db_users = [];
      if (localStorage.getItem('users')) {
        db_users = JSON.parse(localStorage.getItem('users'));
      }
      db_users.push(user);
      localStorage.setItem('users', JSON.stringify(db_users));
      alert('Pronto, agora entre com os seus dados!');
      return true;
    }
    alert('Senhas não conferem!');
    return false;
  }

  function checkUserType() {
    return typeUser[0].checked ? 'adm' : 'default';
  }

  function validateFormRegister() {
    return password.value == confirmPassword.value ? true : false;
  }

  function clearForm() {
    registry.value = '';
    name.value = '';
    password.value = '';
    confirmPassword.value = '';
  }
}
