/**
 * 
 */

const results = document.querySelector('#input-query');


results.addEventListener('keyup', (event) => {
	document.querySelector('form').addEventListener('submit', (event) => event.preventDefault());
	const query = event.target.value;
	
	
	
	console.log(query);
});
