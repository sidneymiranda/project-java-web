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

<title>Perfil do usuário</title>

</head>

<body class="grid grid-template">
	<c:url value="CrudSrv" var="crud" />
	<c:url value="/pages/profile/admin/home.jsp" var="home" />
	<c:url value="/pages/profile/admin/create.jsp" var="create" />
	<c:url value="/pages/profile/admin/update.jsp" var="update" />
	<c:url value="/pages/profile/admin/read.jsp" var="read" />
	<c:url value="/pages/profile/admin/delete.jsp" var="delete" />
	
	
	<jsp:include page="/includes/header.jsp" />
	
	<%-- <jsp:include page="/includes/menu.jsp" /> --%>
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
		<form method="post" id="form-query" class="form-query" action="">
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
					class="btn button-submit" 
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
									<a href="${update}?action=update&title=${obj.title}&author=${obj.author}&isbn=${obj.isbn}" 
									class="btn btn-warning">
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

<!-- Modal -->
		
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
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button>
	      </div>
	    </div>
	  </div>
	</div>
</html>