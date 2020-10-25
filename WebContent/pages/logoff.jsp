<%
	session.setAttribute("authenticated", false);
	response.sendRedirect("/ProjectJavaWebJSP/pages/login/login.jsp");
%>