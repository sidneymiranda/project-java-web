<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="pt">
<head>
<meta charset="utf-8" />
<meta name="author" content="Sidney Miranda"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/profileAdm.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />

<title>Cadastro de Livros</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico"
	type="image/x-icon" />
</head>

<body class="grid grid-template">
	<c:url value="/pages/profile/admin/home.jsp" var="home" />
	<c:url value="/pages/profile/admin/create.jsp" var="create" />
 	<jsp:include page="/includes/header.jsp"/>
 	
 <nav class="sidebar">
	<ul>
		<li id="pageRegisterBook">
			<a href="${home}">
				<svg
						xmlns="http://www.w3.org/2000/svg" width="1em" height="1em"
						viewBox="0 0 16 16" class="bi bi-search" fill="white">
		  			<path fill-rule="evenodd"
							d="M10.442 10.442a1 1 0 0 1 1.415 0l3.85 3.85a1 1 0 0 1-1.414 1.415l-3.85-3.85a1 1 0 0 1 0-1.415z" />
		  			<path fill-rule="evenodd"
							d="M6.5 12a5.5 5.5 0 1 0 0-11 5.5 5.5 0 0 0 0 11zM13 6.5a6.5 6.5 0 1 1-13 0 6.5 6.5 0 0 1 13 0z" />
				</svg>
				Consultar
			</a>
		</li>

		<li id="pageQueryBook">
			<a href="${create}">
				<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em"
					viewBox="0 0 16 16" class="bi bi-book" fill="white">
  				<path fill-rule="evenodd"
						d="M1 2.828v9.923c.918-.35 2.107-.692 3.287-.81 1.094-.111 2.278-.039 3.213.492V2.687c-.654-.689-1.782-.886-3.112-.752-1.234.124-2.503.523-3.388.893zm7.5-.141v9.746c.935-.53 2.12-.603 3.213-.493 1.18.12 2.37.461 3.287.811V2.828c-.885-.37-2.154-.769-3.388-.893-1.33-.134-2.458.063-3.112.752zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z" />
				</svg> 
				Cadastrar
			</a>
		</li>
	</ul>
</nav>
	
	<section class="content">
		<form class="form" name="register-book" action="create-confirm.jsp?action=create"	method="post">
			<label for="title">Título</label>
			<input type="text" name="title" class="input" autocomplete="off" required>
			
			<label for="author">Nome do autor</label>
			<input type="text" name="author" class="input" autocomplete="off" required>
			
			<div class="content-div">
				<div class="content-div-label">
					<label class="grow" for="year">Ano da Publicação</label>
					<label class="grow" for="isbn">ISBN</label>
					<label class="grow"	for="edition">Edição</label>
				</div>
				<div class="content-div-input">
					<select class="input grow">
						<option>Ano</option>
						<option>1999</option>
						<option>2000</option>
						<option>2001</option>
						<option>2002</option>
						<option>2003</option>
						<option>2004</option>
						<option>2005</option>
						<option>2006</option>
						<option>2007</option>
						<option>2008</option>
						<option>2009</option>
						<option>2010</option>
						<option>outro</option>
					</select>
					<input hidden class="input grow" id="year" name="year" maxlength="4" autocomplete="off" required>
					<input class="input grow" type="text" id="isbn"	name="isbn" autocomplete="off" required>
					<input class="input grow"	type="number" min="1" id="edition" name="edition" autocomplete="off" required>
				</div>
			</div>
			<div class="content-div">
				<div class="content-div-label">
					<label class="grow" for="idioma">Idioma</label>
					<label class="grow" for="genre">Gênero</label>
				</div>
				<div class="content-div-label">
					<input class="input grow" type="text" id="idioma" name="idioma" autocomplete="off">
					<input class="input grow" type="text" id="genre" name="genre" autocomplete="off">
				</div>
			</div>
		
			<label for="sinopse">Sinopse</label>
			<textarea class="input" id="sinopse" name="sinopse"></textarea>
		
			<div class="buttons">
				<input class="btn btn-white" type="reset" value="Limpar">
				
				<input
					class="btn btn-success" 
					type="submit" 
					value="Cadastrar" 
					id="newRegister">
			</div>
		</form>
	</section>
	
	
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>