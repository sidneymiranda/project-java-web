window.addEventListener('load', profile);
function profile() {
  const nameUser = document.querySelector('.nameUser');
  nameUser.innerHTML = 'Olá, ' + sessionStorage.getItem('logado');

  const pageRegisterBook = document.querySelector('#pageRegisterBook');
  const pageQueryBook = document.querySelector('#pageQueryBook');
  const body = document.querySelector('.content');

  pageRegisterBook.addEventListener('click', renderFormRegister);
  pageQueryBook.addEventListener('click', renderFormQuery);

  // ========================= RENDERIZA A PÁGINA DE CADASTRO ========================
  
  function renderFormRegister() {
    pageQueryBook.classList.remove('selected');
    body.innerHTML = '';
    pageRegisterBook.classList.add('selected');

    const form = document.createElement('form');
    form.classList.add('form');
    form.setAttribute('name', 'register-book');
    form.setAttribute('action', 'confirmation.jsp');
    form.setAttribute('method', 'post');
    body.appendChild(form);
    buildForm();

    function buildForm() {
      const labelTitle = document.createElement('label');
      labelTitle.setAttribute('for', 'title');
      labelTitle.textContent = 'Título';
      form.appendChild(labelTitle);

      const inputTitle = document.createElement('input');
      inputTitle.setAttribute('type', 'text');
      inputTitle.setAttribute('id', 'title');
      inputTitle.setAttribute('name', 'title');
      inputTitle.setAttribute('required', true);
      inputTitle.classList.add('input');
      form.appendChild(inputTitle);

      const labelAuthor = document.createElement('label');
      labelAuthor.setAttribute('for', 'author');
      labelAuthor.textContent = 'Nome do autor';
      form.appendChild(labelAuthor);

      const inputAuthor = document.createElement('input');
      inputAuthor.setAttribute('type', 'text');
      inputAuthor.setAttribute('id', 'author');
      inputAuthor.setAttribute('name', 'author');
      inputAuthor.setAttribute('required', true);
      inputAuthor.classList.add('input');
      form.appendChild(inputAuthor);

      // CONTAINER PRIMEIRA DIV
      const div_1 = document.createElement('div');
      div_1.classList.add('content-div');
      form.appendChild(div_1);

      // CONTAINER DIV 1 - LABELS
      const div_1_label = document.createElement('div');
      div_1_label.classList.add('content-div-label');
      div_1.appendChild(div_1_label);

      const label_year = document.createElement('label');
      label_year.classList.add('grow');
      label_year.setAttribute('for', 'year');
      label_year.textContent = 'Ano da Publicação';
      div_1_label.appendChild(label_year);

      const label_isbn = document.createElement('label');
      label_isbn.classList.add('grow');
      label_isbn.setAttribute('for', 'isbn');
      label_isbn.textContent = 'ISBN';
      div_1_label.appendChild(label_isbn);

      const label_edition = document.createElement('label');
      label_edition.classList.add('grow');
      label_edition.setAttribute('for', 'edition');
      label_edition.textContent = 'Edição';
      div_1_label.appendChild(label_edition);

      // CONTAINER DIV 1 - INPUTS
      const div_1_input = document.createElement('div');
      div_1_input.classList.add('content-div-input');
      div_1.appendChild(div_1_input);

      const input_year = document.createElement('input');
      input_year.classList.add('grow');
      input_year.setAttribute('type', 'text');
      input_year.setAttribute('id', 'year');
      input_year.setAttribute('name', 'year');
      input_year.setAttribute('required', true);
      div_1_input.appendChild(input_year);

      const input_isbn = document.createElement('input');
      input_isbn.classList.add('grow');
      input_isbn.setAttribute('type', 'text');
      input_isbn.setAttribute('id', 'isbn');
      input_isbn.setAttribute('name', 'isbn');
      input_isbn.setAttribute('required', true);
      div_1_input.appendChild(input_isbn);

      const input_edition = document.createElement('input');
      input_edition.classList.add('grow');
      input_edition.setAttribute('type', 'number');
      input_edition.setAttribute('id', 'edition');
      input_edition.setAttribute('name', 'edition');
      input_edition.setAttribute('required', true);
      div_1_input.appendChild(input_edition);

      // CONTAINER SEGUNDA DIV
      const div_2 = document.createElement('div');
      div_2.classList.add('content-div');
      form.appendChild(div_2);

      // CONTAINER DIV 2 - LABELS
      const div_2_label = document.createElement('div');
      div_2_label.classList.add('content-div-label');
      div_2.appendChild(div_2_label);

      const label_idioma = document.createElement('label');
      label_idioma.classList.add('grow');
      label_idioma.setAttribute('for', 'idioma');
      label_idioma.textContent = 'Idioma';
      div_2_label.appendChild(label_idioma);

      const label_genre = document.createElement('label');
      label_genre.classList.add('grow');
      label_genre.setAttribute('for', 'genre');
      label_genre.textContent = 'Gênero';
      div_2_label.appendChild(label_genre);

      // CONTAINER DIV 2 - INPUTS
      const div_2_input = document.createElement('div');
      div_2_input.classList.add('content-div-label');
      div_2.appendChild(div_2_input);

      const input_idioma = document.createElement('input');
      input_idioma.classList.add('grow');
      input_idioma.setAttribute('type', 'text');
      input_idioma.setAttribute('id', 'idioma');
      input_idioma.setAttribute('name', 'idioma');
      div_2_input.appendChild(input_idioma);

      const input_genre = document.createElement('input');
      input_genre.classList.add('grow');
      input_genre.setAttribute('type', 'text');
    	input_genre.setAttribute('id', 'genre');
      input_genre.setAttribute('name', 'genre');
      div_2_input.appendChild(input_genre);

      // CONTAINER SINOPSE

      const sinopse_label = document.createElement('label');
      sinopse_label.setAttribute('for', 'sinopse');
      sinopse_label.setAttribute('name', 'label-sinopse');
      sinopse_label.textContent = 'Sinopse';
      form.appendChild(sinopse_label);

      const sinopse_textarea = document.createElement('textarea');
      sinopse_textarea.setAttribute('id', 'sinopse');
      sinopse_textarea.setAttribute('name', 'sinopse');
      form.appendChild(sinopse_textarea);
    }

    // CONTAINER BOTÕES
    const div_buttons = document.createElement('div');
    div_buttons.classList.add('buttons');
    form.appendChild(div_buttons);

    const btn_reset = document.createElement('input');
    btn_reset.classList.add('btn');
    btn_reset.classList.add('button-reset');
    btn_reset.setAttribute('type', 'reset');
    btn_reset.setAttribute('value', 'Limpar');
    div_buttons.appendChild(btn_reset);

    const btn_submit = document.createElement('input');
    btn_submit.classList.add('btn');
    btn_submit.classList.add('button-submit');
    btn_submit.setAttribute('type', 'submit');
    btn_submit.setAttribute('value', 'Cadastrar');
    btn_submit.setAttribute('id', 'newRegister');
    div_buttons.appendChild(btn_submit);


/*    const confirm = document.querySelector('#confirm');
    confirm.addEventListener('click', function () {
      save();
    });*/

    // EFETUA O CADASTRO DO LIVRO
    var title = document.querySelector('#title');
    var author = document.querySelector('#author');
    var year = document.querySelector('#year');
    var isbn = document.querySelector('#isbn');
    var edition = document.querySelector('#edition');
    var idioma = document.querySelector('#idioma');
    var genre = document.querySelector('#genre');
    var sinopse = document.querySelector('#sinopse');

    function save() {
      if (createNewRegister()) {
        clearForm();
      }
    }

    function createNewRegister() {
      if (validateRegister()) {
        var book = {
          title: title.value,
          author: author.value,
          year: year.value,
          isbn: isbn.value,
          edition: edition.value,
          idioma: idioma.value,
          genre: genre.value,
          sinopse: sinopse.value,
        };

        let db_books = localStorage.getItem('books')
          ? JSON.parse(localStorage.getItem('books'))
          : [];
        db_books.push(book).toUpperCase;
        localStorage.setItem('books', JSON.stringify(db_books));
        alert('Cadastro efetuado com sucesso!');
        return true;
      }
      alert('Erro no cadastro');
      return false;
    }

    function validateRegister() {
      if (
        title.value !== '' &&
        author !== '' &&
        year !== '' &&
        isbn !== '' &&
        edition !== '' &&
        sinopse !== ''
      ) {
        btn_submitu.setAttribute('data-target', '#modal-create-register');
        return true;
      }
    }

    function clearForm() {
      title.value = '';
      author.value = '';
      year.value = '';
      isbn.value = '';
      edition.value = '';
      idioma.value = '';
      genre.value = '';
      sinopse.value = '';
    }
  }

  // ====================== RENDERIZA O FORM DE CONSULTA ==============================
  
  function renderFormQuery() {
    pageRegisterBook.classList.remove('selected');
    body.innerHTML = '';
    pageQueryBook.classList.add('selected');
    const formQuery = document.createElement('form');
    const labelQuery = document.createElement('label');
    const inputQuery = document.createElement('input');
    const btn_reset_query = document.createElement('input');
    const btn_submit_query = document.createElement('input');

    formQuery.setAttribute('method', 'post');
    formQuery.setAttribute('id', 'form-query');
    formQuery.classList.add('form-query');

    labelQuery.setAttribute('for', 'label-query');
    labelQuery.textContent = 'Consultar:';
    labelQuery.classList.add('label-query');

    inputQuery.setAttribute('type', 'text');
    inputQuery.setAttribute('id', 'input-query');
    inputQuery.setAttribute('autofocus', true);
    inputQuery.classList.add('input-form-query');

    btn_submit_query.setAttribute('type', 'submit');
    btn_submit_query.setAttribute('id', 'submit-form-query');
    btn_submit_query.setAttribute('value', 'Consultar');
    btn_submit_query.classList.add('btn');
    btn_submit_query.classList.add('btn-success');

    btn_reset_query.setAttribute('type', 'reset');
    btn_reset_query.setAttribute('id', 'reset-form-query');
    btn_reset_query.setAttribute('value', 'Limpar');
    btn_reset_query.classList.add('btn');
    btn_reset_query.classList.add('btn-secondary');

    body.appendChild(formQuery);
    formQuery.appendChild(labelQuery);
    formQuery.appendChild(inputQuery);
    formQuery.appendChild(btn_reset_query);
    formQuery.appendChild(btn_submit_query);

    // SCRIPT DE CONSULTA
    btn_submit_query.addEventListener('click', function (e) {
      e.preventDefault();
      fetchItem(inputQuery.value);

      function fetchItem(item) {
        const registers = JSON.parse(localStorage.getItem('books'));
        if (registers.map((register) => register.title).includes(item)) {
          console.log(register.title);
          // renderComponente(register);
        }
      }

      function renderComponente(register) {
        let form = document.createElement('form');

        // LABELS
        let label_title = document.createElement('label');
        label_title = setAttribute('for', `title_${register.title}`);
        label_title.textContent = register.title;

        let label_author = document.createElement('label');
        label_author = setAttribute('for', '');
        label_author.textContent = register.author;

        let label_review = document.createElement('label');
        label_review = setAttribute('for', '');
        label_review.textContent = register.review;

        let label_isbn = document.createElement('label');
        label_isbn = setAttribute('for', '');
        label_isbn.textContent = register.isbn;

        let label_edition = document.createElement('label');
        label_edition = setAttribute('for', '');
        label_edition.textContent = register.edition;

        let label_idioma = document.createElement('label');
        label_idioma = setAttribute('for', '');
        label_idioma.textContent = register.idioma;

        let label_genre = document.createElement('label');
        label_genre = setAttribute('for', '');
        label_genre.textContent = register.genre;

        let label_sinopse = document.createElement('label');
        label_sinopse = setAttribute('for', '');
        label_sinopse.textContent = register.sinopse;

        // INPUTS
        let input_title = document.createElement('input');
        input_title.textContent = register.title;
        input_title.setAttribute('id', `title_${register.title}`);

        let input_author = document.createElement('input');
        input_author.textContent = register.title;

        let input_review = document.createElement('input');
        input_review.textContent = register.title;

        let input_isbn = document.createElement('input');
        input_isbn.textContent = register.title;

        let input_edition = document.createElement('input');
        input_edition.textContent = register.title;

        let input_idioma = document.createElement('input');
        input_idioma.textContent = register.title;

        let input_genre = document.createElement('input');
        input_genre.textContent = register.title;

        let input_sinopse = document.createElement('input');
        input_sinopse.textContent = register.title;

        // BOTÕES

        const btn_remove = document.createElement('input');
        btn_remove.setAttribute('type', 'button');
        btn_remove.setAttribute('id', 'btn-remove-item');
        btn_remove.setAttribute('value', 'Deletar');
        btn_remove.classList.add('btn');
        btn_remove.classList.add('btn-danger');

        const btn_edit = document.createElement('input');
        btn_edit.setAttribute('type', 'button');
        btn_edit.setAttribute('id', 'btn-edit-item');
        btn_edit.setAttribute('value', 'Editar');
        btn_edit.classList.add('btn');
        btn_edit.classList.add('btn-danger');

        form.appendChild('label_title');
        form.appendChild('input_title');
        form.appendChild('label_author');
        form.appendChild('input_author');
        form.appendChild('label_review');
        form.appendChild('input_review');
        form.appendChild('label_isbn');
        form.appendChild('input_isbn');
        form.appendChild('label_edition');
        form.appendChild('input_edition');
        form.appendChild('label_idioma');
        form.appendChild('input_idioma');
        form.appendChild('label_genre');
        form.appendChild('input_genre');
        form.appendChild('label_sinopse');
        form.appendChild('input_sinopse');
        form.appendChild('btn_remove');
        form.appendChild('btn_edit');
      }
    });
  }

  const logoff = document.querySelector('#logoff');
  logoff.addEventListener('click', logout);

  function logout() {
    window.location.assign('http://127.0.0.1:5501/src/pages/login/login.html');
  }
}
