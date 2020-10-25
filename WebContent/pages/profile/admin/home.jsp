<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/profileAdm.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico"
	type="image/x-icon" />
	
<title>Perfil do usuário</title>
<jsp:useBean id="user" class="br.ucsal.model.User" scope="session" />
</head>

<body class="grid grid-template">
	
	<c:if test="${user.name == null}">
		<c:redirect url="login.jsp" />
	</c:if>

	<%@include file="/includes/header.jsp"%>
	<%@include file="/includes/menu.jsp"%>

	<section class="content">
	<form method="post" id="form-query" class="form-query">
			<label for="label-query" class="label-query">Consultar:</label>
			<input 
				type="text" 
				id="input-query" 
				autofocus
				class="input-form-query"
			>
			<input 
				type="reset"
				id="reset-form-query" 
				value="Limpar" 
				class="btn btn-secondary"
			>
			<input
				type="submit" 
				id="submit-form-query" 
				value="Consultar"
				class="btn btn-success"
			>
		</form>
	</section>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>
