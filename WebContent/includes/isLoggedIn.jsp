
<%
	boolean user = (Boolean) session.getAttribute("authenticated");
	if (!user) {
	response.sendRedirect("/ProjectJavaWebJSP/pages/login/login.jsp");
}
%>