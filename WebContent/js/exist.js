/**
 * 
 */
var xmlHTTP = new XMLHttpRequest();

	function check() {
		
		var register = documento.forms[0].register.value
		
		var url = "VirtualBookcase/newUser";
		xmlHTTP.open("POST", url, true);
		
		xmlHTTP.onreadystatechange = response;
		
		var param = "param=" + register;
		
		xmlHTTP.setRequestHeader("Content-Type", "application/x-www-form-urlenconded;");
		xmlHTTP.send(param);
	}
	
	function response() {
		
		if(xmlHTTP.readyState == 4 && xmlHTTP.status == 200) {
			
			alert(xmlHTTP.responseXML.getElementsByTagName("result")[0].firstChild.data);
			
		}
		
	}