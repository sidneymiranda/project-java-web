<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta name="author" content="Sidney Miranda"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/profileDefault.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
	rel="stylesheet" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/images/favicon.ico"
	type="image/x-icon" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>Perfil do usuário</title>
</head>
<body>
	<jsp:include page="/includes/header.jsp" />
	<section class="form">
		
		<form action="${pageContext.request.contextPath}/search" method="post" id="form-search">
			<label class="input" for="input-search">Consulta</label> 
			<input
				type="text" 
				id="input-search"
				name="query"
				placeholder="Nome do autor, título, ISBN ou vazio para todos... "
			/> 
			<input
				type="submit"
				class="btn btn-primary" 
				value="Pesquisar"
			/> 
			<input 
				type="reset"	
				value="Limpar"
				class="btn btn-secondary" 
			/>
		</form>
	</section>
	
	<hr>
	
	<section>		
		<table class="table table-hover table mt-5">
				<thead class="thead-dark">
					<tr>
						<th scope="col">TÍTULO</th>
						<th scope="col">AUTOR</th>
						<th scope="col">ANO DE PUBLICAÇÃO</th>
						<th scope="col">ISBN</th>
						<th scope="col">EDIÇÃO</th>
					</tr>
				</thead>
				 <tbody>					 
					 <c:forEach items="${resultList}" var="obj">
							<tr>
								<td><c:out value="${obj.title}" /></td>
								<td><c:out value="${obj.author}" /></td>
								<td><c:out value="${obj.year}" /></td>
								<td><c:out value="${obj.isbn}" /></td>
								<td><c:out value="${obj.edition}" /></td>
								</tr>
						</c:forEach>
					</tbody>
			</table>					
	
	</section>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>