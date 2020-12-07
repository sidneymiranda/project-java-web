<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="author" content="Sidney Miranda"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/profileAdm.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico"
	type="image/x-icon" />
<title>Configuração de usuários</title>
</head>
<body class="container">
<h1>Registro do usuário selecionado</h1>
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
		value="${param.typeUser == 'employee' ? 'funcionário' : param.typeUser == 'user' ? 'estudante' : 'administrador'}"
		readonly
	>
	<div class="buttons">
			<a 
				class="btn button-cancel"
				href="${pageContext.request.contextPath}/pages/profile/admin/users.jsp"
			>
				VOLTAR
			</a>			
		</div>
</form>
</body>
</html>