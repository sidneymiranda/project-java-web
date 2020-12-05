<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>

<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/css/register.css" />
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />

<title>Cadastro de usuário</title>

</head>

<body>
	<section class="register-content">
		<section class="register-content-left">
			<section class="form-register">
				<h1>Crie o seu acesso</h1>

				<form action="${pageContext.request.contextPath}/newUser?action=insert" method="post" id="formRegister">
					<fieldset>
						<input type="text" name="register" placeholder="MATRÍCULA" maxlength="10" autofocus required onblur="check()" />
						<input type="text" name="name" placeholder="NOME" required /> 
						<input type="password" name="password" placeholder="SENHA" required /> 
						<input type="password" name="confirmPassword"	placeholder="REPETIR A SENHA" required /> 
						
						<input class="button button-success" type="submit" id="register" value="CADASTRAR" disabled />
					</fieldset>
				</form>
			</section>
		</section>

		<section class="form-register-details">
			<div class="slogan">
				<h1>Virtual Bookcase</h1>
				<span>Software de gestão de livros</span>			
			</div>		

			<p>
				COMECE HOJE A FAZER GESTÃO <br /> DOS SEUS LIVROS FAVORITOS.
			</p>

			<div class="arrow">
				<a href="${pageContext.request.contextPath}/pages/login.jsp">
				<svg xmlns="http://www.w3.org/2000/svg" width="2em" height="1.8em" viewBox="0 0 16 16" class="bi bi-box-arrow-left" fill="white">
				  <path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z"/>
				  <path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z"/>
				</svg>
				</a>
				<span>VOLTAR PARA O LOGIN</span>
			</div>
		</section>
	</section>
	
	<script src="${pageContext.request.contextPath}/js/exist.js"></script>
</body>
</html>
