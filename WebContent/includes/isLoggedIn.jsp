<%
	String authenticated = (String) session.getAttribute("authenticated");
	
	if (authenticated == "false" || authenticated == null) {
	response.sendRedirect("/ProjectJavaWebJSP/pages/login/login.jsp");
}
%>