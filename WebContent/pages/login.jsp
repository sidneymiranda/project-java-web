<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico"
	type="image/x-icon" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@500&display=swap"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<!-- href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" /> -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/globals.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/login.css" />

<title>Login</title>
</head>

<body>
	<div class="login">
		<aside class="login-left">
			<div class="login-left-content">
				<h1>Ainda não tem acesso à plataforma?</h1>
				<h4>Faça o seu login e tenha acesso ao mundo dos livros!</h4>
				<img src="${pageContext.request.contextPath}/img/book.svg"
					alt="Logo do sistema" class="logo" />
			</div>
		</aside>

		<section class="form-login">
			<div class="form-login-content">
				<nav class="form-login-nav">
					<a href="${pageContext.request.contextPath}/pages/createUser/newUser.jsp"
						id="cadastrar"><span>cadastrar</span></a>
				</nav>

				<div class="form-login-input">
					<h1>LOGIN</h1>

					<form action="${pageContext.request.contextPath}/authenticator" method="post" id="formLogin">
						<fieldset>
							<input 
								type="text" 
								id="registry-login" 
								name="registry"
								placeholder="matrícula" 
								autofocus 
								required 
							/> 
							<input 
								type="password" 
								id="password-login" 
								name="password"
								placeholder="senha" 
								required
							/> 
								
							<input type="submit" value="Entrar" id="login" class="btn btn-info" />
						</fieldset>
					</form>
				</div>
			</div>
		</section>
	</div>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</body>
</html>
