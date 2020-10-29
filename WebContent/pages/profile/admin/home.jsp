<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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

</head>

<body class="grid grid-template">
	<jsp:include page="/includes/isLoggedIn.jsp" />
	<jsp:include page="/includes/header.jsp" />
	<jsp:include page="/includes/menu.jsp" />

	<section class="content">
		<form method="post" id="form-query" class="form-query" action="">
			<label for="label-query" class="label-query">Consultar:</label> <input
				name="query" type="text" id="input-query" autofocus
				class="input-form-query"> <input type="reset"
				id="reset-form-query" value="Limpar" class="btn btn-secondary">
			<input type="submit" id="submit-form-query" value="Consultar"
				class="btn btn-success">
		</form>

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
									<input class="btn btn-warning" type="button" value="editar">
									<input class="btn btn-danger" type="button" value="remover">
								</td>
							</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</section>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/scripts.js"></script>
	<script src="${pageContext.request.contextPath}/js/results.js"></script>
</body>
</html>
