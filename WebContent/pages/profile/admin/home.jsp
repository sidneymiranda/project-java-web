<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta name="author" content="Sidney Miranda"/>
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
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/img/favicon.ico"
	type="image/x-icon" />

<title>Perfil de Administrador</title>

</head>

<body class="grid grid-template">
	<c:url value="/crud" var="crud" />
	<c:url value="/pages/profile/admin/home.jsp" var="home" />
	<c:url value="/pages/profile/admin/users.jsp" var="users" />
	<c:url value="/pages/profile/employee/read.jsp" var="read" />
	<c:url value="/pages/profile/employee/update.jsp" var="update" />
	<c:url value="/pages/profile/employee/delete.jsp" var="delete" />
	
	
	<jsp:include page="/includes/header.jsp" />
	
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
				Home
			</a>
		</li>

		<li id="pageQueryBook">
			<a href="${users}">
				<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-gear" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				  <path fill-rule="evenodd" d="M8.837 1.626c-.246-.835-1.428-.835-1.674 0l-.094.319A1.873 1.873 0 0 1 4.377 3.06l-.292-.16c-.764-.415-1.6.42-1.184 1.185l.159.292a1.873 1.873 0 0 1-1.115 2.692l-.319.094c-.835.246-.835 1.428 0 1.674l.319.094a1.873 1.873 0 0 1 1.115 2.693l-.16.291c-.415.764.42 1.6 1.185 1.184l.292-.159a1.873 1.873 0 0 1 2.692 1.116l.094.318c.246.835 1.428.835 1.674 0l.094-.319a1.873 1.873 0 0 1 2.693-1.115l.291.16c.764.415 1.6-.42 1.184-1.185l-.159-.291a1.873 1.873 0 0 1 1.116-2.693l.318-.094c.835-.246.835-1.428 0-1.674l-.319-.094a1.873 1.873 0 0 1-1.115-2.692l.16-.292c.415-.764-.42-1.6-1.185-1.184l-.291.159A1.873 1.873 0 0 1 8.93 1.945l-.094-.319zm-2.633-.283c.527-1.79 3.065-1.79 3.592 0l.094.319a.873.873 0 0 0 1.255.52l.292-.16c1.64-.892 3.434.901 2.54 2.541l-.159.292a.873.873 0 0 0 .52 1.255l.319.094c1.79.527 1.79 3.065 0 3.592l-.319.094a.873.873 0 0 0-.52 1.255l.16.292c.893 1.64-.902 3.434-2.541 2.54l-.292-.159a.873.873 0 0 0-1.255.52l-.094.319c-.527 1.79-3.065 1.79-3.592 0l-.094-.319a.873.873 0 0 0-1.255-.52l-.292.16c-1.64.893-3.433-.902-2.54-2.541l.159-.292a.873.873 0 0 0-.52-1.255l-.319-.094c-1.79-.527-1.79-3.065 0-3.592l.319-.094a.873.873 0 0 0 .52-1.255l-.16-.292c-.892-1.64.902-3.433 2.541-2.54l.292.159a.873.873 0 0 0 1.255-.52l.094-.319z"/>
				  <path fill-rule="evenodd" d="M8 5.754a2.246 2.246 0 1 0 0 4.492 2.246 2.246 0 0 0 0-4.492zM4.754 8a3.246 3.246 0 1 1 6.492 0 3.246 3.246 0 0 1-6.492 0z"/>
				</svg>
				Usuários
			</a>
		</li>
	</ul>
</nav>
		
	<section class="content">
		<form id="form-query" class="form-query" action="" method="post">
			<label 
				for="label-query" 
				class="label-query">
					Consultar:
			</label>
			<input 
				name="query" 
				type="text" 
				id="input-query" 
				autofocus
				class="input-query"
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
		
 		<input
					data-toggle="modal"
					data-target="#modalDados"
					class="btn btn-primary" 
					type="submit" 
					value="Cadastrar" 
					id="newRegister">
		
		<hr>
		
		<section>			
			<table class="table table-hover table-sm">
				<thead class="thead-ligth">
					<tr>
						<th scope="col">TÍTULO</th>
						<th scope="col">AUTOR</th>
						<th scope="col">ANO DE PUBLICAÇÃO</th>
						<th scope="col">ISBN</th>
						<th scope="col">EDIÇÃO</th>
						<th scope="col">AÇÕES</th>
					</tr>
				</thead>
				 <tbody>					 
					 <c:forEach items="${listBooks}" var="obj">
							<tr>
								<td><c:out value="${obj.title}" /></td>
								<td><c:out value="${obj.author}" /></td>
								<td><c:out value="${obj.year}" /></td>
								<td><c:out value="${obj.isbn}" /></td>
								<td><c:out value="${obj.edition}" /></td>	
								<td>
									<a href="${read}?action=read&title=${obj.title}&author=${obj.author}&year=${obj.year}&isbn=${obj.isbn} 
									&edition=${obj.edition}&idioma=${obj.idioma}&genre=${obj.genre}&sinopse=${obj.sinopse}"
									class="btn btn-primary">
										<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-eye" fill="white" xmlns="http://www.w3.org/2000/svg">
										  <path fill-rule="evenodd" d="M16 8s-3-5.5-8-5.5S0 8 0 8s3 5.5 8 5.5S16 8 16 8zM1.173 8a13.134 13.134 0 0 0 1.66 2.043C4.12 11.332 5.88 12.5 8 12.5c2.12 0 3.879-1.168 5.168-2.457A13.134 13.134 0 0 0 14.828 8a13.133 13.133 0 0 0-1.66-2.043C11.879 4.668 10.119 3.5 8 3.5c-2.12 0-3.879 1.168-5.168 2.457A13.133 13.133 0 0 0 1.172 8z"/>
										  <path fill-rule="evenodd" d="M8 5.5a2.5 2.5 0 1 0 0 5 2.5 2.5 0 0 0 0-5zM4.5 8a3.5 3.5 0 1 1 7 0 3.5 3.5 0 0 1-7 0z"/>
										</svg>
									</a>									
									<a href="${update}?action=update&title=${obj.title}&author=${obj.author}&year=${obj.year}&isbn=${obj.isbn}
									&edition=${obj.edition}&idioma=${obj.idioma}&genre=${obj.genre}&sinopse=${obj.sinopse}"
									class="btn btn-warning" data-toggle="modal" data-target="#modalUpdate" data-title="${obj.title}">
										<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil" fill="black">
  									<path fill-rule="evenodd" d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5L13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175l-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"/>
										</svg>
									</a>									
									<a href="${delete}?action=delete&title=${obj.title}&author=${obj.author}&year=${obj.year}&isbn=${obj.isbn}
									&edition=${obj.edition}&idioma=${obj.idioma}&genre=${obj.genre}&sinopse=${obj.sinopse}" 
									class="btn btn-danger">
										<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash" fill="white">
										  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
										  <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4L4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
										</svg>
									</a>									
								</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</section>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
	<script src="${pageContext.request.contextPath}/js/results.js"></script>
</body>

<!-- MODAL DE CADASTRO -->
		
	<div class="modal fade" id="modalDados" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Verifique os dados antes de confirmar</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        
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
								<input class="input grow" id="year" name="year" maxlength="4" autocomplete="off" required>
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
				
				<input
					data-toggle="modal"
					data-target="#modalDados"
					class="btn button-submit" 
					type="submit" 
					value="Cadastrar" 
					id="newRegister">
			</div>
		</form>
	        
	      </div>
	      <!-- <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div> -->
	    </div>
	  </div>
	</div>
</html>