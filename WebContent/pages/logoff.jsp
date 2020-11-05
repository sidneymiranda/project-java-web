<%
	/* session.setAttribute("authenticated", false); */
	session.setAttribute("userLogado", null);
	response.sendRedirect("/VirtualBookcase/pages/login.jsp");
%>