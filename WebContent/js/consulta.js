function render() {
  var handleInput = document.querySelector('#input-query');
  handleInput.addEventListener('keyup', function (e) {
    e.preventDefault();
    console.log(e);
  });
}

function query() {
  // const registers = JSON.parse(localStorage.getItem('books'));
  // if (registers.map((register) => register.title).includes(item)) {
  //   renderComponente(registers);
  // }
}

function renderComponente(registers) {
  let form = document.createElement('form');
  let label_title = document.createElement('label');
  label_title.textContent = registers.title;
  let label_author = document.createElement('label');
  let label_review = document.createElement('label');
  let label_isbn = document.createElement('label');
  let label_edition = document.createElement('label');
  let label_idioma = document.createElement('label');
  let label_genre = document.createElement('label');
  let label_sinopse = document.createElement('label');

  let input_title = document.createElement('input');
  let input_author = document.createElement('input');
  let input_review = document.createElement('input');
  let input_isbn = document.createElement('input');
  let input_edition = document.createElement('input');
  let input_idioma = document.createElement('input');
  let input_genre = document.createElement('input');
  let input_sinopse = document.createElement('input');

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
}
