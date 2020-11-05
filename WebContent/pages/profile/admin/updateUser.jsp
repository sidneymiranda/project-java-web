<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/crudAdmin" method="post">
	<label>Nome</label>
	<input type="text" value="${param.name}">
	<label>Matrícula</label>
	<input type="text" value="${param.register}">
	<label>Perfil de acesso</label>
	<input type="text" value="${param.typeUser}">
</form>
</body>
</html>