<%
	session.setAttribute("userLogado", null);
	session.setAttribute("profile", null);
	response.sendRedirect("/VirtualBookcase/pages/login.jsp");
%>