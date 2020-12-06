
	
	document.forms[0].register.addEventListener('keyup', validar);

function validar() {
	var xhr = new XMLHttpRequest();
	var param;
	xhr.onreadystatechange = function() {

		if (xhr.readyState === 4 && xhr.status === 200) {
			param = document.forms[0].register.value;
			console.log('ok')

			var resp = JSON.parse(xhr.response);

			if (resp) {
				document.querySelector("#register").setAttribute("disabled","disabled");
 			} else {
				document.querySelector("#register").removeAttribute("disabled");
			}
		}
	};
	
	xhr.open("POST", "newUser", true);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send("action=validar&param=" + param);
}