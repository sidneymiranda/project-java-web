window.addEventListener('load', function () {
  const btnModalRemove = document.querySelector('#remove-item');
  btnRemove.addEventListener('click', 'modalRemove');

  function modalRemove() {
    const btn_remove = document.createElement('input');
    btn_remove.classList.add('btn');
    btn_remove.classList.add('button-submit');
    btn_remove.setAttribute('type', 'button');
    btn_remove.setAttribute('value', 'Remover');
    btn_remove.setAttribute('id', 'remove-item');
    btn_remove.setAttribute('data-toggle', 'modal');
    btn_remove.setAttribute('data-target', '#modal-delete-register');
    div_buttons.appendChild(btn_remove);
  }

  function remove(item) {
    localStorage.removeItem(item);
  }
});
