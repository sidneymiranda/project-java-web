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
<title>Cadastro de usuário</title>
</head>

<body>
	<section class="register-content">
		<section class="register-content-left">
			<section class="form-register">
				<h1>Crie sua conta</h1>

				<form action="${pageContext.request.contextPath}/register-user" method="post" id="formRegister">
					<fieldset>
					
						<div class="type-user">
							<input type="radio" name="typeUser" id="admin" value="admin" required />
							<label for="admin">admin</label> 
							<input type="radio" name="typeUser" id="user" value="user" required />
							<label for="default">padrão</label>
						</div>

						<input type="text" name="register" placeholder="MATRÍCULA" maxlength="10" required />
						<input type="text" name="name" placeholder="NOME" required /> 
						<input type="password" name="password" placeholder="SENHA" maxlength="10" required /> 
						<input type="password" name="confirmPassword"	placeholder="REPETIR A SENHA" maxlength="10" required /> 
						
						<input type="submit" name="cadastrar" value="CADASTRAR" />
					</fieldset>
				</form>
			</section>
		</section>

		<section class="form-register-details">
			<h1>Virtual Bookcase</h1>

			<p>
				ALGUM TEXTO FALANDO SOBRE O SISTEMA <br /> DE CADASTRO DE LIVROS
			</p>

			<div class="arrow">
				<a href="${pageContext.request.contextPath}/pages/login/login.jsp"> 
				<img src="${pageContext.request.contextPath}/img/return.svg" alt="Seta para voltar à tela de login" />
				</a> 
				<span>VOLTAR PARA O LOGIN</span>
			</div>
		</section>
	</section>
</body>
</html>
