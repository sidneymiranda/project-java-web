<%
	/* session.setAttribute("authenticated", false); */
	session.setAttribute("userLogado", null);
	response.sendRedirect("/ProjectJavaWebJSP/pages/login.jsp");
%>