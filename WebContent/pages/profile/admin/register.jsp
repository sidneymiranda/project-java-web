<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<title>Cadastro de Livros</title>
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico"
	type="image/x-icon" />
</head>

<body class="grid grid-template">
	
	<%@include file="/includes/header.jsp"%>
 	<%@include file="/includes/menu.jsp"%>
	
	<section class="content">
		<form class="form" name="register-book" action="confirmation.jsp"	method="post">
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
					<input class="input grow" type="text" id="year" name="year" autocomplete="off" required>
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
				<input class="btn button-reset" type="reset" value="Limpar">
				<input class="btn button-submit" type="submit" value="Cadastrar" id="newRegister">
			</div>
		</form>
	</section>
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
</body>
</html>