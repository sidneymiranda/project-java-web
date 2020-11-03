<%
	session.setAttribute("authenticated", false);
	/* session.setAttribute("userLogado", ""); */
	response.sendRedirect("/ProjectJavaWebJSP/pages/login/login.jsp");
%>