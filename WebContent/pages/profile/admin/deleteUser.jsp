<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="author" content="Sidney Miranda"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profileAdm.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<title>Configuração de usuários</title>
</head>
<body class="container">
<h1>Tem certeza que deseja remover este usuário?</h1>
<form class="form" action="${pageContext.request.contextPath}/crudAdmin?action=${param.action}" method="post">
	<label>Nome</label>
	<input 
		type="text" 
		name="name"
		class="input" 
		value="${param.name}"
		readonly
	>
	<label>Matrícula</label>
	<input 
		type="text" 
		name="register"
		class="input" 
		value="${param.register}"
		readonly
	>
	<label>Perfil de acesso</label>
	<input 
		type="text" 
		name="typeUser"
		class="input"
		value="${param.typeUser}"
		readonly
	>
	<div class="buttons">
			<input
				class="btn btn-danger" 
				type="submit" 
				value="REMOVER"
			>
			<a 
				class="btn btn-secondary"
				href="${pageContext.request.contextPath}/pages/profile/admin/users.jsp"
			>
				CANCELAR
			</a>			
		</div>
</form>
</body>
</html>