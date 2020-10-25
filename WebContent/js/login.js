window.addEventListener('load', login);

function login() {
  //LOGIN
  var registry_login = document.querySelector('#registry-login');
  var passwordLogin = document.querySelector('#passwordLogin');
  var formLogin = document.querySelector('#formLogin');

  formLogin.addEventListener('submit', function (e) {
    e.preventDefault();
    if (localStorage.getItem('users')) {
      db_users = JSON.parse(localStorage.getItem('users'));

      if (findUser()) {
        redirectProfile();
      } else {
        alert('senha incorreta');
      }

      function findUser() {
        if (
          db_users.filter(
            (user) =>
              user.registry == registry_login.value &&
              user.password == passwordLogin.value
          ).length === 1
        )
          return true;
      }
    }

    function redirectProfile() {
      var profile = db_users
        .filter(
          (user) =>
            user.registry == registry_login.value &&
            user.password == passwordLogin.value
        )
        .map((user) => user.typeUser);

      var nameUser = db_users
        .filter(
          (user) =>
            user.registry == registry_login.value &&
            user.password == passwordLogin.value
        )
        .map((user) => user.name);

      sessionStorage.setItem('logado', `${nameUser}`);
      if (profile == 'adm') {
        return window.location.assign(
          `http://127.0.0.1:5501/src/pages/userProfile/adm/profile.html`
        );
      }
      window.location.assign(
        `http://127.0.0.1:5501/src/pages/userProfile/default/profile.html`
      );
    }
  });
}
